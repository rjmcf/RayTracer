package for3D;

public enum Material {
    MAT1(new K(0.4f, 0.4f, 0.4f),
         new K(0.4f, 0.4f, 0.4f),
         new K(0.2f, 0.2f, 0.2f), 10, 0f),
    MAT2(new K(0.2f, 0.4f, 0.4f),
         new K(0.4f, 0.4f, 0.4f),
         new K(0.4f, 0.2f, 0.2f), 10, 1f);

    public final K ambient;
    public final K diffuse;
    public final K specular;
    public final int n;
    public final float rR; // reflectivity ratio. 0 is not reflective, 1 is fully reflective

    Material(K a, K d, K s, int n, float r) {
        ambient = a;
        diffuse = d;
        specular = s;
        this.n = n;
        rR = r;
    }
}
