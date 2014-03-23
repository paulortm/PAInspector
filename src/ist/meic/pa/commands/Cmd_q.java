package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;

import java.util.List;

public class Cmd_q implements Command {

	public Cmd_q() {
		super();
	}

	@Override
	public void execute(Inspector insp, List<String> args)
			throws CommandException {
		insp.stopInspecting();
	}

}
