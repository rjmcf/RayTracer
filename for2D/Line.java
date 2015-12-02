package for2D;

import java.awt.*;

public class Line extends Geometry {
    LineInterface lineInstance;

    public Line(Point2D S, Point2D E, Color C) {
        lineInstance = new LineBresenham(S, E, C);
    }

    @Override
    public void draw(Color[][] screen, int Y) {
        lineInstance.drawLine(screen, Y);
    }

    public Point2D mid() {
        return new Point2D(lineInstance.getS()).multF(0.5f).add(new Point2D(lineInstance.getE()).multF(0.5f));
    }
}
