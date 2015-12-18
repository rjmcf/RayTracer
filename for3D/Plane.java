package for3D;

public class Plane extends InfPlane {

    private int height;
    private int width;
    private float theta;

    public Plane(int x, int y, int z, int h, int w, Point3D n, float t, Tintable c, Material m) {
        super(x, y, z, n, c, m);
        height = h;
        width = w;
        theta = t;
    }

}
