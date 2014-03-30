package raytracing;

import java.awt.Color;

/**
 *
 * @author Filip Bartek
 */
public class Scene {
    private final Body[] bodies;
    private final Light[] lights;
    private final RayCaster rayCaster;
    private final LightingModel lighting;
    
    public Scene(Body[] bodies, Light[] lights, RayCaster rayCaster, LightingModel lighting) {
        this.bodies = bodies;
        this.lights = lights;
        this.rayCaster = rayCaster;
        this.lighting = lighting;
    }
    
    /**
     * Returns color of a given ray.
     * The ray corresponds to a pixel in screen.
     * @param ray
     * @return color of the intersection
     */
    public Color getRGB(Ray ray) {
        Intersection intersection = rayCaster.castRay(ray, bodies);
        Color color = lighting.getRGB(intersection, lights);
        return color;
    }
}
