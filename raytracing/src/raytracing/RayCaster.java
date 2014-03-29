
package raytracing;

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
    double[/*3*/] castRay(Ray ray, Body[] bodies);
}
