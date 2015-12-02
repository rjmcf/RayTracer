package rjmcf.raytracer.for3D;

public class Vector {
    private Point3D point;
    private Point3D direction;

    public Vector(Point3D p, Point3D d) {
        point = p;
        direction = d;
    }

    public Vector(float x, float y, float z) {
        point = new Point3D(0, 0, 0);
        direction = new Point3D(x, y, z);
    }

    public Point3D getPoint() {
        return point;
    }

    public Point3D getDirection() {
        return direction;
    }

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
