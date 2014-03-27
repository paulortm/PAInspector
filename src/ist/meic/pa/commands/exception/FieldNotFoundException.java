package ist.meic.pa.commands.exception;

public class FieldNotFoundException extends CommandException {

	private static final long serialVersionUID = 6357221399136066501L;

	public FieldNotFoundException(String fieldName) {
		super("The field \"" + fieldName + "\" was not found.");
	}

}
