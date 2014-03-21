package ist.meic.pa.exception;



public class CommandNotFound extends Exception {
	private String commandName;
	
	public CommandNotFound(String commandName) {
		super("The command " + commandName + " does not exist.");
		this.commandName = commandName;
	}
	
	public String getCommandName() { return this.commandName; }
}
