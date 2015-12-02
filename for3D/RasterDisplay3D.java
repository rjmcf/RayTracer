package rjmcf.raytracer.for3D;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RasterDisplay3D extends JFrame {
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;	// gamePanel actually draws coloured pixels.
	private static Screen3D screen;	// screen stores a double list of colors to draw
	private int length = 600;		// length of a side in monitor pixels
	private static int pPerP = 4;	// number of monitor pixels per screen pixel
	
 	public RasterDisplay3D() {
  		super("Display");
  		setSize(length, (length)+20);
  		setDefaultCloseOperation(EXIT_ON_CLOSE);
  		setLayout(new BorderLayout());
  		JComponent gamePanel = createGamePanel();
  		add(gamePanel, BorderLayout.CENTER);
	}
	
 	private JComponent createGamePanel() {
  		gamePanel = new GamePanel(pPerP);
  		return gamePanel;
 	}
 	
 	private void initialise() {
 		int pixels = length / gamePanel.getZoom();					// pixels is number of screen pixels on a side
 		screen = new Screen3D(pixels*pPerP,pixels*pPerP,pixels,pixels); /* first two arguments are monitor pixels, 
 																	 * second two are screen pixels */
 	}
  	
  	 private void resetWorld() {
  		 screen.setScreen();		// gets the actual pixel array into the screen object.
  		 gamePanel.display(screen);
  		 repaint(); 
	}
 	
 	public static void main(String[] args) {
      	RasterDisplay3D disp = new RasterDisplay3D();
      	disp.initialise();
      	disp.resetWorld();
      	disp.setVisible(true);
	}
}