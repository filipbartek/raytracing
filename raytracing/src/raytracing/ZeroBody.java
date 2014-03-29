
package raytracing;

// Dummy body
// Returns zero in all functions
public class ZeroBody implements Body {

    @Override
    public float f(float x, float y, float z) {
        return 0;
    }

    @Override
    public float fx(float x, float y, float z) {
        return 0;
    }

    @Override
    public float fy(float x, float y, float z) {
        return 0;
    }

    @Override
    public float fz(float x, float y, float z) {
        return 0;
    }
    
}
