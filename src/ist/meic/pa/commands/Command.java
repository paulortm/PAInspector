package ist.meic.pa.commands;

import java.util.List;

import ist.meic.pa.Inspector;

public interface Command {

	public void execute(Inspector insp, List<String> args);
}
