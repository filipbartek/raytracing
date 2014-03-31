package raytracing;

import java.awt.Color;

public abstract class TransformedBody implements Body {
    
    protected final Body body;
    
    public TransformedBody(Body body) {
        this.body = body;
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
        return body.getColor();
    }
    
}
