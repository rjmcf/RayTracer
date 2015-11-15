package rjmcf.raytracer;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class RasterDisplay extends JFrame {
	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;	// gamePanel actually draws coloured pixels.
	private static Screen screen;	// screen stores a double list of colors to draw
	private int length = 600;		// length of a side in monitor pixels
	private static int zoom = 1;	// number of monitor pixels per screen pixel
	
 	public RasterDisplay() {
  		super("Display");
  		setSize(length, (length)+20);
  		setDefaultCloseOperation(EXIT_ON_CLOSE);
  		setLayout(new BorderLayout());
  		JComponent gamePanel = createGamePanel();
  		add(gamePanel, BorderLayout.CENTER);
	}
	
 	private JComponent createGamePanel() {
  		gamePanel = new GamePanel(zoom);
  		return gamePanel;
 	}
 	
 	private void initialise() {
 		int pixels = length / gamePanel.getZoom();					// pixels is number of screen pixels on a side
 		screen = new Screen(pixels*zoom,pixels*zoom,pixels,pixels); /* first two arguments are monitor pixels, 
 																	 * second two are screen pixels */
 	}
  	
  	 private void resetWorld() {
  		 screen.draw();		// gets the actual pixel array into the screen object.
  		 gamePanel.display(screen);
  		 repaint(); 
	}
 	
 	public static void main(String[] args) {
      	RasterDisplay disp = new RasterDisplay();
      	disp.initialise();
      	disp.resetWorld();
      	disp.setVisible(true);
 		
 		/*Camera c = new Camera(0,0,100, new Vector(0,0,-1), new Vector(0,1,0), 100);
 		Sphere s = new Sphere(new Tintable(Color.BLACK), Material.MAT1, 0,0,0, 50);
 		Vector norm = new Vector(new Point(0,100,0), new Point(0,1,0));
 		for (Point v : s.getIntersections(norm)) {
 			System.out.println(v);
 		}
 		//System.out.println(norm);*/
	}
}