package rjmcf.raytracer.for2D;

import java.awt.Color;

public class Point2D extends Geometry {
    private float x;
    private float y;
    private Color c;

    public Point2D(float X, float Y, Color C) {
        x = X;
        y = Y;
        c = C;
    }

    public Point2D(float X, float Y) {
        this(X, Y, Color.BLACK);
    }

    public Point2D(Point2D old) {
        this(old.x, old.y, old.c);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

    public void draw(Color[][] screen, int Y) {
        screen[Math.round(x)][Y - Math.round(y)] = c;
    }

    public Point2D multF(float f) {
        x *= f;
        y *= f;
        return this;
    }

    public Point2D add(Point2D o) {
        x += o.x;
        y += o.y;
        return this;
    }

    public float dist(Point2D o) {
        return (float) Math.sqrt((x - o.x) * (x - o.x) + (y - o.y) * (y - o.y));
    }
}
