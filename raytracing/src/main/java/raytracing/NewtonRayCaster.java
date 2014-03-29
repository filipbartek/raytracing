
package raytracing;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;


public class NewtonRayCaster implements RayCaster {
    
    private final float step;
    private final float limit;
    private final int approxSteps;
    
    public NewtonRayCaster(float step, float limit, int approxSteps) {
        assert step > 0;
        // TODO: Assert `step` is large enough to change `t` in each iteration.
        assert approxSteps >= 0;
        this.step = step;
        this.limit = limit;
        this.approxSteps = approxSteps;
    }

    // TODO: Generalize for more than one body.
    // Returns null if ray doesn't hit any body
    @Override
    public Point3f castRay(Ray ray, Body[] bodies) {
        assert bodies.length == 1; // TODO: Generalize.
        
        float t = stepT(ray, bodies);
        // assert t >= 0;
        if (t == 0) {
            return (Point3f) ray.startingPoint.clone();
        }
        if (t == Float.POSITIVE_INFINITY) {
            return null;
        }
        // assert t > 0;
        // assert t < Float.POSITIVE_INFINITY;
        t = approximateT(ray, bodies[0], t);
        
        return ray.rayPoint(t);
    }
    
    // Estimate t by making linear steps
    // Returns the lowest t that changes sign of bodies[0].f or reaches f equal to 0
    // Returns POSITIVE_INFINITY if t surpasses limit
    private float stepT(Ray ray, Body[] bodies) {
        // Temporary:
        assert bodies.length == 1;
        Body body = bodies[0];
        
        float fSignumPrev = Float.NaN;
        float t;
        for (t = 0; t < limit; t += step) {
            Point3f rayPoint = ray.rayPoint(t);
            // Now we have rayPoint for this iteration (value of t).
            float fVal = body.f(rayPoint);
            assert !Float.isNaN(fVal);
            if (fVal == 0) {
                break;
            }
            // assert fVal != 0;
            float fSignum = Math.signum(fVal);
            // assert fSignum != 0;
            // assert fSignum != Float.NaN;
            if (!Float.isNaN(fSignumPrev)) {
                // We're not in the first iteration.
                if (fSignum != fSignumPrev) {
                    break;
                }
            }
            fSignumPrev = fSignum;
        }
        
        if (t >= limit) {
            t = Float.POSITIVE_INFINITY;
        }
        
        return t;
    }
    
    // Apply Newton's approximation method
    private float approximateT(Ray ray, Body body, float t) {
        for (int i = 0; i < approxSteps; i++) {
            Point3f rayPoint = ray.rayPoint(t);
            float fVal = body.f(rayPoint);
            assert !Float.isNaN(fVal);
            if (fVal == 0) {
                return t;
            }
            float fxVal = body.fx(rayPoint);
            float fyVal = body.fy(rayPoint);
            float fzVal = body.fz(rayPoint);
            Vector3f dir = ray.dir;
            float gPrime = dir.x * fxVal + dir.y * fyVal + dir.z * fzVal;
            float change = fVal / gPrime;
            t -= change;
        }
        return t;
    }
    
}
