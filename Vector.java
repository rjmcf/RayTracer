package rjmcf.raytracer;

public class Vector {
	private Point point;
	private Point direction;
	
	public Vector(Point p, Point d) {
		point = p;
		direction = d;
	}
	public Vector(float x, float y, float z) {
		point = new Point(0,0,0);
		direction = new Point(x,y,z);
	}
	
	public Point getPoint() { return point; }
	public Point getDirection() { return direction; }
	
	public Vector add(Vector v) {
		return new Vector(point, direction.pAdd(v.direction));
	}
	
	public Vector sub(Vector v) {
		return new Vector(point, direction.pSub(v.direction));
	}
	
	public float dot(Vector v) {
		return direction.pDot(v.direction);
	}
	
	public Vector cross(Vector v) {
		return new Vector(point, direction.pCross(v.direction));
	}
	
	public Vector mult(float s) {
		return new Vector(point, direction.pMult(s));
	}
	
	public float mag() {
		return direction.mag();
	}
	
	public Vector norm() {
		return new Vector(point, direction.norm());
	}
	
	public Vector reflectedRoundN(Vector normal) {
		return sub(normal.norm().mult(2f * dot(normal.norm())));
	}
	
	@Override
	public String toString() {
		return "(" + point + ") + t(" + direction + ")";
	}
}
