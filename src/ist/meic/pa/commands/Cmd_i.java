package ist.meic.pa.commands;

import java.util.List;
import ist.meic.pa.Inspector;
import java.lang.reflect.Field;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.FieldNotFoundException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;


public class Cmd_i implements Command {

	public Cmd_i() {
		super();
	}

	private boolean checkArgs(List<String> args) {
		return !(args.size() == 1);
	}

	@Override
	public void execute(Inspector insp, List<String> args) throws CommandException {
		if (this.checkArgs(args)) {
			throw new InvalidArgumentsException("i <name_of_the_field>");
		}
		
		String fieldName = args.get(0);
		try {
			// pega o objecto corrente
			Object obj = insp.obtainCurrentObj();

			// pega a classe do objecto
			Class<?> clazz = obj.getClass();
			
			// pega o atributo name do obj
			Field field = clazz.getDeclaredField(fieldName);

			// adiciona o obj como recente
			field.setAccessible(true);
			insp.modifyCurrentObj(field.get(obj));
			field.setAccessible(false);
			
			insp.printCurrentObj();
			
		} catch (NoSuchFieldException e) {
			throw new FieldNotFoundException(fieldName);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}