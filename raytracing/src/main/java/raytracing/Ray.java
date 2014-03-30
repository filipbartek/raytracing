
package raytracing;

/**
 *
 * @author Filip Bartek
 */
public class Ray {
    public Tuple3f startingPoint;
    public Tuple3f dir;
    
    public Ray(Tuple3f startingPoint, Tuple3f dir) {
        this.startingPoint = startingPoint;
        this.dir = dir;
    }
    /*
    Basic usage:
    float[] startingPoint = {0, 0, 0};
    float[] directionVector = {1, 1, 1};
    Ray ray = new Ray(new Tuple3f(startingPoint), new Tuple3f(directionVector));
    */

    public Tuple3f rayPoint(float t) {
        assert !Float.isNaN(t);
        Tuple3f rayShift = (Tuple3f) dir.clone();
        rayShift.scale(t);
        Tuple3f rayPoint = (Tuple3f) startingPoint.clone();
        rayPoint.add(rayShift);
        return rayPoint;
    }
}
