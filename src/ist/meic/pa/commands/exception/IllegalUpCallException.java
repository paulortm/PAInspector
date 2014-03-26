package ist.meic.pa.commands.exception;

public class IllegalUpCallException extends CommandException {

	private static final long serialVersionUID = -2640294283862897787L;

	public IllegalUpCallException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return this.getMessage();
	}

}
