package ist.meic.pa.commands.exception;

public class InvalidOptionException extends CommandException {

	private static final long serialVersionUID = -2730900079918392341L;

	public InvalidOptionException(String msg) {
		super("Your option is not valid: " + msg);
	}

	@Override
	public String toString() {
		return this.getMessage();
	}

}
