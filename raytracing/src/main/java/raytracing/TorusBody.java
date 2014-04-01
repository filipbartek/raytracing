package raytracing;

import java.awt.Color;

public class TorusBody extends ColoredBody implements Body {
    
    private final float minorRadius;
	private final float majorRadius;
    
    public TorusBody(Color color, float location, float minorRadius, float majorRadius) {
        super(color);
        this.minorRadius = minorRadius;
		this.majorRadius = majorRadius;
    }

	public float gmajorRadius(){return majorRadius;}
	public float gminorRadius(){return minorRadius*minorRadius;}
	
    @Override
    public float f(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return (gmajorRadius()-(float)Math.sqrt(point.x * point.x + point.y * point.y))*(gmajorRadius()-(float)Math.sqrt(point.x * point.x + point.y * point.y)) + point.z * point.z - gminorRadius();
    }

    @Override
    public float fx(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return 2 * point.x;
    }

    @Override
    public float fy(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return 2 * point.y;
    }

    @Override
    public float fz(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return 2 * point.z;
    }
    
}