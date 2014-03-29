
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

    public Tuple3f rayPoint(float t) {
        assert !Float.isNaN(t);
        Tuple3f rayShift = (Tuple3f) dir.clone();
        rayShift.scale(t);
        Tuple3f rayPoint = (Tuple3f) startingPoint.clone();
        rayPoint.add(rayShift);
        return rayPoint;
    }
}
