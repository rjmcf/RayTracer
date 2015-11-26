package rjmcf.raytracer;

public class Camera {
	private Point3D position;
	private Vector direction;
	private Vector up;
	private int distFromScreen;
	
	public Camera(float X, float Y, float Z, Vector d, Vector u, int dist) {
		position = new Point3D(X,Y,Z);
		direction = new Vector(position, d.getDirection().norm());
		up = new Vector(position, u.getDirection().norm());
		distFromScreen = dist;
	}
	
	public Point3D getPos() { return position; }
	public Vector getDir() { return direction; }
	public Vector getUp() { return up; }
	public int getDist() { return distFromScreen; }

}
