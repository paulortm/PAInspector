package ist.meic.pa.commands;

import java.lang.reflect.Field;
import java.util.List;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.exception.InvalidFieldValTypeException;
import ist.meic.pa.commands.exception.SavedObjectNotFoundException;
import ist.meic.pa.commands.exception.UnsupportedFieldTypeException;
import ist.meic.pa.commands.util.Parser;
import ist.meic.pa.commands.util.ParserFactory;
import ist.meic.pa.commands.util.exception.ParserInvalidValueTypeException;
import ist.meic.pa.commands.util.exception.ParserException;
import ist.meic.pa.commands.util.exception.ParserSavedObjectNotFoundException;
import ist.meic.pa.commands.util.exception.ParserUnsupportedTypeException;

public class Cmd_m extends FieldCommand {

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
				Object currentObj = insp.obtainCurrentObj();
				Field field = this.findField(insp, currentObj.getClass(),
						args.get(0));

				field.setAccessible(true);
				ParserFactory parserFactory = new ParserFactory();
				Parser parser = parserFactory.getParser(field.getType());
				field.set(currentObj,
						parser.parse(insp.getSavedObjects(), args.get(1)));

				insp.printCurrentObj();
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e.toString());
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e.toString());
			} catch (ParserUnsupportedTypeException e) {
				throw new UnsupportedFieldTypeException();
			} catch (ParserInvalidValueTypeException e) {
				throw new InvalidFieldValTypeException(e.toString());
			} catch (ParserSavedObjectNotFoundException e) {
				throw new SavedObjectNotFoundException(e.toString());
			} catch (ParserException e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new InvalidArgumentsException("m <name_of_the_field> <value>");
		}
	}
}
