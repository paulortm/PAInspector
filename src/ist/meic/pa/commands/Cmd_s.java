package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;

import java.util.List;

public class Cmd_s implements Command {
	
	public boolean checkArgs(List<String> args) {
		return args.size() == 1;
	}

	@Override
	public void execute(Inspector insp, List<String> args)
			throws CommandException {
		
		if(!this.checkArgs(args)) {
			throw new InvalidArgumentsException("s <name_of_var>");
		}
		
		
		
	}

}
