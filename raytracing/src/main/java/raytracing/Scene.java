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
    
    public Scene(Body[] bodies, Light[] lights, RayCaster rayCaster) {
        this.bodies = bodies;
        this.lights = lights;
        this.rayCaster = rayCaster;
    }
    
    public Color getRGB(Ray ray) {
        Intersection intersection = rayCaster.castRay(ray, bodies);
        return Color.BLACK; // TODO: Replace with actual color at intersection
    }
}
