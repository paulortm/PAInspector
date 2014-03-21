package ist.meic.pa.commands;

import java.util.List;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;

public interface Command {

	public void execute(Inspector insp, List<String> args)
			throws CommandException;
}
