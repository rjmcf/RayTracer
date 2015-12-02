package for2D;

import java.awt.*;


public class LineMidpoint implements LineInterface {
    private Point2D s;
    private Point2D e;
    private Color c;

    public LineMidpoint(Point2D S, Point2D E, Color C) {
        s = S;
        e = E;
        c = C;
    }

    @Override
    public Point2D getS() {
        return s;
    }

    @Override
    public Point2D getE() {
        return e;
    }

    @Override
    public void drawLine(Color[][] screen, int Y) {

    }
}
