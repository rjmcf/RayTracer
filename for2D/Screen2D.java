package rjmcf.raytracer.for2D;

import rjmcf.raytracer.for3D.Screen;

public class Screen2D extends Screen{
 	
 	protected Screen2D(int h, int w, int X, int Y) {
  		super(X,Y, new LineDrawer(h,w,X,Y));	// h and w are monitor pixel dimensions
	}
}