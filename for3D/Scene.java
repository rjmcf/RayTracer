package for3D;

import java.awt.Color;

public abstract class Scene {
    private int height;                                        // Dimensions in terms of monitor pixels
    private int width;
    private int X;                                            // Dimensions in terms of screen pixels
    private int Y;

    public Scene(int h, int w, int X, int Y) {
        height = h;    // monitor
        width = w;
        this.X = X;    // screen
        this.Y = Y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public abstract Color[][] getScreen();

}
