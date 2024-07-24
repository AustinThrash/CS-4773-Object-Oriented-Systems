package memento;

import commands.Command;

public class Memento {
	private Command command;
	
	public Memento(Command commandToSave) {
		command = commandToSave;
	}
	
	public Command getSavedCommand() { return command; }
	
}
