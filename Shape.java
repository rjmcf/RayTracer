package rjmcf.raytracer;

public abstract class Shape {
	private Point centre;
	private Tintable color;
	private Material mat;
	
	public Shape(int x, int y, int z, Tintable c, Material m) {
		centre = new Point(x,y,z);
		color = c;
		mat = m;
	}
	public Point getCentre() { return centre; }
	public Tintable getColor() { return color; }
	public Material getMat() { return mat; }
	
	public abstract Vector getNormal(Point point);
	public abstract Point[] getIntersections (Vector line);
	public abstract Tintable getColorAtPixel(Point point);
}
