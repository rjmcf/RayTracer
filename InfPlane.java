package rjmcf.raytracer;

public class InfPlane extends Shape {
	private Point normal;
	
	public InfPlane(int x, int y, int z, Point n, Tintable c, Material m) {
		super(x,y,z,c,m);
		normal = n.norm();
	}
	
	@Override
	public Vector getNormal(Point point) {
		return new Vector(point, normal);
	}

	@Override
	public Point[] getIntersections(Vector line) {
		line = line.norm();
		float d = line.getDirection().pDot(normal);
		float s = (d - normal.pDot(line.getPoint())) / normal.pDot(line.getDirection());
		if (s > 0) {
			return new Point[] { line.getPoint().pAdd(line.getDirection().pMult(s)) };
		}
		return new Point[0];
	}

	@Override
	public Tintable getColorAtPixel(Point point) {
		return getColor();
	}

}
