package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.UnsupportedTypeException;

public class ParserFactory {

	public Parser getParser(Class<?> clazz) throws UnsupportedTypeException {
		if (clazz.equals(int.class)
				|| clazz.equals(java.lang.Integer.class)) {
			return new ParserInt();
		} else if (clazz.equals(java.lang.String.class)) {
			return new ParserString();
		} else if (clazz.equals(boolean.class)
				|| clazz.equals(java.lang.Boolean.class)) {
			return new ParserBoolean();
		} else if (clazz.equals(float.class)
				|| clazz.equals(java.lang.Float.class)) {
			return new ParserFloat();
		} else if (clazz.equals(Class.class)) {
			return new ParserClass();
		} else if (clazz.isArray()) {
			return new ParserArray(clazz.getComponentType());
		} else {
			throw new UnsupportedTypeException(clazz.toString());
		}
	}
}
