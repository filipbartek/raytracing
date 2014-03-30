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
    private final Color bgColor; // Background color
    
    public Scene(Body[] bodies, Light[] lights, RayCaster rayCaster,
            LightingModel lighting, Color bgColor) {
        this.bodies = bodies;
        this.lights = lights;
        this.rayCaster = rayCaster;
        this.lighting = lighting;
        this.bgColor = bgColor;
    }
    /*
    Intended example usage:
    Body body0 = new SphereBody(Color.RED, 1.0f);
    Body body1 = new SphereBody(Color.YELLOW, 2.0f);
    Body[] bodies = {body0, body1};
    Light light0 = new PointLight(new Tuple3f(10, 10, 10), Color.WHITE);
    Light light1 = new PointLight(new Tuple3f(-10, 10, 10), Color.MAGENTA);
    Light[] lights = {light0, light1};
    RayCaster rayCaster = new NewtonRayCaster(1.0f / 32, 32, 16);
    LightingModel lighting; // TODO: Instantiate.
    Color bgColor = Color.BLACK;
    Scene scene = new Scene(bodies, lights, rayCaster, lighting, bgColor);
    Color colAtRay = scene.getRGB(ray); // Result! Call once for each pixel.
    */
    
    /**
     * Returns color of first intersection of a given ray.
     * The ray corresponds to a pixel in screen.
     * @param ray
     * @return color of the intersection
     */
    public Color getRGB(Ray ray) {
        Intersection intersection = rayCaster.castRay(ray, bodies);
        if (!intersection.hitApprox) {
            return bgColor;
        }
        Color color = lighting.getRGB(intersection, lights);
        return color;
    }
}
