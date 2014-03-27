package ist.meic.pa.commands.exception;

public class SavedObjectNotFoundException extends CommandException {

	private static final long serialVersionUID = -8142461003069408376L;

	public SavedObjectNotFoundException(String objName) {
		super("There is no saved object with name" + objName);
	}

}
