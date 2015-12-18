package for2D;

import java.awt.Color;

public interface LineInterface {
    void drawLine(Color[][] screen, int Y);

    Point2D getS();

    Point2D getE();
}
