package ist.meic.pa.commands.util;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class ReflectionHelper {
	// returns all the public, protected and private methods of class clazz and its super classes
	public static List<Method> getAllMethodsOf(Class<?> clazz) {
		Method[] classMethods = clazz.getDeclaredMethods();
		List<Method> allMethods;
		if(clazz.equals(Object.class)) {
			allMethods = new LinkedList<Method>();
		} else {
			allMethods = getAllMethodsOf(clazz.getSuperclass());
		}
		for(Method m: classMethods) {
			allMethods.add(m);
		}
		return allMethods;
	}
}
