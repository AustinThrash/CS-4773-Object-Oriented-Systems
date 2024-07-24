package commands;

import memento.CareTaker;
import memento.Memento;

public class CommandController {
	CareTaker careTaker;
	
	public CommandController() {
		this.careTaker = new CareTaker();
	}
	
	
	public Command executeCommand(String[] command) {
		switch(command[0]) {
			case "CREATE":
				CreateCommand createCommand = new CreateCommand();
				if(createCommand.canHandle(command)) {
					Command createdShape = createCommand.getCommand();
					Memento memento = new Memento(createdShape);
					careTaker.addMemento(memento);
					return createdShape;
				} else {
					return null;
				}
				
		case "SELECT":
				SelectCommand selectCommand = new SelectCommand();
				if(selectCommand.canHandle(command)) {
					Memento memento2 = new Memento(selectCommand);
					careTaker.addMemento(memento2);
					return selectCommand;
				} else {
					return null;
				}
		case "DELETE":
				Command deleteCommand = new DeleteCommand();
				Memento memento3 = new Memento(deleteCommand);
				careTaker.addMemento(memento3);
				return deleteCommand;
		case "DRAW":
				Command drawCommand = new DrawCommand();
				Memento memento4 = new Memento(drawCommand);
				careTaker.addMemento(memento4);
				return drawCommand;
		case "DRAWSCENE":
				Command drawSceneCommand = new DrawSceneCommand();
				Memento memento5 = new Memento(drawSceneCommand);
				careTaker.addMemento(memento5);
				return drawSceneCommand;
		case "MOVE":
				MoveCommand moveCommand = new MoveCommand();
				if(moveCommand.canHandle(command)) {
					Memento memento6 = new Memento(moveCommand);
					careTaker.addMemento(memento6);
					return moveCommand;
				} else {
					return null;
				}
		case "UNDO":
				UndoCommand undoCommand = new UndoCommand();
				if(undoCommand.canHandle(careTaker)) {
					Memento memento7 = new Memento(undoCommand);
					careTaker.addMemento(memento7);
					return undoCommand;
				} else {
					return null;
				}
		case "COLOR":
			ColorCommand colorCommand = new ColorCommand();
			if(colorCommand.canHandle(command)) {
				Memento memento7 = new Memento(colorCommand);
				careTaker.addMemento(memento7);
				return colorCommand;
			} else {
				return null;
			}
		default:
				System.out.println("ERROR: Command could not be handled");
				return null;
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
