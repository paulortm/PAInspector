package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.ParserInvalidValueTypeException;
import ist.meic.pa.commands.util.exception.ParserException;

public class ParserClass extends Parser {

	@Override
	protected Object dispatch(String value) throws ParserException {
		try {
			return Class.forName(value);
		} catch (ClassNotFoundException e) {
			throw new ParserInvalidValueTypeException("Class");
		}
	}

}
