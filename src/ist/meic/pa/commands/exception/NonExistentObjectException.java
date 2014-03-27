package ist.meic.pa.commands.exception;

public class NonExistentObjectException extends CommandException {

	private static final long serialVersionUID = -3436913792591000065L;

	public NonExistentObjectException(String objectName) {
		super("There is no object for the name \"" + objectName + "\"");
	}

}
