package ist.meic.pa.commands.exception;

public class UnsupportedMethodArgTypeException extends CommandException {

	private static final long serialVersionUID = -8269610741522983656L;

	public UnsupportedMethodArgTypeException(String type) {
		super("Does not support arguments of methods of class " + type + ".");
	}
}
