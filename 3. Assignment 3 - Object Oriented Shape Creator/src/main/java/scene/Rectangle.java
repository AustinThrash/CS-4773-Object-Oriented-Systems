package scene;

public class Rectangle implements Shape {
	int x;
	int y;
	int width;
	int height;
	String color;
	
	@Override
	public void createShape(int[] values) {
		this.width = values[0];
		this.height = values[1];
		this.x = 0;
		this.y = 0;
		setColor("Red");
		
	}
	
	@Override
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
	
	@Override
	public String toString() {
		String shapeString = "";
		shapeString += "Rectangle, Color: ";
		shapeString += color;
		shapeString += ", Origin: (";
		shapeString += String.valueOf(x);
		shapeString += ",";
		shapeString += String.valueOf(y);
		shapeString += "), Width: ";
		shapeString += String.valueOf(width);
		shapeString += ", Height: ";
		shapeString += String.valueOf(height);
		shapeString += "\n";
		return shapeString;
	}
}
