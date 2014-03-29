
package raytracing;

// Dummy body

import javax.vecmath.Point3f;

// Returns zero in all functions
public class ZeroBody implements Body {

    @Override
    public float f(float[/*3*/] point) {
        return 0;
    }

    @Override
    public float fx(float[/*3*/] point) {
        return 0;
    }

    @Override
    public float fy(float[/*3*/] point) {
        return 0;
    }

    @Override
    public float fz(float[/*3*/] point) {
        return 0;
    }
    
}
