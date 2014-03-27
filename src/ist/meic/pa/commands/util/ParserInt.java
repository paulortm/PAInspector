package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.ParserInvalidValueTypeException;

public class ParserInt extends Parser {

	@Override
	protected Object dispatch(String value) throws ParserInvalidValueTypeException {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new ParserInvalidValueTypeException("int");
		}
	}

}
