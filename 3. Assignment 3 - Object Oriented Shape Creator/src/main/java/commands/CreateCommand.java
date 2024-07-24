package commands;

import scene.Editor;

public class CreateCommand implements Command {
	Command command;
	
	public boolean canHandle(String[] command) {
		if(command[1].equalsIgnoreCase("rectangle")) {
			CreateRectangleCommand createRectangle = new CreateRectangleCommand();
			if(createRectangle.canHandle(command)) {
				this.command = createRectangle;
				return true;
			} else {
				return false;
			}
		} else if(command[1].equalsIgnoreCase("circle")) {
			CreateCircleCommand createCircle = new CreateCircleCommand();
			if(createCircle.canHandle(command)) {
				this.command = createCircle;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public Command getCommand() {
		return this.command;
	}
	
	@Override
	public void execute(Editor scene) {
		
		
	}

	@Override
	public void undo(Editor scene) {
		// TODO Auto-generated method stub
		
	}

	
}
