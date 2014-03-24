package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.exception.MethodNotFoundException;

import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Cmd_c implements Command {

	public Cmd_c() {
		super();
	}

	@Override
	public void execute(Inspector insp, List<String> args)
			throws CommandException {
		if (args.size() < 1) {
			throw new InvalidArgumentsException("c <method_name> [<args>]");
		}

		// get the methods of the currentObject
		Object currentObject = insp.obtainCurrentObj();
		Class<?> objClass = currentObject.getClass();
		Method[] objMethods = objClass.getMethods();

		// get the methods whose name match the methodName
		String methodName = args.get(0);
		int numberOfMethodArgs = args.size() - 1;
		List<Method> methodsThatMatchName = new LinkedList<Method>();
		for (Method m : objMethods) {
			if (m.getName().equals(methodName)
					&& m.getParameterTypes().length == numberOfMethodArgs)
				methodsThatMatchName.add(m);
		}

		if (methodsThatMatchName.isEmpty()) {
			throw new MethodNotFoundException(objClass.getName(), methodName,
					numberOfMethodArgs);
		}

		insp.println("The method " + methodName + " was found.");

		// parse the arguments assuming they are integer
		Object[] parsedArgs = new Object[numberOfMethodArgs];
		for (int i = 1; i < args.size(); i++) {
			parsedArgs[i - 1] = Integer.parseInt(args.get(i));
		}

		
		Object result;
		Method method = methodsThatMatchName.get(0);
		try {
			result = method.invoke(currentObject, parsedArgs);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		if(method.getReturnType() != void.class) {
			insp.modifyCurrentObj(result);
		}
	}
}
