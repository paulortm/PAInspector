package ist.meic.pa.commands;

import java.util.List;

import ist.meic.pa.Inspector;

import java.lang.reflect.Field;

import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.exception.NullObjectException;

public class Cmd_i extends FieldCommand {

	public Cmd_i() {
		super();
	}

	private boolean checkArgs(List<String> args) {
		return (args.size() == 1);
	}

	@Override
	public void execute(Inspector insp, List<String> args)
			throws CommandException {
		if (!this.checkArgs(args)) {
			throw new InvalidArgumentsException("i <name_of_the_field>");
		}

		String fieldName = args.get(0);
		try {
			Object obj = insp.obtainCurrentObj();
			Field field = findField(insp, obj.getClass(), fieldName);
			field.setAccessible(true);
			Object newObj = field.get(obj);
			if (newObj == null)
				throw new NullObjectException();
			insp.modifyCurrentObj(newObj);

			insp.printCurrentObj();
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}