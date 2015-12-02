package for3D;

public class Point3D {
    private float x;
    private float y;
    private float z;

    public Point3D(float X, float Y, float Z) {
        x = X;
        y = Y;
        z = Z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public Point3D pAdd(Point3D v) {
        return new Point3D(v.x + x, v.y + y, v.z + z);
    }

    public Point3D pSub(Point3D v) {
        return new Point3D(x - v.x, y - v.y, z - v.z);
    }

    public float pDot(Point3D v) {
        return v.x * x + v.y * y + v.z * z;
    }

    public Point3D pCross(Point3D v) {
        return new Point3D(y * v.z - z * v.y,
                v.x * z - x * v.z,
                x * v.y - y * v.x);
    }

    public Point3D pMult(float s) {
        return new Point3D(s * x, s * y, s * z);
    }

    public float mag() {
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public Point3D norm() {
        return new Point3D(x / mag(), y / mag(), z / mag());
    }

    public Point3D pRotate(Point3D v, float t) {
        double dom = Math.sqrt(x * x + z * z);
        double sp = z / dom;
        double cp = x / dom;
        Point3D r = new Point3D((float) (x * cp + z * sp), y, (float) (z * cp - x * sp));
        dom = Math.sqrt(x * x + y * y);
        double sc = y / dom;
        double cc = x / dom;
        r = new Point3D((float) (r.x * cc + r.y * sc), (float) (r.y * cc - r.x * sc), z);
        double st = Math.sin(Math.toRadians(t));
        double ct = Math.cos(Math.toRadians(t));
        r = new Point3D(x, (float) (r.y * ct - r.z * st), (float) (r.y * st + r.z * ct));
        r = new Point3D((float) (r.x * cc - r.y * sc), (float) (r.y * cc + r.x * sc), z);
        r = new Point3D((float) (r.x * cp - r.z * sp), y, (float) (r.z * cp + r.x * sp));
        return r;
    }

    @Override
    public String toString() {
        return x + ", " + y + ", " + z;
    }
}
