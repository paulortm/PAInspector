package ist.meic.pa.graph.exception;

public class RootReachedException extends Exception {

	private static final long serialVersionUID = -4540959695966602901L;

	public RootReachedException() {
		super("Root reached");
	}
	
	@Override
	public String toString() {
		return this.getMessage();
	}

}