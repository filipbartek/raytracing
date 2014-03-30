package raytracing;

import java.awt.Color;


public abstract class ColoredBody implements Body {
    
    private final Color color;
    
    public ColoredBody(Color color) {
        this.color = color;
    }

    @Override
    public abstract float f(float[] point);

    @Override
    public abstract float fx(float[] point);

    @Override
    public abstract float fy(float[] point);

    @Override
    public abstract float fz(float[] point);

    @Override
    public Color getColor() {
        return color;
    }
    
}
