package raytracing;

// Represents a sphere with radius `radius` and center in [0, 0, 0].

import java.awt.Color;

public class SphereBody extends ColoredBody {
    
    private final float radiusSquare;
    
    public SphereBody(Color color, float radius) {
        super(color);
        this.radiusSquare = radius * radius;
    }

    @Override
    public float f(float[/*3*/] p) {
        Tuple3f point = new Tuple3f(p);
        return point.x * point.x + point.y * point.y + point.z * point.z - radiusSquare;
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
