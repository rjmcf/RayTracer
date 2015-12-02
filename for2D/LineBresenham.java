package for2D;

import java.awt.*;

public class LineBresenham implements LineInterface {
    private Point2D s;
    private Point2D e;
    private Color c;

    public LineBresenham(Point2D S, Point2D E, Color C) {
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

    private void octant1(float m, int Y, Point2D f, Point2D l, Color[][] screen) {
        int x = Math.round(f.getX());
        float yi = f.getY() + m * (x - f.getX());
        int y = Math.round(yi);
        float yf = yi - y;
        while (x <= Math.round(l.getX())) {
            screen[x][Y - y] = c;
            x++;
            yf += m;
            if (yf > 0.5f) {
                y++;
                yf -= 1;
            }
        }
    }

    private void octant2(float m, int Y, Point2D f, Point2D l, Color[][] screen) {
        int y = Math.round(f.getY());
        float xi = m == Float.POSITIVE_INFINITY ? f.getX() : f.getX() + m * (y - f.getY());
        int x = Math.round(xi);
        float xf = xi - x;
        while (y <= Math.round(l.getY())) {
            screen[x][Y - y] = c;
            y++;
            xf += 1 / m;
            if (xf > 0.5f) {
                x++;
                xf -= 1;
            }
        }
    }

    private void octant3(float m, int Y, Point2D f, Point2D l, Color[][] screen) {
        int y = Math.round(f.getY());
        float xi = f.getX() + m * (y - f.getY());
        int x = Math.round(xi);
        float xf = xi - x;
        while (y <= Math.round(l.getY())) {
            screen[x][Y - y] = c;
            y++;
            xf += 1 / m;
            if (xf < -0.5f) {
                x--;
                xf += 1;
            }
        }
    }

    private void octant8(float m, int Y, Point2D f, Point2D l, Color[][] screen) {
        int x = Math.round(f.getX());
        float yi = f.getY() + m * (x - f.getX());
        int y = Math.round(yi);
        float yf = yi - y;
        while (x <= Math.round(l.getX())) {
            screen[x][Y - y] = c;
            x++;
            yf += m;
            if (yf < -0.5f) {
                y--;
                yf += 1;
            }
        }
    }

    @Override
    public void drawLine(Color[][] screen, int Y) {
        float m = (e.getY() - s.getY()) / (e.getX() - s.getX());
        if (e.getX() >= s.getX()) {
            if (0 <= m && m <= 1) {
                // Octant 1
                octant1(m, Y, s, e, screen);
            } else if (m > 1) {
                // Octant 2
                octant2(m, Y, s, e, screen);

            } else if (m < -1) {
                // Octant 7
                octant3(m, Y, e, s, screen);
            } else {
                // Octant 8
                octant8(m, Y, s, e, screen);
            }
        } else {
            if (0 <= m && m <= 1) {
                // Octant 5
                octant1(m, Y, e, s, screen);
            } else if (m > 1) {
                // Octant 6
                octant2(m, Y, e, s, screen);
            } else if (m < -1) {
                // Octant 3
                octant3(m, Y, s, e, screen);
            } else {
                // Octant 4
                octant8(m, Y, e, s, screen);
            }
        }
    }
}
