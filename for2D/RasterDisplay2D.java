package for2D;

import for3D.GamePanel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class RasterDisplay2D extends JFrame {
    private static final long serialVersionUID = 1L;
    private GamePanel gamePanel;    // gamePanel actually draws coloured pixels.
    private static Screen2D screen;    // screen stores a double list of colors to draw
    private int length = 600;        // length of a side in monitor pixels
    private static int zoom = 1;    // number of monitor pixels per screen pixel

    public RasterDisplay2D() {
        super("Display");
        setSize(length, length + 23);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JComponent gamePanel = createGamePanel();
        add(gamePanel, BorderLayout.CENTER);
    }

    private JComponent createGamePanel() {
        gamePanel = new GamePanel(zoom);
        return gamePanel;
    }

    private void initialise() {
        int pixels = length / gamePanel.getZoom();                    // pixels is number of screen pixels on a side
        screen = new Screen2D(pixels * zoom, pixels * zoom, pixels, pixels); /* first two arguments are monitor pixels,
                                                                        * second two are screen pixels */
    }

    private void resetWorld() {
        screen.setScreen();        // gets the actual pixel array into the screen object.
        gamePanel.display(screen);
        repaint();
    }

    public static void main(String[] args) {
        RasterDisplay2D disp = new RasterDisplay2D();
        disp.initialise();
        disp.resetWorld();
        disp.setVisible(true);
    }
}