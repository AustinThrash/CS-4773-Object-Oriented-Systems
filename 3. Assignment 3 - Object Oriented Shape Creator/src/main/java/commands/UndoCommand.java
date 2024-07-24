package commands;

import memento.CareTaker;
import memento.Memento;
import scene.Editor;

public class UndoCommand implements Command {
	
	Command currCommand;
	
	public boolean canHandle(CareTaker caretaker) {
		if(caretaker.hasHistory()) {
			Memento memento = caretaker.getMemento();
			currCommand = memento.getSavedCommand();
			return true;
		} else {
			System.out.println("ERROR: Nothing to undo");
			return false;
		}
	}
	
	@Override
	public void execute(Editor scene) {
		currCommand.undo(scene);		
	}
	@Override
	public void undo(Editor scene) {
		
	}

}
