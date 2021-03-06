package for2D;

import for3D.Scene;

import java.awt.*;

public class LineDrawer extends Scene {
    private Point2D centre = new Point2D(300, 300);
    private Geometry[] lines = new Geometry[]{new Bezier(new Point2D(300, 300), new Point2D(590, 500), new Point2D(100, 500), new Point2D(450, 250), Color.BLACK, false)
                                                /*new Line(centre, new Point2D(599,500), Color.RED),
                                                new Line(centre, new Point2D(400,599), Color.ORANGE),
												new Line(centre, new Point2D(100,599), Color.YELLOW),
												new Line(centre, new Point2D(0,400), Color.GREEN),
												new Line(centre, new Point2D(0,100), new Color(115,242,240)),
												new Line(centre, new Point2D(200,0), new Color(41,45,242)),
												new Line(centre, new Point2D(400,0), new Color(179,52,242)),
												new Line(centre, new Point2D(599,200), new Color(245,95,238)),
												new Line(new Point2D(0,300), new Point2D(599,300), Color.BLACK),
												new Line(new Point2D(300,0), new Point2D(300,599), Color.BLACK)*/};


    public LineDrawer(int h, int w, int X, int Y) {
        super(h, w, X, Y);
    }

    @Override
    public Color[][] getScreen() {
        Color[][] screen = new Color[getY()][getX()];

        for (Geometry l : lines) {
            l.draw(screen, getY() - 1);
        }

        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                if (screen[j][i] == null) {
                    screen[j][i] = Color.WHITE;
                }
            }
        }

        return screen;
    }
}
