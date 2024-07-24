package scene;

import java.util.ArrayList;

public class Editor {
	ArrayList<Shape> shapes;
	int currentSelection;
	
	public Editor() {
		shapes = new ArrayList<Shape>();
	}
	
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	public void setSelection(int i) {
		this.currentSelection = i;
	}
	
	public ArrayList<Shape> getShapes(){
		return this.shapes;
	}
	
	public int getCurrentSelection() {
		return this.currentSelection;
	}
	
	public void addShape(Shape shape) {
		this.shapes.add(shape);
		
		
	}
	
	public void removeShape(Shape shape) {
		this.shapes.remove(shape);
	}
}
