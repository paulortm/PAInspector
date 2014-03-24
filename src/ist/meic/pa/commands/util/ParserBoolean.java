package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.InvalidValueTypeException;

public class ParserBoolean implements Parser {

	protected ParserBoolean() {
		super();
	}

	@Override
	public Object parse(String value) throws InvalidValueTypeException {
		if (value.equals("true")) {
			return new Boolean(true);
		} else if (value.equals("false")) {
			return new Boolean(false);
		} else {
			throw new InvalidValueTypeException("boolean");
		}
	}

}
