package for3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene3D extends Scene {                            // x goes right, y goes up, z goes out.
    private Tintable ambient = new Tintable(100, 100, 100);    // Constant ambient light
    private Vector OC;										/* The vector from the camera to the top left
                                                             * corner of the screen. */

    private Camera cam = new Camera(0, 700, 1400, new Vector(0, -1, -2), new Vector(0, 2, -1), 1000);
    // position, direction, up, distance from screen
    Tintable grey = new Tintable(50, 50, 50);
    Tintable green = new Tintable(10, 100, 10);
    Tintable red = new Tintable(255, 0, 0);
    Tintable yellow = new Tintable(250, 250, 10); // colours to use
	/*private Shape[] shapes = new Shape[] { new InfPlane(0,0,0, new Point(0,1,0), grey, Material.MAT1),
										   new Sphere(-500,50,-500, 50, red, Material.MAT1),
										   new Sphere(-100,100,-100, 100, green, Material.MAT1)}; // List of shapes in scene.
	private Light[] lights = new Light[] { new Light(200,300,200, yellow) };  // List of lights in scene
	*/
	
	/*private Shape[] shapes = new Shape[] { new Sphere(0,100,200, 50, grey, Material.MAT1),  // Alternative scene
										   new Sphere(0,-150,0, 200, grey, Material.MAT1)}; 
	private Light[] lights = new Light[] {new Light(25,200,250, yellow),
										  new Light(-300,-150,300, red),
										  new Light(100,-400,150, green)};// new Tintable(200,200,200))}; 
	*/

    private Shape[] shapes = new Shape[]{new Sphere(0, 100, 0, 100, red, Material.MAT1),
            new InfPlane(0, 0, 0, new Point3D(0, 1, 0), grey, Material.MAT1)};
    private Light[] lights = new Light[]{new Light(200, 400, 800, yellow)};

    public Scene3D(int h, int w, int X, int Y) {
        super(h, w, X, Y);
        OC = new Vector(cam.getPos(), cam.getDir().mult(cam.getDist()).add(cam.getUp().mult(getHeight() / 2f)).add(
                cam.getUp().cross(cam.getDir()).norm().mult(getWidth() / 2f)).getDirection());
        // OC = dist*D^ + h/2 * U^ + w/2 * (U^ X D^)^
    }

    private Tintable calculateLights(Shape shape, Point3D point) {    // Light calculations from email
        Tintable diffuse = new Tintable(0, 0, 0);
        Tintable specular = new Tintable(0, 0, 0);
        float prop;
        boolean collision = false;
        for (Light l : lights) {
            Vector toLight = new Vector(point, l.getPos().pSub(point).norm());
            for (Shape other : shapes) {
                if (other != shape) {
                    if (other.getIntersections(toLight).length > 0) {
                        collision = true;
                        break;
                    }
                }
            }
            if (collision) {
                collision = false;
                continue;
            }

            float cosT = toLight.dot(shape.getNormal(point));
            if (cosT > 0) {
                prop = cosT * shape.getMat().diffuse;
                diffuse = diffuse.addTint(l.getColor().proportion(prop));
            } else continue;

            float cosA = toLight.reflectedRoundN(shape.getNormal(point)).getDirection().pDot(point.pMult(-1).norm());
            if (cosA > 0) {
                prop = (float) (Math.pow(cosA, shape.getMat().n) * shape.getMat().specular);
                specular = specular.addTint(l.getColor().proportion(prop));
            }
        }
        return ambient.addTint(shape.getColor().proportion(shape.getMat().ambient)).addTint(diffuse).addTint(specular);
    }

    @Override
    public Color[][] getScreen() {
        Color[][] screen = new Color[getY()][getX()];
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                List<Tintable> toAverage = new ArrayList<>();
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        Tintable color = ambient;
                        Vector ray = new Vector(cam.getPos(), OC.sub(cam.getUp().cross(cam.getDir()).mult(
                                i * getWidth() / getX() + (x / 2f) * getWidth() / getX())).sub(cam.getUp().mult(
                                j * getHeight() / getY() + (y / 2f) * getWidth() / getY())).getDirection());
                        // ray = OC + i*width/X*(U^ X D^) + j*height/Y*U^
                        float currentD = Float.MAX_VALUE;
                        Point3D current = null;
                        Shape currentShape = null;
                        for (Shape shape : shapes) {
                            Point3D[] intersections = shape.getIntersections(ray);    // Find points where ray intersects with a shape
                            for (Point3D vector : intersections) {
                                if (vector.pSub(cam.getPos()).mag() < currentD) {                        // Find closest intersection
                                    currentD = vector.pSub(cam.getPos()).mag();
                                    current = vector;
                                    currentShape = shape;
                                }
                            }
                        }
                        if (current != null) {
                            color = calculateLights(currentShape, current);
                        }

                        toAverage.add(color);

                    }
                }

                Color color = Tintable.average(toAverage);

                screen[i][j] = color;        // set screen in place to color.
            }
        }

        return screen;
    }
}
