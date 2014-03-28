package ist.meic.pa.commands.exception;

public class NullObjectException extends CommandException {

	private static final long serialVersionUID = -9106164421608369246L;

	public NullObjectException() {
		super("The field you are trying to inspect is not instanciated.");
	}

}
