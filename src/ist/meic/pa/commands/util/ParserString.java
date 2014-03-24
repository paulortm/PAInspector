package ist.meic.pa.commands.util;

public class ParserString implements Parser {

	protected ParserString() {
		super();
	}

	@Override
	public Object parse(String value) {
		return value;
	}

}
