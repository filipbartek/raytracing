
package raytracing;

/**
 *
 * @author Filip Bartek
 */
public class Ray {
    public Tuple3f startingPoint;
    public Tuple3f dir;
    private float tPrev;
    private Tuple3f pointPrev;
    
    public Ray(Tuple3f startingPoint, Tuple3f dir) {
        this.startingPoint = startingPoint;
        this.dir = dir;
        this.tPrev = Float.NaN;
        this.pointPrev = null;
    }
    /*
    Basic usage:
    float[] startingPoint = {0, 0, 0};
    float[] directionVector = {1, 1, 1};
    Ray ray = new Ray(new Tuple3f(startingPoint), new Tuple3f(directionVector));
    */

    public Tuple3f rayPoint(float t) {
        assert !Float.isNaN(t);
        if (t == tPrev) {
            // Previous call had the same `t` parameter.
            // Reuse the previous ray point.
            return (Tuple3f) pointPrev.clone();
        }
        Tuple3f rayShift = (Tuple3f) dir.clone();
        rayShift.scale(t);
        Tuple3f rayPoint = (Tuple3f) startingPoint.clone();
        rayPoint.add(rayShift);
        // Save the parameter and the result for possible optimization.
        tPrev = t;
        pointPrev = (Tuple3f) rayPoint.clone();
        return rayPoint;
    }
}
