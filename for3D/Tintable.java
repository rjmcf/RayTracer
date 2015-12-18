package for3D;

import java.awt.Color;
import java.util.List;

public class Tintable extends Color {
    // This allows mixing of colours and lightening and darkening

    private static final long serialVersionUID = 1L;

    public Tintable(Color c) {
        super(c.getRGB());
    }

    public Tintable(int r, int g, int b) {
        super(r, g, b);
    }

    public Tintable addTint(Tintable t) {
        int r = Math.min((getRed() + t.getRed()), 255);
        int g = Math.min((getGreen() + t.getGreen()), 255);
        int b = Math.min((getBlue() + t.getBlue()), 255);

        return new Tintable(r, g, b);
    }

    public Tintable proportion(K k) {
        return new Tintable(Math.min((int) (k.getR() * getRed()), 255),
                Math.min((int) (k.getG() * getGreen()), 255),
                Math.min((int) (k.getB() * getBlue()), 255));
    }

    @Override
    public String toString() {
        return getRed() + ", " + getGreen() + ", " + getBlue();
    }

    public static Tintable average(List<Tintable> list) {
        int redTot = 0, greenTot = 0, blueTot = 0;

        for (Tintable c : list) {
            redTot += c.getRed();
            greenTot += c.getGreen();
            blueTot += c.getBlue();
        }

        return new Tintable(redTot / list.size(), greenTot / list.size(), blueTot / list.size());
    }

    public static boolean different(Tintable t1, Tintable t2) {
        float r = Math.abs(t1.getRed() - t2.getRed());
        float g = Math.abs(t1.getGreen() - t2.getGreen());
        float b = Math.abs(t1.getBlue() - t2.getBlue());

        return (r+g+b > 50);
    }
}
