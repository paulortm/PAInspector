package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.FieldNotFoundException;
import ist.meic.pa.commands.exception.InvalidOptionException;
import ist.meic.pa.commands.util.ReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * A FieldCommand is a command that operates on fields
 */
public abstract class FieldCommand implements Command {

	@Override
	abstract public void execute(Inspector insp, List<String> args)
			throws CommandException;

	/*
	 * Finds the field named fieldName on class clazz. If there are shadowed
	 * fields with that name the user is asked to chose one of them.
	 */
	public Field findField(Inspector insp, Class<?> clazz, String fieldName)
			throws FieldNotFoundException, InvalidOptionException {
		Map<String, Field> fields = ReflectionHelper.findAllFields(clazz,
				fieldName);
		Field field;
		if (fields.size() == 0) {
			throw new FieldNotFoundException(fieldName);
		} else if (fields.size() == 1) {
			// get the only element of the map
			field = fields.values().iterator().next();
		} else {
			// ask user to chose the which shadowed field is to be inspected
			field = this.askFieldFromUser(insp, fields);
		}
		return field;
	}

	private Field askFieldFromUser(Inspector insp, Map<String, Field> fields)
			throws InvalidOptionException {
		insp.println("There are serveral fields with that name. To which class's field do you wish to apply this command?");
		Set<Map.Entry<String, Field>> entrys = fields.entrySet();
		String userOption;
		Field f;
		for (Map.Entry<String, Field> entry : entrys) {
			f = entry.getValue();
			insp.println(entry.getKey() + ":\t"
					+ Modifier.toString(f.getModifiers()) + " " + f.getType()
					+ " " + f.getName());
		}
		insp.print("Choose a class (type the name of the class): ");
		userOption = insp.scanLine();
		if (!fields.containsKey(userOption)) {
			throw new InvalidOptionException(userOption);
		}
		return fields.get(userOption);
	}

}
