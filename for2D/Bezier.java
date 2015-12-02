package for2D;

import java.awt.*;

public class Bezier extends Geometry {
    private Point2D P0;
    private Point2D P1;
    private Point2D P2;
    private Point2D P3;
    private Color c;
    private float limit = 1f;
    private boolean drawBox;

    public Bezier(Point2D p0, Point2D p1, Point2D p2, Point2D p3, Color C, boolean drawBox) {
        P0 = p0;
        P1 = p1;
        P2 = p2;
        P3 = p3;
        c = C;
        this.drawBox = drawBox;
    }

    private Point2D pointForParam(float f) {
        return new Point2D(P0).multF(1 - f).add(new Point2D(P3).multF(f));
    }

    private boolean isFlat() {
        float s1 = ((P3.getX() - P0.getX()) * (P1.getX() - P0.getX()) + (P3.getY() - P0.getY()) * (P1.getY() - P0.getY())) / ((P3.getX() - P0.getX()) * (P3.getX() - P0.getX()) + (P3.getY() - P0.getY()) * (P3.getY() - P0.getY()));
        s1 = s1 < 0 ? 0 : s1;
        s1 = s1 > 1 ? 1 : s1;
        Point2D Q1 = pointForParam(s1);
        if (P1.dist(Q1) > limit) return false;

        float s2 = ((P3.getX() - P0.getX()) * (P2.getX() - P0.getX()) + (P3.getY() - P0.getY()) * (P2.getY() - P0.getY())) / ((P3.getX() - P0.getX()) * (P3.getX() - P0.getX()) + (P3.getY() - P0.getY()) * (P3.getY() - P0.getY()));
        s2 = s2 < 0 ? 0 : s2;
        s2 = s2 > 1 ? 1 : s2;
        Point2D Q2 = pointForParam(s2);
        return P2.dist(Q2) <= limit;

    }

    @Override
    public void draw(Color[][] screen, int Y) {
        if (drawBox) {
            new Line(P0, P1, Color.RED).draw(screen, Y);
            new Line(P1, P2, Color.RED).draw(screen, Y);
            new Line(P2, P3, Color.RED).draw(screen, Y);
            new Line(P3, P0, Color.RED).draw(screen, Y);
        }
        drawNP(screen, Y);
    }

    private void drawNP(Color[][] screen, int Y) {
        if (isFlat()) {
            new Line(P0, P3, c).draw(screen, Y);
            return;
        }
        Point2D M1 = new Line(P0, P1, c).mid();
        Point2D M2 = new Line(P1, P2, c).mid();
        Point2D M3 = new Line(P2, P3, c).mid();
        Point2D M4 = new Line(M1, M2, c).mid();
        Point2D M5 = new Line(M2, M3, c).mid();
        Point2D M6 = new Line(M4, M5, c).mid();
        new Bezier(P0, M1, M4, M6, c, false).drawNP(screen, Y);
        new Bezier(M6, M5, M3, P3, c, false).drawNP(screen, Y);
    }

}
