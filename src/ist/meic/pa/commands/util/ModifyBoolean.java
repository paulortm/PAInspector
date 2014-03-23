package ist.meic.pa.commands.util;

import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.InvalidValueTypeException;

import java.lang.reflect.Field;

public class ModifyBoolean implements FieldModifier {
	
	protected ModifyBoolean() {
		super();
	}

	@Override
	public void modify(Object obj, Field field, String value)
			throws CommandException {
		try {
			if (value.equals("true")) {
				field.set(obj, new Boolean(true));
			} else if (value.equals("false")) {
				field.set(obj, new Boolean(false));
			} else {
				throw new InvalidValueTypeException("boolean");
			}
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
