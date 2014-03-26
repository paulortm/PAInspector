package ist.meic.pa.commands.exception;

import java.lang.reflect.Method;
import java.util.List;

public class InvalidMethodArgTypesException extends CommandException {
	
	private static final long serialVersionUID = 7959736579614284689L;

	public InvalidMethodArgTypesException(List<Method> possibleMethods) {
		super("Could not parse the given arguments to match the parameter types of the method." + printMethods(possibleMethods));
	}
	
	private static String printMethods(List<Method> methods) {
		String str = " Possible Methods: \n";
		for(Method m: methods) {
			str += "-" + m.toString() + "\n"; 
		}
		return str;
	}
}
