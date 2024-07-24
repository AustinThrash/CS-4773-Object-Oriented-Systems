package commands;

import java.util.ArrayList;

import scene.Editor;
import scene.Shape;

public class DrawCommand implements Command {

	
	@Override
	public void execute(Editor scene) {
		int i = scene.getCurrentSelection();
		if(i == 0) {
			System.out.println("No shape selected");
		} else {
			ArrayList<Shape> shapes = scene.getShapes();
			Shape shape = shapes.get(i - 1);
			String shapeString = shape.toString();
			System.out.print(shapeString);
			
		}
		
	}
	@Override
	public void undo(Editor scene) {
		
	}

}
