package matrices;

import matrices.Point4D;

/**
 * Created by Rjmcf on 03/12/2015.
 */
public class Matrix4x4 {
    private float[][] contents = new float[4][4];

    public Matrix4x4() {}

    public Matrix4x4(float[][] m) {
        if (m.length != 4 || m[0].length != 4 || m[1].length != 4 || m[2].length != 4 || m[3].length != 4) {
            throw new ArrayIndexOutOfBoundsException("Matrix 4x4 takes only a 4x4 matrix!");
        }
        else {
            for (int i = 0; i < 4; i++) System.arraycopy(m[i], 0, contents[i], 0, 4);
        }
    }

    public Matrix4x4(Point4D x, Point4D y, Point4D z, Point4D w) {
        contents[0][0] = x.getX();
        contents[1][0] = y.getX();
        contents[2][0] = z.getX();
        contents[0][1] = x.getY();
        contents[1][1] = y.getY();
        contents[2][1] = z.getY();
        contents[0][2] = x.getZ();
        contents[1][2] = y.getZ();
        contents[2][2] = z.getZ();
        contents[0][3] = x.getW();
        contents[1][3] = y.getW();
        contents[2][3] = z.getW();
    }

    public float[][] getContents() { return contents; }
}
