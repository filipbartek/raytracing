package raytracing;

/**
 *
 * @author Filip Bartek
 */
public interface Body {
    // Implicit function that defines the body
    double f(double x, double y, double z);
    
    // Partial derivations of f
    double fx(double x, double y, double z);
    double fy(double x, double y, double z);
    double fz(double x, double y, double z);
}
