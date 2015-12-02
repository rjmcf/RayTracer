package for3D;

public abstract class Shape {
    private Point3D centre;
    private Tintable color;
    private Material mat;

    public Shape(int x, int y, int z, Tintable c, Material m) {
        centre = new Point3D(x, y, z);
        color = c;
        mat = m;
    }

    public Point3D getCentre() {
        return centre;
    }

    public Tintable getColor() {
        return color;
    }

    public Material getMat() {
        return mat;
    }

    public abstract Vector getNormal(Point3D point);

    public abstract Point3D[] getIntersections(Vector line);

    public abstract Tintable getColorAtPixel(Point3D point);
}
