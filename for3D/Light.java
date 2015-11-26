package rjmcf.raytracer.for3D;

public class Light {
	// A light is a point that can then be traced to from surfaces.
	
	private Point3D position;
	private Tintable color;
	
	public Light(float x, float y, float z, Tintable c) {
		position = new Point3D(x,y,z);
		color = c;
	}
	
	public Point3D getPos() { return position; }
	public Tintable getColor() { return color; }
}
