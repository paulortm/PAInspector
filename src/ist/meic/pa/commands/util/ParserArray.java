package ist.meic.pa.commands.util;

import java.lang.reflect.Array;

import ist.meic.pa.commands.util.exception.ParserException;

public class ParserArray implements Parser {
	private Class<?> elementType;
	
	public ParserArray(Class<?> elementType) {
		this.elementType = elementType;
	}

	@Override
	public Object parse(String value) throws ParserException {
		// Array strings should begin with '[' and end with ']'.
		String[] elements = value.split(" ");
		
		ParserFactory factory = new ParserFactory();
		Parser parser = factory.getParser(this.elementType);
		
		Object parsedArray = Array.newInstance(this.elementType, elements.length);
		for(int i = 0; i < elements.length; i++) {
			Object parsedObj = parser.parse(elements[i]);
			Array.set(parsedArray, i, parsedObj);
		}
		return parsedArray;
	}
}
