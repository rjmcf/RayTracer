package rjmcf.raytracer;

public enum Material {
	MAT1 (0.4f, 0.4f, 0.2f, 10);
	
	public final float ambient;		// TODO each k needs three components
	public final float diffuse;
	public final float specular;
	public final int n;
	
	Material(float a, float d, float s, int n) {
		ambient = a;
		diffuse = d;
		specular = s;
		this.n= n;
	}
}
