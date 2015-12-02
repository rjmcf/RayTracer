package for3D;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int zoom; //Number of pixels used to represent a cell
    private int width = 1; //Width of game board in pixels
    private int height = 1;//Height of game board in pixels
    private Screen current = null;

    public GamePanel(int z) {
        zoom = z;
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    protected void paintComponent(Graphics g) {
        if (current == null) return;
        g.setColor(java.awt.Color.WHITE);
        g.fillRect(0, 0, width, height);
        current.draw(g, width, height);
        if (zoom > 4) {
            g.setColor(java.awt.Color.LIGHT_GRAY);
            for (int row = 0; row < height; row += zoom) {
                g.drawLine(0, row, width, row);
            }
            for (int col = 0; col < width; col += zoom) {
                g.drawLine(col, 0, col, height);
            }
        }
    }

    private void computeSize() {
        if (current == null) return;
        int newWidth = current.getWidth() * zoom;
        int newHeight = current.getHeight() * zoom;
        if (newWidth != width || newHeight != height) {
            width = newWidth;
            height = newHeight;
            revalidate(); //trigger the GamePanel to re-layout its components
        }
    }

    public int getZoom() {
        return zoom;
    }

    public void display(Screen w) {
        current = w;
        computeSize();
        repaint();
    }
}