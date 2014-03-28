package ist.meic.pa.commands.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReflectionHelper {

	/*
	 * Returns all the public, protected and private methods of class clazz and
	 * its super classes
	 */
	public static List<Method> getAllMethodsOf(Class<?> clazz) {
		Method[] classMethods = clazz.getDeclaredMethods();
		List<Method> allMethods;
		if (clazz.equals(Object.class)) {
			allMethods = new LinkedList<Method>();
		} else {
			allMethods = getAllMethodsOf(clazz.getSuperclass());
		}
		for (Method m : classMethods) {
			allMethods.add(m);
		}
		return allMethods;
	}

	/*
	 * Returns the field with name fieldName of class clazz and its superclasses
	 */
	public static Field findField(Class<?> clazz, String fieldName)
			throws NoSuchFieldException {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			return field;
		} catch (NoSuchFieldException e) {
			if (clazz != Object.class)
				return findField(clazz.getSuperclass(), fieldName);
			else
				throw e;
		}
	}

	/*
	 * Returns a map that associates a class name of the clazz hierarchy to a
	 * field with name fieldName. The returned map has all the fields with name
	 * fieldName.
	 * This method is used to get the shadowed fields.
	 */
	public static Map<String, Field> findAllFields(Class<?> clazz, String fieldName) {
		if (clazz == Object.class) {
			// stop the recursion
			return new HashMap<String, Field>();
		} else {
			Map<String, Field> fields = findAllFields(
					clazz.getSuperclass(), fieldName);
			try {
				Field f = clazz.getDeclaredField(fieldName);
				fields.put(clazz.getName(), f);
			} catch (NoSuchFieldException e) {
				// The field wasn't added to fields
				// => return the map as it was received from the superclass
			} catch (SecurityException e) {
				throw new RuntimeException(e);
			}
			return fields;
		}
	}
}
