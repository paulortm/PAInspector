package ist.meic.pa.commands.exception;

public class MethodNotFoundException extends CommandException {
	public MethodNotFoundException(String className, String methodName, int numberOfArgs) {
		super("The class " + className + " does not have a method named "
				+ methodName + " with " + numberOfArgs + " arguments.");
	}
}
