package ist.meic.pa.commands.util;

import ist.meic.pa.commands.exception.InvalidValueTypeException;

import java.lang.reflect.Field;

public class ModifyInt implements FieldModifier {

	protected ModifyInt() {
		super();
	}

	@Override
	public void modify(Object obj, Field field, String value)
			throws InvalidValueTypeException {
		try {
			int valueInt = Integer.parseInt(value);
			field.setInt(obj, valueInt);
		} catch (NumberFormatException e) {
			throw new InvalidValueTypeException("int");
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
