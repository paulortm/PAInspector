package ist.meic.pa.commands.exception;

public class UnsupportedFieldTypeException extends CommandException {

	private static final long serialVersionUID = 3536573964682012143L;

	public UnsupportedFieldTypeException() {
		super("The field you are trying to modify is of an unsupported type.");
	}

}
