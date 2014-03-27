package ist.meic.pa.commands.util.exception;

public class ParserUnsupportedTypeException extends ParserException {

	private static final long serialVersionUID = 1905260965506290735L;
	private String type;

	public ParserUnsupportedTypeException(String type) {
		super();
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
