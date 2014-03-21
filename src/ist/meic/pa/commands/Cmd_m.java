package ist.meic.pa.commands;

import java.lang.reflect.Field;
import java.util.List;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.FieldNotFoundException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.util.FieldModifierFactory;

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
				FieldModifierFactory fieldModFactory = new FieldModifierFactory();
				Object currentObj = insp.obtainCurrentObj();
				Class<?> c = currentObj.getClass();
				Field field = c.getField(args.get(0));
				fieldModFactory.getFieldModifier(field.getType().toString())
						.modify(currentObj, field, args.get(1));
			} catch (NoSuchFieldException e) {
				throw new FieldNotFoundException(args.get(0));
			} catch (SecurityException e) {
				throw new RuntimeException(e.toString());
			}
		} else {
			throw new InvalidArgumentsException("m <name_of_the_field> <value>");
		}
	}

}
