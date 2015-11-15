package rjmcf.raytracer;

public class Point {
	private float x;
	private float y;
	private float z;
	
	public Point(float X, float Y, float Z) {
		x = X;
		y = Y;
		z = Z;
	}
	public float getX() { return x; }
	public float getY() { return y; }
	public float getZ() { return z; }
	
	public Point pAdd(Point v) {
		return new Point(v.x + x, v.y + y, v.z + z);
	}
	
	public Point pSub(Point v) {
		return new Point(x - v.x, y - v.y, z - v.z);
	}
	
	public float pDot(Point v) {
		return v.x*x + v.y*y + v.z*z;
	}
	
	public Point pCross(Point v) {
		return new Point(y*v.z - z*v.y,
						 v.x*z - x*v.z,
						 x*v.y - y*v.x);
	}
	
	public Point pMult(float s) {
		return new Point(s*x, s*y, s*z);
	}
	
	public float mag() {
		return (float)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}
	
	public Point norm() {
		return new Point(x/mag(), y/mag(), z/mag());
	}
	
	@Override
	public String toString() {
		return x + ", " + y + ", " + z;
	}
}
