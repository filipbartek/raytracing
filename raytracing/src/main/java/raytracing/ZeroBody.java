
package raytracing;

// Dummy body

import javax.vecmath.Point3f;

// Returns zero in all functions
public class ZeroBody implements Body {

    @Override
    public float f(Point3f point) {
        return 0;
    }

    @Override
    public float fx(Point3f point) {
        return 0;
    }

    @Override
    public float fy(Point3f point) {
        return 0;
    }

    @Override
    public float fz(Point3f point) {
        return 0;
    }
    
}
