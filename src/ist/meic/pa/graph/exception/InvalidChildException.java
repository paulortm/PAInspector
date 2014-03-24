package ist.meic.pa.graph.exception;

public class InvalidChildException extends GraphException {

	private static final long serialVersionUID = -3346199228408771980L;

	public InvalidChildException() {
		super("The index of the value you choose is not valid.");
	}

	@Override
	public String toString() {
		return this.getMessage();
	}

}
