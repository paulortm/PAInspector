package ist.meic.pa.commands.exception;

public class InvalidMethodArgTypes extends CommandException {
	
	private static final long serialVersionUID = 7959736579614284689L;

	public InvalidMethodArgTypes() {
		super("Could not parse the given arguments to match the parameter types of the method.");
	}
}
