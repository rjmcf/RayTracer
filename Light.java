package rjmcf.raytracer;

public class Light {
	// A light is a point that can then be traced to from surfaces.
	
	private Point position;
	private Tintable color; // Max intensity is 100.
	
	public Light(float x, float y, float z, Tintable c) {
		position = new Point(x,y,z);
		color = c;
	}
	
	public Point getPos() { return position; }
	public Tintable getColor() { return color; }
}
