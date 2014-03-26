package ist.meic.pa.commands.exception;

public class NoChildrenException extends CommandException {

	private static final long serialVersionUID = 1721267531569731857L;

	public NoChildrenException() {
		super("The current node in the graph has no childrens.");
	}
	
	@Override
	public String toString() {
		return this.getMessage();
	}

}
