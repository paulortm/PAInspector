package ist.meic.pa.commands.exception;

public class InvalidFieldValTypeException extends CommandException {

	private static final long serialVersionUID = -2496038038522988276L;

	public InvalidFieldValTypeException(String type) {
		super("The new value has to be of type " + type);
	}

}
