package scene;

public class Circle implements Shape{
	int x;
	int y;
	int r;
	String color;
	
	@Override
	public void createShape(int[] values) {
		this.r = values[0];
		this.x = 0;
		this.y = 0;
		setColor("Blue");
		
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
		shapeString += "Circle, Color: ";
		shapeString += color;
		shapeString += ", Origin: (";
		shapeString += String.valueOf(x);
		shapeString += ",";
		shapeString += String.valueOf(y);
		shapeString += "), Radius: ";
		shapeString += String.valueOf(r);
		shapeString += "\n";
		return shapeString;
	}
	
	
}
