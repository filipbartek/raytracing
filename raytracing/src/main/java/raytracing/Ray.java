
package raytracing;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

/**
 *
 * @author Filip Bartek
 */
public class Ray {
    public Point3f startingPoint;
    public Vector3f dir;
    
    public Point3f rayPoint(float t) {
        assert t != Float.NaN;
        Vector3f rayShift = (Vector3f) dir.clone();
        rayShift.scale(t);
        Point3f rayPoint = (Point3f) startingPoint.clone();
        rayPoint.add(rayShift);
        return rayPoint;
    }
}
