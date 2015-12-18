package for2D;

import java.awt.Color;


public class LineMidpoint implements LineInterface {
    private Point2D s;
    private Point2D e;
    private Color C;

    public LineMidpoint(Point2D S, Point2D E, Color C) {
        s = S;
        e = E;
        this.C = C;
    }

    @Override
    public Point2D getS() {
        return s;
    }

    @Override
    public Point2D getE() {
        return e;
    }

    private void octant1(Point2D p0, Point2D p1, Color[][] screen, int Y) {
        float a = p1.getY() - p0.getY();
        float b = p0.getX() - p1.getX();
        float c = p1.getX() * p0.getY() - p0.getX() * p1.getY();
        int x = Math.round(p0.getX());
        int y = Math.round((-a * x - c) / b);
        float k = a * (x + 1) + b * (y + 0.5f) + c;

        while (x <= Math.round(p1.getX())) {
            screen[x][Y - y] = C;
            if (k < 0) k += a;
            else {
                k += a + b;
                y++;
            }
            x++;
        }
    }

    private void octant2(Point2D p0, Point2D p1, Color[][] screen, int Y) {
        float a = p1.getY() - p0.getY();
        float b = p0.getX() - p1.getX();
        float c = p1.getX() * p0.getY() - p0.getX() * p1.getY();
        int y = Math.round(p0.getY());
        int x = Math.round((-b * y - c) / a);
        float k = a * (x + 0.5f) + b * (y + 1) + c;

        while (y <= Math.round(p1.getY())) {
            screen[x][Y - y] = C;
            if (k > 0) k += b;
            else {
                k += a + b;
                x++;
            }
            y++;
        }

    }

    private void octant3(Point2D p0, Point2D p1, Color[][] screen, int Y) {
        float a = p1.getY() - p0.getY();
        float b = p0.getX() - p1.getX();
        float c = p1.getX() * p0.getY() - p0.getX() * p1.getY();
        int y = Math.round(p0.getY());
        int x = Math.round((-b * y - c) / a);
        float k = a * (x - 0.5f) + b * (y + 1) + c;

        while (y <= Math.round(p1.getY())) {
            screen[x][Y - y] = C;
            if (k < 0) k += b;
            else {
                k -= a - b;
                x--;
            }
            y++;
        }
    }

    private void octant8(Point2D p0, Point2D p1, Color[][] screen, int Y) {
        float a = p1.getY() - p0.getY();
        float b = p0.getX() - p1.getX();
        float c = p1.getX() * p0.getY() - p0.getX() * p1.getY();
        int x = Math.round(p0.getX());
        int y = Math.round((-a * x - c) / b);
        float k = a * (x + 1) + b * (y - 0.5f) + c;

        while (x <= Math.round(p1.getX())) {
            screen[x][Y - y] = C;
            if (k > 0) k += a;
            else {
                k += a - b;
                y--;
            }
            x++;
        }
    }

    @Override
    public void drawLine(Color[][] screen, int Y) {
        float m = (e.getY() - s.getY()) / (e.getX() - s.getX());
        if (e.getX() >= s.getX()) {
            if (0 <= m && m <= 1) {
                // Octant 1
                octant1(s, e, screen, Y);
            } else if (m > 1) {
                // Octant 2
                octant2(s, e, screen, Y);

            } else if (m < -1) {
                // Octant 7
                octant3(e, s, screen, Y);
            } else {
                // Octant 8
                octant8(s, e, screen, Y);
            }
        } else {
            if (0 <= m && m <= 1) {
                // Octant 5
                octant1(e, s, screen, Y);
            } else if (m > 1) {
                // Octant 6
                octant2(e, s, screen, Y);
            } else if (m < -1) {
                // Octant 3
                octant3(s, e, screen, Y);
            } else {
                // Octant 4
                octant8(e, s, screen, Y);
            }
        }
    }
}
