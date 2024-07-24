package commands;

import java.util.ArrayList;

import scene.Editor;
import scene.Shape;

public class MoveCommand implements Command {
	int prevX;
	int prevY;
	int x;
	int y;
	boolean didOperate;
	
	public boolean canHandle(String[] command) {
		try {
			this.x = Integer.parseInt(command[1]);
			this.y = Integer.parseInt(command[2]);
			return true;
			
		} catch (NumberFormatException nfe) {
			System.out.println("ERROR: Please enter valid location.");
			return false;
		}
	}
	
	@Override
	public void execute(Editor scene) {
		int i  = scene.getCurrentSelection();
		if(i == 0) {
			System.out.println("No shape selected");
			didOperate = false;
		} else {
			i = i - 1;
			ArrayList<Shape> shapes = scene.getShapes();
			Shape selectedShape = shapes.get(i);
			prevX = selectedShape.getX();
			prevY = selectedShape.getY();
			selectedShape.setLocation(x, y);
			shapes.set(i, selectedShape);
			scene.setShapes(shapes);
			didOperate = true;
		}
		
	}
	@Override
	public void undo(Editor scene) {
		if(didOperate) {
			int i = scene.getCurrentSelection();
			ArrayList<Shape> shapes = scene.getShapes();
			Shape selectedShape = shapes.get(i - 1);
			selectedShape.setLocation(prevX, prevY);
			shapes.set(i - 1, selectedShape);
			scene.setShapes(shapes);
		}
	}
}
