package for3D;

public class Screen3D extends Screen {

    protected Screen3D(int h, int w, int X, int Y) {
        super(X, Y, new Scene3D(h, w, X, Y));    // h and w are monitor pixel dimensions
    }
}