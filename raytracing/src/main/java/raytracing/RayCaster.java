
package raytracing;

import javax.vecmath.Point3f;

/**
 *
 * @author Filip Bartek
 */
public interface RayCaster {
    /**
     * @param ray
     * @param bodies
     * @return Coordinates of intersection
     */
    Point3f castRay(Ray ray, Body[] bodies);
}
