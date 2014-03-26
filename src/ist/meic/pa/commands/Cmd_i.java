package ist.meic.pa.commands;

import java.util.List;

import ist.meic.pa.Inspector;

import java.lang.reflect.Field;

import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.FieldNotFoundException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.util.Parser;
import ist.meic.pa.commands.util.ParserFactory;
import ist.meic.pa.commands.util.exception.ParserException;


public class Cmd_i implements Command {

	public Cmd_i() {
		super();
	}

	private boolean checkArgs(List<String> args) {
		return !(args.size() == 1);
	}

	private void findSetField(Class<?> clazz, Object obj,Inspector insp, String fieldName) throws IllegalArgumentException,
			 IllegalAccessException, ParserException, NoSuchFieldException, CommandException{
		try {
			Field field = clazz.getDeclaredField(fieldName);  
			field.setAccessible(true);
			insp.modifyCurrentObj(field.get(obj));
			field.setAccessible(false);			
			insp.printCurrentObj();			
			
		} catch (NoSuchFieldException e) {
			if (clazz != Object.class)
				this.findSetField(clazz.getSuperclass(), obj,insp,fieldName);
			else
				throw new InvalidArgumentsException("i <name_of_the_field>");
		}
	}

	
	@Override
	public void execute(Inspector insp, List<String> args) throws CommandException {
		if (this.checkArgs(args)) {
			throw new InvalidArgumentsException("i <name_of_the_field>");
		}
		
		String fieldName = args.get(0);
		try {			
			Object obj = insp.obtainCurrentObj();			
			this.findSetField(obj.getClass(),obj,insp,fieldName);
			
		} catch (NoSuchFieldException e) {
			throw new FieldNotFoundException(fieldName);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ParserException e) {			
			throw new RuntimeException(e);
		}
	}
}