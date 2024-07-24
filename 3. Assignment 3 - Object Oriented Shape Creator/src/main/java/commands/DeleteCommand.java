package commands;

import java.util.ArrayList;

import scene.Editor;
import scene.Shape;

public class DeleteCommand implements Command {

	Shape DeletedShape;
	int currSelection;
	boolean didOperate;
	
	
	@Override
	public void execute(Editor scene) {
		int i = scene.getCurrentSelection();
		if(i == 0) {
			System.out.println("No shape selected");
			didOperate = false;
		} else {
			
			ArrayList<Shape> shapes = scene.getShapes();
			DeletedShape = shapes.remove(i - 1);
			currSelection = i;
			scene.setSelection(0);
			scene.setShapes(shapes);
			didOperate = true;
		}
		
	}
	@Override
	public void undo(Editor scene) {
		if(didOperate) {
			ArrayList<Shape> shapes = scene.getShapes();
			shapes.add(currSelection - 1, DeletedShape);
			scene.setShapes(shapes);
		}	
	}
}
