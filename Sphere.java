package rjmcf.raytracer;

public class Sphere extends Shape {
	int radius;
	
	public Sphere(int x, int y, int z, int r, Tintable c, Material m) {
		super(x,y,z,c,m);
		radius = r;
	}

	@Override
	public Vector getNormal(Point point) {
		return new Vector(point, point.pSub(getCentre()).norm());
	}

	@Override
	public Point[] getIntersections(Vector line) {		// Formula from notes
		line = line.norm();
		float a = line.dot(line);
				// a = D.D
		float b = line.getDirection().pMult(2).pDot(line.getPoint().pSub(getCentre()));
				// b = 2D.(O-C)
		float c = line.getPoint().pSub(getCentre()).pDot(line.getPoint().pSub(getCentre())) - radius*radius;
				// (O-C).(O-C) - r^2
		if (b*b - 4*a*c < 0) {
			return new Point[0];
		}
		float d = (float)Math.sqrt(b*b - 4*a*c);
		float s1 = (-b+d)/2*a;
		float s2 = (-b-d)/2*a;
		
		if (s1 <= 0) {
			return new Point[0];
		}
		Point v1 = line.getDirection().pMult(s1).pAdd(line.getPoint());
		Point v2 = line.getDirection().pMult(s2).pAdd(line.getPoint());
		
		return new Point[] {v1, v2};
	}

	@Override
	public Tintable getColorAtPixel(Point point) {
		return getColor();
	}

}
