package for3D;

public class InfPlane extends Shape {
    private Vector3D normal;

    public InfPlane(int x, int y, int z, Point3D n, Tintable c, Material m) {
        super(x, y, z, c, m);
        normal = new Vector3D(new Point3D(x,y,z), n.norm());
    }

    @Override
    public Vector3D getNormal(Point3D point) { return normal; }

    @Override
    public Point3D[] getIntersections(Vector3D line) {
        line = line.norm();
        float d = line.getDirection().pDot(normal.getDirection());
        float s = (d - normal.getDirection().pDot(line.getPoint())) / normal.getDirection().pDot(line.getDirection());
        if (s > 0) {
            return new Point3D[]{line.getPoint().pAdd(line.getDirection().pMult(s))};
        }
        return new Point3D[0];
    }

    @Override
    public Tintable getColorAtPixel(Point3D point) {
        return getColor();
    }

}
