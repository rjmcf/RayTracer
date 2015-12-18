package matrices;

import for3D.Point3D;

public class MatrixTranslate extends Matrix4x4{

    public MatrixTranslate(Point3D p) {
        super(new float[][]{{1,0,0,p.getX()},
                            {0,1,0,p.getY()},
                            {0,0,1,p.getZ()},
                            {0,0,0,1}});
    }
}
