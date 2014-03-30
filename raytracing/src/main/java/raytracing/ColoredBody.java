package raytracing;

import java.awt.Color;

/**
 * Body that has a color
 * @author Filip Bartek
 */
public abstract class ColoredBody implements Body {
    
    private final Color color;
    
    public ColoredBody(Color color) {
        this.color = color;
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public abstract float f(float[] point);

    @Override
    public abstract float fx(float[] point);

    @Override
    public abstract float fy(float[] point);

    @Override
    public abstract float fz(float[] point);
    
}
