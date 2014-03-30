package raytracing;

/**
 *
 * @author Filip Bartek
 */
public class IntersectionRay extends Intersection {
    public Ray ray;
    public float t;
    
    public IntersectionRay(Ray ray, float t, Body body, boolean hitApprox, boolean hitExact) {
        super(body, hitApprox, hitExact);
        this.ray = ray;
        this.t = t;
    }
    
    @Override
    public Tuple3f getPoint() {
        return ray.rayPoint(t);
    }
}
