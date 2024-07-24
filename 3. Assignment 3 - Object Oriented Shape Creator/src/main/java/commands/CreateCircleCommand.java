package commands;

import scene.Circle;
import scene.Editor;
import scene.Shape;

public class CreateCircleCommand implements Command {
	int radius;
	Shape circle;
	
	public boolean canHandle(String[] command) {
		try {
			radius = Integer.parseInt(command[2]);
			return true;
			
		} catch (NumberFormatException nfe) {
			System.out.println("ERROR: Please enter valid radius.");
			return false;
		}
	}

	@Override
	public void execute(Editor scene) {
		int[] values = {radius};
		Shape circle = new Circle();
		circle.createShape(values);
		this.circle = circle;
		scene.addShape(circle);
		
	}
	@Override
	public void undo(Editor scene) {
		scene.removeShape(this.circle);
	}
}
