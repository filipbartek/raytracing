package raytracing;

/**
 *
 * @author Filip Bartek
 */
public interface Body {
    // Implicit function that defines the body
    float f(float x, float y, float z);
    
    // Partial derivations of f
    float fx(float x, float y, float z);
    float fy(float x, float y, float z);
    float fz(float x, float y, float z);
}
