package raytracing;

import javax.vecmath.Point3f;

/**
 *
 * @author Filip Bartek
 */
public interface Body {
    // Implicit function that defines the body.
    // f == 0 iff point is on body surface
    // f > 0 iff point is outside of body
    float f(Point3f point);
    
    // Partial derivatives of f
    float fx(Point3f point);
    float fy(Point3f point);
    float fz(Point3f point);
}
