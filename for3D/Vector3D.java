package for3D;

public class Vector3D {
    private Point3D point;
    private Point3D direction;

    public Vector3D(Point3D p, Point3D d) {
        point = p;
        direction = d;
    }

    public Vector3D(float x, float y, float z) {
        point = new Point3D(0, 0, 0);
        direction = new Point3D(x, y, z);
    }

    public Point3D getPoint() {
        return point;
    }

    public Point3D getDirection() {
        return direction;
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(point, direction.pAdd(v.direction));
    }

    public Vector3D sub(Vector3D v) {
        return new Vector3D(point, direction.pSub(v.direction));
    }

    public float dot(Vector3D v) {
        return direction.pDot(v.direction);
    }

    public Vector3D cross(Vector3D v) {
        return new Vector3D(point, direction.pCross(v.direction));
    }

    public Vector3D mult(float s) {
        return new Vector3D(point, direction.pMult(s));
    }

    public float mag() {
        return direction.mag();
    }

    public Vector3D norm() {
        return new Vector3D(point, direction.norm());
    }

    public Vector3D reflectedRoundN(Vector3D normal) {
        return sub(normal.norm().mult(2f * dot(normal.norm())));
    }

    @Override
    public String toString() {
        return "(" + point + ") + t(" + direction + ")";
    }
}
