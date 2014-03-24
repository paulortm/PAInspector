package ist.meic.pa.commands.util;

import ist.meic.pa.commands.util.exception.ParserException;

public interface Parser {

	public Object parse(String value) throws ParserException;

}
