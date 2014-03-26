package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.IllegalCallException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.graph.exception.EmptyGraphException;
import ist.meic.pa.graph.exception.RootReachedException;

import java.util.List;

public class Cmd_u implements Command {

	public Cmd_u() {
		super();
	}
	
	private boolean checkArgs(List<String> args) {
		if (args.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public final void execute(Inspector insp, List<String> args)
			throws CommandException {
		if (this.checkArgs(args)) {
			try {
				insp.upInGraph();
				insp.printCurrentObj();
			} catch (EmptyGraphException e) {
				throw new IllegalCallException(e.toString());
			} catch (RootReachedException e) {
				throw new IllegalCallException(e.toString());
			}
		} else {
			throw new InvalidArgumentsException("u");
		}
	}

}
