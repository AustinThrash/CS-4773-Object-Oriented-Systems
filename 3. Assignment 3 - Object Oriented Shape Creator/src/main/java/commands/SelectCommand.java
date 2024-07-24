package commands;

import java.util.ArrayList;

import scene.Editor;
import scene.Shape;

public class SelectCommand implements Command {
	int prevSelect;
	int currSelect;
	boolean didOperate;
	
	
	public boolean canHandle(String[] command) {
		try {
			int i = Integer.parseInt(command[1]);
			currSelect = i;
			return true;
			
		} catch (NumberFormatException nfe) {
			System.out.println("ERROR: Please enter a valid number");
			return false;
		}
	}


	@Override
	public void execute(Editor scene) {
		prevSelect = scene.getCurrentSelection();
		ArrayList<Shape> shapes = scene.getShapes();
		if(currSelect > shapes.size()) {
			System.out.println("ERROR: invalid shape for SELECT");
			didOperate = false;
		} else {
			scene.setSelection(currSelect);
			didOperate = true;
		}
		
	}
	@Override
	public void undo(Editor scene) {
		if(didOperate) {
			scene.setSelection(prevSelect);
		}
	}
	
}
