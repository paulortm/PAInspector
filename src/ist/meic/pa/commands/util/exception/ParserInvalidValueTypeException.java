package ist.meic.pa.commands.util.exception;

public class ParserInvalidValueTypeException extends ParserException {

	private static final long serialVersionUID = 737354523530913821L;
	private String type;
	
	public ParserInvalidValueTypeException(String type) {
		super();
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}

}
