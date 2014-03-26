package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.IllegalUpCallException;
import ist.meic.pa.graph.exception.EmptyGraphException;
import ist.meic.pa.graph.exception.RootReachedException;

import java.util.List;

public class Cmd_u implements Command {

	public Cmd_u() {
		super();
	}

	@Override
	public final void execute(Inspector insp, List<String> args)
			throws CommandException {
		try {
			insp.upInGraph();
			insp.printCurrentObj();
		} catch (EmptyGraphException e) {
			throw new IllegalUpCallException(e.toString());
		} catch (RootReachedException e) {
			throw new IllegalUpCallException(e.toString());
		}
	}

}
