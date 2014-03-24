package ist.meic.pa.commands.exception;

public class MethodNotFoundException extends CommandException {

	private static final long serialVersionUID = -619815553971830606L;

	public MethodNotFoundException(String className, String methodName, int numberOfArgs) {
		super("The class " + className + " does not have a method named "
				+ methodName + " with " + numberOfArgs + " arguments.");
	}
}
