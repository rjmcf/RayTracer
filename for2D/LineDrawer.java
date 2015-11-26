package rjmcf.raytracer.for2D;

import java.awt.Color;

import rjmcf.raytracer.for3D.Scene;

public class LineDrawer extends Scene{
	//private Point2D centre = new Point2D(300,300);
	private Geometry[] lines = new Geometry[] { new Bezier(new Point2D(200,200), new Point2D(300,400), new Point2D(400,400), new Point2D(550,250), Color.BLACK, false)
												/*new Line(centre, new Point2D(599,500), Color.RED),
												new Line(centre, new Point2D(400,599), Color.ORANGE),
												new Line(centre, new Point2D(100,599), Color.YELLOW),
												new Line(centre, new Point2D(0,400), Color.GREEN),
												new Line(centre, new Point2D(0,100), new Color(41,222,242)),
												new Line(centre, new Point2D(200,0), new Color(41,45,242)),
												new Line(centre, new Point2D(400,0), new Color(189,41,242)),
												new Line(centre, new Point2D(599,200), new Color(237,10,245)),
												new Line(new Point2D(0,300), new Point2D(599,300), Color.BLACK),
												new Line(new Point2D(300,0), new Point2D(300,599), Color.BLACK),
												new Point2D(305,400,Color.RED)*/};
	
	
	public LineDrawer(int h, int w, int X, int Y){
		super(h,w,X,Y);
	}
	
	@Override
	public Color[][] getScreen() {
		Color[][] screen = new Color[getY()][getX()];
		
		for (Geometry l : lines) {
			l.draw(screen, getY()-1);
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
