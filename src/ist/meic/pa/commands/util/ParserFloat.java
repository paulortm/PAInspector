package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.ParserInvalidValueTypeException;
import ist.meic.pa.commands.util.exception.ParserException;

public class ParserFloat extends Parser {

	@Override
	protected Object dispatch(String value) throws ParserException {
		try {
			return Float.parseFloat(value);
		} catch (NumberFormatException e) {
			throw new ParserInvalidValueTypeException("float");
		}
	}

}
