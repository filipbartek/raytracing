
package raytracing;

// Dummy body
// Returns zero in all functions
public class ZeroBody implements Body {

    @Override
    public double f(double x, double y, double z) {
        return 0;
    }

    @Override
    public double fx(double x, double y, double z) {
        return 0;
    }

    @Override
    public double fy(double x, double y, double z) {
        return 0;
    }

    @Override
    public double fz(double x, double y, double z) {
        return 0;
    }
    
}
