package raytracing;

import java.awt.Color;

/**
 * http://en.wikipedia.org/wiki/Ellipsoid
 * @author Neva
 * @author Filip Bartek
 */
public class Elipsoid extends ColoredBody implements Body {

	private final float a;
	private final float b;
	private final float c;
    
    public Elipsoid(Color color, float a, float b, float c ) {
        super(color);
		this.a=a;
		this.b=b;
		this.c=c;
    }

	public float getC(){return c*c;}
	public float getA(){return a*a;}
	public float getB(){return b*b;}
	
    /**
     * Returns the value of implicit descriptive function of the ellipsoid
     * Value: x^2/a^2 + y^2/b^2 + z^2/c^2 - 1
     * @param p {x, y, z}
     * @return Value of f(p)
     */
    @Override
    public float f(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return (point.x * point.x)/getA() + (point.y * point.y)/getB() + (point.z * point.z)/getC() - 1;
    }

    /**
     * Value: 2x / a^2
     * @param p
     * @return Partial derivative of f with respect to x
     */
    @Override
    public float fx(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return (2 * point.x)/getA();
    }

    @Override
    public float fy(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return (2 * point.y)/getB();
    }

    @Override
    public float fz(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return (2 * point.z)*getC();
    }
    
}