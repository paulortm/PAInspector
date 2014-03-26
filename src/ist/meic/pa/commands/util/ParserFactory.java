package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.UnsupportedTypeException;

public class ParserFactory {

	public Parser getParser(String parserType) throws UnsupportedTypeException {
		if (parserType.equals("int")
				|| parserType.equals("class java.lang.Integer")) {
			return new ParserInt();
		} else if (parserType.equals("class java.lang.String")) {
			return new ParserString();
		} else if (parserType.equals("boolean")
				|| parserType.equals("class java.lang.Boolean")) {
			return new ParserBoolean();
		} else if (parserType.equals("float")
				|| parserType.equalsIgnoreCase("class java.lang.Float")) {
			return new ParserFloat();
		} else {
			throw new UnsupportedTypeException(parserType);
		}
	}
}
