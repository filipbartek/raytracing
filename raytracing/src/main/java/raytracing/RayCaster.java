
package raytracing;

/**
 *
 * @author Filip Bartek
 */
public interface RayCaster {
    /**
     * @param rayPoint
     * @param rayDir
     * @param bodies
     * @return Coordinates of intersection
     */
    float[/*3*/] castRay(float[/*3*/] rayPoint, float[/*3*/] rayDir, Body[] bodies);
}
