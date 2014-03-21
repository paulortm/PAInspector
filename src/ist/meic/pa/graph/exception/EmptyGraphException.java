package ist.meic.pa.graph.exception;

public class EmptyGraphException extends Exception {

	private static final long serialVersionUID = -1448317534063745200L;

	public EmptyGraphException() {
		super("The graph is empty");
	}
	
	@Override
	public String toString() {
		return this.getMessage();
	}

}
