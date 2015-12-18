package for3D;

public class Camera {
    private Point3D position;
    private Vector3D direction;
    private Vector3D up;
    private int distFromScreen;

    public Camera(float X, float Y, float Z, Vector3D d, Vector3D u, int dist) {
        position = new Point3D(X, Y, Z);
        direction = new Vector3D(position, d.getDirection().norm());
        up = new Vector3D(position, u.getDirection().norm());
        distFromScreen = dist;
    }

    public Point3D getPos() {
        return position;
    }

    public Vector3D getDir() {
        return direction;
    }

    public Vector3D getUp() {
        return up;
    }

    public int getDist() {
        return distFromScreen;
    }

}
