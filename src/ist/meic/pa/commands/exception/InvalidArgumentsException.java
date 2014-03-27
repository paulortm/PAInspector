package ist.meic.pa.commands.exception;

public class InvalidArgumentsException extends CommandException {

	private static final long serialVersionUID = -2285716015075099703L;

	public InvalidArgumentsException(String usage) {
		super("Invalid arguments. Usage: " + usage);
	}

}
