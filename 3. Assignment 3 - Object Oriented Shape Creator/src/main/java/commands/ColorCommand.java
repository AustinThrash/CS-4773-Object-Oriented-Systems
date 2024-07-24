package commands;

import java.util.ArrayList;

import scene.Editor;
import scene.Shape;

public class ColorCommand implements Command{
	String prevColor;
	String color;
	boolean didOperate;
	
	public boolean canHandle(String[] command) {
		String[] colors = {"Red", "Blue", "Orange", "Yellow", "Green"};
		boolean found = false;
		for(String x : colors) {
			if(x.equals(command[1])) {
				found = true;
				this.color = command[1];
				break;
			}
		}
		if(found) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void execute(Editor scene) {
		int select = scene.getCurrentSelection();
		if(select == 0) {
			System.out.println("No Shape is selected");
			didOperate = false;
		} else {
			ArrayList<Shape> shapes = scene.getShapes();
			select = select - 1;
			this.prevColor = shapes.get(select).getColor();
			shapes.get(select).setColor(color);
			scene.setShapes(shapes);
			didOperate = true;
		}
		
	}
	@Override
	public void undo(Editor scene) {
		if(didOperate) {
			int select = scene.getCurrentSelection();
			ArrayList<Shape> shapes = scene.getShapes();
			select = select - 1;
			shapes.get(select).setColor(this.prevColor);
			scene.setShapes(shapes);
		}
	}
	
}
