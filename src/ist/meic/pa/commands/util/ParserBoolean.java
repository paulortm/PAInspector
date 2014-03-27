package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.ParserInvalidValueTypeException;

public class ParserBoolean extends Parser {

	@Override
	protected Object dispatch(String value) throws ParserInvalidValueTypeException {
		if (value.equals("true")) {
			return new Boolean(true);
		} else if (value.equals("false")) {
			return new Boolean(false);
		} else {
			throw new ParserInvalidValueTypeException("boolean");
		}
	}

}
