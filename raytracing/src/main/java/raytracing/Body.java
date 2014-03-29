package raytracing;

import javax.vecmath.Point3f;

/**
 *
 * @author Filip Bartek
 */
public interface Body {
    // Implicit function that defines the body
    float f(Point3f point);
    
    // Partial derivations of f
    float fx(Point3f point);
    float fy(Point3f point);
    float fz(Point3f point);
}
