package ist.meic.pa.commands.util;

import java.lang.reflect.Field;

import ist.meic.pa.commands.exception.CommandException;

public interface FieldModifier {

	public void modify(Object obj, Field field, String value)
			throws CommandException;

}
