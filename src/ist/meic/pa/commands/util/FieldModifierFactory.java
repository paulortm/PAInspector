package ist.meic.pa.commands.util;

import ist.meic.pa.commands.exception.UnsupportedFieldTypeException;

public class FieldModifierFactory {

	public FieldModifier getFieldModifier(String fieldModifierType)
			throws UnsupportedFieldTypeException {
		if (fieldModifierType.equals("int")
				|| fieldModifierType.equals("class java.lang.Integer")) {
			return new ModifyInt();
		} else if (fieldModifierType.equals("class java.lang.String")) {
			return new ModifyString();
		} else if (fieldModifierType.equals("boolean")
				|| fieldModifierType.equals("class java.lang.Boolean")) {
			return new ModifyBoolean();
		} else {
			throw new UnsupportedFieldTypeException();
		}
	}
}
