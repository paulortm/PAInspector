package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.InvalidValueTypeException;
import ist.meic.pa.commands.util.exception.ParserException;

public class ParserFloat implements Parser {

	@Override
	public Object parse(String value) throws ParserException {
		try {
			return Float.parseFloat(value);
		} catch(NumberFormatException e) {
			throw new InvalidValueTypeException("float");
		}
	}

}
