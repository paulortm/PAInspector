package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.InvalidValueTypeException;

public class ParserInt implements Parser {

	protected ParserInt() {
		super();
	}

	@Override
	public Object parse(String value) throws InvalidValueTypeException {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new InvalidValueTypeException("int");
		}
	}

}
