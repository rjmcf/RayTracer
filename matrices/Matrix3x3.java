package matrices;

import for3D.Point3D;

public class Matrix3x3 {
    private float[][] contents = new float[3][3];

    public Matrix3x3() {}

    public Matrix3x3(float[][] m) {
        if (m.length != 3 || m[0].length != 3 || m[1].length != 3 || m[2].length != 3) {
            throw new ArrayIndexOutOfBoundsException("Matrix 3x3 takes only a 3x3 matrix!");
        }
        else {
            for (int i = 0; i < 3; i++) System.arraycopy(m[i], 0, contents[i], 0, 3);
        }
    }

    public Matrix3x3(Point3D x, Point3D y, Point3D z) {
        contents[0][0] = x.getX();
        contents[1][0] = y.getX();
        contents[2][0] = z.getX();
        contents[0][1] = x.getY();
        contents[1][1] = y.getY();
        contents[2][1] = z.getY();
        contents[0][2] = x.getZ();
        contents[1][2] = y.getZ();
        contents[2][2] = z.getZ();
    }

    public Matrix3x3 multS(float s) {
        Matrix3x3 result = new Matrix3x3();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result.contents[i][j] = contents[i][j]*s;
            }
        }

        return result;
    }

    public float[][] getContents() { return contents; }

    public Matrix3x3 mult(Matrix3x3 other) {
        Matrix3x3 result = new Matrix3x3();
        float current;
        for (int i = 0; i < 3; i++) {
            for (int j= 0; j < 3; j++) {
                current = 0;
                for (int k = 0; k < 3; k++) {
                    current += contents[i][k] * other.contents[k][j];
                }
                result.getContents()[i][j] = current;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < 3; i++) {
            result += "[";
            for (int j = 0; j < 3; j++) {
                if (j!=0) {
                    result += ", ";
                }
                result += contents[i][j];
            }
            result += "]\n";
        }
        return result;
    }
}
