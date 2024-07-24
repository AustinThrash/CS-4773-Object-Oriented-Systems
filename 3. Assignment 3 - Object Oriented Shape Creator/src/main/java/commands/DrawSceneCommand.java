package commands;

import java.util.ArrayList;

import scene.Editor;
import scene.Shape;

public class DrawSceneCommand implements Command {

	@Override
	public void execute(Editor scene) {
		ArrayList<Shape> shapes = scene.getShapes();
		int i  = shapes.size();
		if(i == 0) {
			System.out.println("No shapes to draw");
		} else {
			for(int j = 0; j < i; j++) {
				Shape shape = shapes.get(j);
				String shapeString = shape.toString();
				System.out.print(shapeString);
			}
			
		}
		
	}
	
	public void undo(Editor scene) {
		
	}

}
