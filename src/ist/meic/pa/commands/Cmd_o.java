package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.exception.NonExistentObjectException;

import java.util.List;

public class Cmd_o implements Command {

	public boolean checkArgs(List<String> args) {
		return args.size() == 1;
	}

	@Override
	public void execute(Inspector insp, List<String> args)
			throws CommandException {
		
		if (!this.checkArgs(args)) {
			throw new InvalidArgumentsException("o <name_of_the_saved_object>");
		}
		
		String objectName = args.get(0);
		if(!insp.isObjectSaved(objectName)) {
			throw new NonExistentObjectException(objectName);
		}
		
		insp.modifyCurrentObj(insp.getSavedObject(objectName));
		insp.printCurrentObj();
	}

}
