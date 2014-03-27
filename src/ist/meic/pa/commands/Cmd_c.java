package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.exception.InvalidMethodArgTypesException;
import ist.meic.pa.commands.exception.MethodNotFoundException;
import ist.meic.pa.commands.exception.UnsupportedMethodArgTypeException;
import ist.meic.pa.commands.util.Parser;
import ist.meic.pa.commands.util.ParserFactory;
import ist.meic.pa.commands.util.ReflectionHelper;
import ist.meic.pa.commands.util.exception.ParserException;
import ist.meic.pa.commands.util.exception.UnsupportedTypeException;

import java.util.Iterator;
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

		Object currentObject = insp.obtainCurrentObj();
		Class<?> objClass = currentObject.getClass();

		// Get the methods whose name and number of arguments 
		// match the user input
		String methodName = args.get(0);
		int numberOfMethodArgs = args.size() - 1;
		List<Method> allMethods = ReflectionHelper.getAllMethodsOf(objClass);
		List<Method> methodsThatMatch = 
				methodsThatMatchNameAndSize(allMethods, methodName, numberOfMethodArgs); 

		if (methodsThatMatch.isEmpty()) {
			throw new MethodNotFoundException(objClass.getName(), methodName,
					numberOfMethodArgs);
		}
		
		// parse arguments of the method from the input
		ParserFactory parserFactory = new ParserFactory();
		Iterator<Method> methodsIt = methodsThatMatch.iterator();
		List<Object> parsedArguments = null;
		Class<?>[] argumentTypes;
		Method m;
		Method method = null;
		Parser parser = null;
		// Try to parse the arguments for each method.
		// Stop if could parse all arguments of the method.
		do {
			m = methodsIt.next();
			try {
				parsedArguments = new LinkedList<Object>();
				argumentTypes = m.getParameterTypes();
				for(int i = 0; i < args.size() - 1; i++) {
					parser = parserFactory.getParser(argumentTypes[i]);
					parsedArguments.add(parser.parse(args.get(i+1)));
				}
				method = m;
			} catch (UnsupportedTypeException e) {
				throw new UnsupportedMethodArgTypeException(e.getType());
			} catch (ParserException e) {
				// An argument could not be parsed to the parameter type of the method
				// Go to the next method
			}
		} while(method == null && methodsIt.hasNext());
		
		if(method == null) {
			throw new InvalidMethodArgTypesException(methodsThatMatch);
		}

		try {
			method.setAccessible(true);
			Object result = method.invoke(currentObject, parsedArguments.toArray());
			insp.println("called " + method.toString());
			if(method.getReturnType() != void.class) {
				insp.modifyCurrentObj(result);
			}
			insp.printCurrentObj();
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<Method> methodsThatMatchNameAndSize(List<Method> objMethods, String methodName, int numberOfArgs){
		List<Method> methodsThatMatch = new LinkedList<Method>();
		for (Method m : objMethods) {
			if (m.getName().equals(methodName)
					&& m.getParameterTypes().length == numberOfArgs)
				methodsThatMatch.add(m);
		}
		return methodsThatMatch;
	}
	
	
}
