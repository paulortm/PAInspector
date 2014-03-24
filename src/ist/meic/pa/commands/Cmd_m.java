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

	@Override
	public final void execute(Inspector insp, List<String> args)
			throws CommandException {
		if (this.checkArgs(args)) {
			try {
				ParserFactory parserFactory = new ParserFactory();
				Object currentObj = insp.obtainCurrentObj();
				Class<?> c = currentObj.getClass();
				Field field = c.getField(args.get(0));
				Parser parser = parserFactory.getParser(field.getType()
						.toString());
				field.set(currentObj, parser.parse(args.get(1)));
			} catch (NoSuchFieldException e) {
				throw new FieldNotFoundException(args.get(0));
			} catch (SecurityException e) {
				throw new RuntimeException(e.toString());
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
