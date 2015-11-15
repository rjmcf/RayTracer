package rjmcf.raytracer;

import java.awt.Color;
import java.awt.Graphics;
//TODO: insert other appropriate "import" statements here

public class Screen{
 	private int width;		// dimensions in screen pixels
 	private int height;		
 	Color[][] screen;		// screen to draw
 	Scene scene;			// scene to draw on screen
 	
 	protected Screen(int h, int w, int X, int Y) {
  		this.width = X;
  		this.height = Y;
  		scene = new Scene(h,w,X,Y);	// h and w are monitor pixel dimensions
	}
 	
 	public void draw() {
 		screen = scene.getScreen();
 	}
 	
 	public int getWidth() { return this.width; }
 	public int getHeight() { return this.height; }
 	protected Color getCellAsColour(int col,int row) { return screen[col][row]; }
 	
 	public void draw(Graphics g,int width, int height) {		// Complex drawing stuff.
  		int worldWidth = getWidth();
  		int worldHeight = getHeight();
  		double colScale = (double)width/(double)worldWidth;
  		double rowScale = (double)height/(double)worldHeight;
  		
  		for(int col=0; col<worldWidth; ++col) {
   			for(int row=0; row<worldHeight; ++row) {
    			int colPos = (int)(col*colScale);
    			int rowPos = (int)(row*rowScale);
    			int nextCol = (int)((col+1)*colScale);
    			int nextRow = (int)((row+1)*rowScale);
    			if (g.hitClip(colPos,rowPos,nextCol-colPos,nextRow-rowPos)) {
     				g.setColor(getCellAsColour(col, row));
     				g.fillRect(colPos,rowPos,nextCol-colPos,nextRow-rowPos);
				} 
			}
		} 
	}
}