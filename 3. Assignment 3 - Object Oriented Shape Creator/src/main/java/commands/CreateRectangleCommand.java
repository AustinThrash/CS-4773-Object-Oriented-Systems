package commands;

import scene.Editor;
import scene.Rectangle;
import scene.Shape;

public class CreateRectangleCommand implements Command {
	
	private int width;
	private int height;
	Shape Rectangle;
	
	public boolean canHandle(String[] command) {
		try {
			width = Integer.parseInt(command[2]);
			height = Integer.parseInt(command[3]);
			return true;
			
		} catch (NumberFormatException nfe) {
			System.out.println("ERROR: Please enter valid width and height.");
			return false;
		}
	}

	@Override
	public void execute(Editor scene) {
		int[] values = {width, height};
		Shape rectangle = new Rectangle();
		rectangle.createShape(values);
		this.Rectangle = rectangle;
		scene.addShape(rectangle);
		
	}
	@Override
	public void undo(Editor scene) {
		scene.removeShape(this.Rectangle);
	}
}
