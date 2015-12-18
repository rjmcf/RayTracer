package for3D;

public enum Material {
    MAT1(new K(0.4f, 0.4f, 0.4f),
         new K(0.4f, 0.4f, 0.4f),
         new K(0.2f, 0.2f, 0.2f), 10);

    public final K ambient;
    public final K diffuse;
    public final K specular;
    public final int n;

    Material(K a, K d, K s, int n) {
        ambient = a;
        diffuse = d;
        specular = s;
        this.n = n;
    }
}
