package ist.meic.pa.commands;

import ist.meic.pa.Inspector;
import ist.meic.pa.commands.exception.CommandException;
import ist.meic.pa.commands.exception.IllegalCallException;
import ist.meic.pa.commands.exception.InvalidArgumentsException;
import ist.meic.pa.commands.exception.InvalidOptionException;
import ist.meic.pa.commands.exception.NoChildrenException;
import ist.meic.pa.graph.exception.EmptyGraphException;
import ist.meic.pa.graph.exception.InvalidChildException;

import java.util.List;

public class Cmd_d implements Command {

	public Cmd_d() {
		super();
	}

	private boolean checkArgs(List<String> args) {
		if (args.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public void execute(Inspector insp, List<String> args)
			throws CommandException {
		if (this.checkArgs(args)) {
			try {
				List<Object> options = insp.getDownInGraphOptions();
				Integer optNumber = 1;
				if (options.size() > 0) {
					for (Object obj : options) {
						insp.println("Option " + optNumber++ + ":"
								+ obj.toString() + "of class"
								+ obj.getClass().toString());
					}
					insp.print("Choose one option (type the number of the option):");
					String opt = insp.scanLine();
					insp.downInGraph(Integer.parseInt(opt) - 1);
					insp.printCurrentObj();
				} else {
					throw new NoChildrenException();
				}
			} catch (NumberFormatException e) {
				throw new InvalidOptionException(e.toString());
			} catch (EmptyGraphException e) {
				throw new IllegalCallException(e.toString());
			} catch (InvalidChildException e) {
				throw new InvalidOptionException(e.toString());
			}
		} else {
			throw new InvalidArgumentsException("d");
		}
	}

}
