package raytracing;

import java.awt.Color;

/**
 *
 * @author Filip Bartek
 */
public interface Body {
    // Implicit function that defines the body.
    // f == 0 iff point is on body surface
    // f > 0 iff point is outside of body
    float f(float[/*3*/] point);
    
    // Partial derivatives of f
    float fx(float[/*3*/] point);
    float fy(float[/*3*/] point);
    float fz(float[/*3*/] point);
    
    /**
     * @return Base diffuse color of the body
     */
    Color getColor();
}
