package rjmcf.raytracer.for3D;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Screen {
	private int width;		// dimensions in screen pixels
 	private int height;		
 	Color[][] screen;		// screen to draw
	Scene scene;
	
	public int getWidth() { return this.width; }
 	public int getHeight() { return this.height; }
 	protected Color getCellAsColour(int col,int row) { return screen[col][row]; }
 	
 	protected Screen(int X, int Y, Scene s) {
  		width = X;
  		height = Y;
  		scene = s;	// h and w are monitor pixel dimensions
	}
	
 	public void setScreen() {
 		screen = scene.getScreen();
 	}
 	
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
