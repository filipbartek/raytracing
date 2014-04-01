package raytracing;

import java.awt.Color;

public class Elipsoid extends ColoredBody implements Body {

	private final float a;
	private final float b;
	private final float c;
	
	int d=1;
    
    public Elipsoid(Color color, float a, float b, float c ) {
        super(color);
		this.a=a;
		this.b=b;
		this.c=c;
    }

	public float getC(){return c*c;}
	public float getA(){return a*a;}
	public float getB(){return b*b;}
	
    @Override
    public float f(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return (point.x * point.x)/getA() + (point.y * point.y)/getB() + (point.z * point.z)/getC() - d;
    }

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