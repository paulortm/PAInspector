package ist.meic.pa.commands.exception;

public abstract class CommandException extends Exception {

	private static final long serialVersionUID = -1416923458462490476L;

	public CommandException(String message) {
		super(message);
	}

}
