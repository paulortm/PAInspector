package ist.meic.pa.commands.util;

import java.util.Map;

import ist.meic.pa.commands.util.exception.ParserException;
import ist.meic.pa.commands.util.exception.ParserSavedObjectNotFoundException;

/*
 * This class is used to parse the string arguments of the commands and tries to transform them into an Object.
 * The subclass determines the type of the Object. 
 */
public abstract class Parser {

	private Map<String, Object> savedObjects;

	public Parser() {
		super();
		this.savedObjects = null;
	}

	protected Map<String, Object> getSavedObjects() {
		return savedObjects;
	}

	protected void setSavedObjects(Map<String, Object> savedObjects) {
		this.savedObjects = savedObjects;
	}

	public Object parse(Map<String, Object> savedObjects, String value)
			throws ParserException {
		this.setSavedObjects(savedObjects);
		if (value.charAt(0) == '\'') {
			String objectName = value.substring(1);
			try {
				return savedObjects.get(objectName);
			} catch (NullPointerException e) {
				throw new ParserSavedObjectNotFoundException(objectName);
			}
		} else
			return this.dispatch(value);
	}

	protected abstract Object dispatch(String value) throws ParserException;

}
