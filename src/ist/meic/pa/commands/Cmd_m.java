package ist.meic.pa.commands;

import java.lang.reflect.Field;
import java.util.List;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.FieldNotFoundException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.exception.InvalidFieldValTypeException;
import ist.meic.pa.commands.exception.UnsupportedFieldTypeException;
import ist.meic.pa.commands.util.Parser;
import ist.meic.pa.commands.util.ParserFactory;
import ist.meic.pa.commands.util.exception.InvalidValueTypeException;
import ist.meic.pa.commands.util.exception.ParserException;
import ist.meic.pa.commands.util.exception.UnsupportedTypeException;

public class Cmd_m implements Command {

	public Cmd_m() {
		super();
	}

	private boolean checkArgs(List<String> args) {
		if (args.size() == 2)
			return true;
		else
			return false;
	}

	private void findSetField(Class<?> clazz, Object obj, String fieldName,
			String newValue) throws IllegalArgumentException,
			IllegalAccessException, ParserException, NoSuchFieldException {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			ParserFactory parserFactory = new ParserFactory();
			Parser parser = parserFactory.getParser(field.getType());
			field.set(obj, parser.parse(newValue));
			field.setAccessible(false);
		} catch (NoSuchFieldException e) {
			if (clazz != Object.class)
				this.findSetField(clazz.getSuperclass(), obj, fieldName,
						newValue);
			else
				throw e;
		}

	}

	@Override
	public final void execute(Inspector insp, List<String> args)
			throws CommandException {
		if (this.checkArgs(args)) {
			try {
				Object currentObj = insp.obtainCurrentObj();
				this.findSetField(currentObj.getClass(), currentObj,
						args.get(0), args.get(1));
			} catch (NoSuchFieldException e) {
				throw new FieldNotFoundException(args.get(0));
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e.toString());
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e.toString());
			} catch (UnsupportedTypeException e) {
				throw new UnsupportedFieldTypeException();
			} catch (InvalidValueTypeException e) {
				throw new InvalidFieldValTypeException(e.toString());
			} catch (ParserException e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new InvalidArgumentsException("m <name_of_the_field> <value>");
		}
	}

}
