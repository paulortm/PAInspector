package ist.meic.pa.commands.exception;

public class InvalidValueTypeException extends CommandException {

	private static final long serialVersionUID = -2496038038522988276L;

	public InvalidValueTypeException(String type) {
		super("The new value has to be of type " + type);
	}
	
	@Override
	public String toString() {
		return this.getMessage();
	}

}
