package ist.meic.pa.commands.util.exception;

public class ParserSavedObjectNotFoundException extends ParserException {

	private static final long serialVersionUID = -7513320019208119955L;
	private String objName;

	public ParserSavedObjectNotFoundException(String objName) {
		super();
		this.objName = objName;
	}

	@Override
	public String toString() {
		return this.objName;
	}

}
