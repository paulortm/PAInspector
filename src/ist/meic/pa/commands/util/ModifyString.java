package ist.meic.pa.commands.util;

import java.lang.reflect.Field;

public class ModifyString implements FieldModifier {

	protected ModifyString() {
		super();
	}

	@Override
	public void modify(Object obj, Field field, String value) {
		try {
			field.set(obj, value);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}

	}

}
