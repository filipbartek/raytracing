package raytracing;

import java.awt.Color;

public class MemoizedBody implements Body {

    private final Body body;
    private float[] prevFPoint;
    private float prevFVal;
    
    public MemoizedBody(Body body) {
        this.body = body;
        float[] prevFPointInit = {Float.NaN, Float.NaN, Float.NaN};
        this.prevFPoint = prevFPointInit;
    }
    
    @Override
    public float f(float[] point) {
        if (point == prevFPoint) {
            return prevFVal;
        }
        prevFPoint = point;
        prevFVal = body.f(point);
        return prevFVal;
    }

    @Override
    public float fx(float[] point) {
        return body.fx(point);
    }

    @Override
    public float fy(float[] point) {
        return body.fy(point);
    }

    @Override
    public float fz(float[] point) {
        return body.fz(point);
    }

    @Override
    public Color getColor() {
        return body.getColor();
    }
    
}
