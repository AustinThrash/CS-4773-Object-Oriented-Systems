package scene;

public interface Shape {
	public void createShape(int[] values);
	
	public void setLocation(int x, int y);
	
	public void setColor(String color);
	
	public String getColor();
	
	public int getX();
	
	public int getY();
	
	public String toString();
}
