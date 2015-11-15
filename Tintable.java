package rjmcf.raytracer;

import java.awt.Color;

public class Tintable extends Color {
	// This allows mixing of colours and lightening and darkening
	
	private static final long serialVersionUID = 1L;

	public Tintable(Color c) {
		super(c.getRGB());
	}
	public Tintable(int r, int g, int b) {
		super(r,g,b);
	}
	
	public Tintable addTint(Tintable t) {
		int r = Math.min((int)(getRed() + t.getRed()), 255);
		int g = Math.min((int)(getGreen() + t.getGreen()), 255);
		int b = Math.min((int)(getBlue() + t.getBlue()), 255);
		
		return new Tintable(r,g,b);
	}
	
	public Tintable proportion(float p) {
		return new Tintable(Math.min((int)(p*getRed()),255),
							Math.min((int)(p*getGreen()),255),
							Math.min((int)(p*getBlue()),255));
	}
	
	@Override
	public String toString() {
		return getRed() + ", " + getGreen() + ", " + getBlue();
	}
}
