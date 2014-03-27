package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.InvalidValueTypeException;
import ist.meic.pa.commands.util.exception.ParserException;

public class ParserClass implements Parser {

	@Override
	public Object parse(String value) throws ParserException {
		try {
			return Class.forName(value);
		} catch (ClassNotFoundException e) {
			throw new InvalidValueTypeException("Class");
		}
	}

}
