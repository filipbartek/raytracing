
package raytracing;

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
    
    @Override
    public float[/*3*/] castRay(float[/*3*/] rayPoint, float[/*3*/] rayDir, Body[] bodies) {
        Tuple3f startingPoint = new Tuple3f(rayPoint);
        Tuple3f dir = new Tuple3f(rayDir);
        Ray ray = new Ray(startingPoint, dir);
        Intersection intersection = castRay(ray, bodies);
        return intersection.getPoint().getFloat(); // TODO: Return the whole intersection information.
    }

    // TODO: Generalize for more than one body.
    // Returns null if ray doesn't hit any body
    private IntersectionRay castRay(Ray ray, Body[] bodies) {
        assert bodies.length == 1; // TODO: Generalize.
        
        IntersectionRay intersection = stepT(ray, bodies);
        if (!intersection.hitApprox || intersection.hitExact) {
            return intersection;
        }
        // assert t > 0;
        // assert t < Float.POSITIVE_INFINITY;
        intersection.t -= step / 2;
        
        intersection = approximateT(intersection);
        
        return intersection;
    }
    
    // Estimate t by making linear steps
    // Returns the lowest t that changes sign of bodies[0].f or reaches f equal to 0
    // Returns POSITIVE_INFINITY if t surpasses limit
    private IntersectionRay stepT(Ray ray, Body[] bodies) {
        assert bodies.length == 1; // TODO: Generalize.
        Body body = bodies[0];
        
        float fSignumPrev = Float.NaN; // Only stays NaN in first iteration
        float t;
        boolean hitApprox = false;
        boolean hitExact = false;
        for (t = 0; t < limit; t += step) {
            Tuple3f rayPoint = ray.rayPoint(t);
            // Now we have rayPoint for this iteration (value of t).
            float fVal = body.f(rayPoint.getFloat());
            assert !Float.isNaN(fVal);
            if (fVal == 0) {
                hitApprox = true;
                hitExact = true;
                break;
            }
            // assert fVal != 0;
            float fSignum = Math.signum(fVal);
            // assert fSignum != 0;
            // assert fSignum != Float.NaN;
            if (!Float.isNaN(fSignumPrev)) {
                // We're not in the first iteration.
                if (fSignum != fSignumPrev) {
                    hitApprox = true;
                    break;
                }
            }
            fSignumPrev = fSignum;
        }
        
        if (t >= limit) {
            t = Float.POSITIVE_INFINITY;
        }
        
        return new IntersectionRay(ray, t, body, hitApprox, hitExact);
    }
    
    /** Apply Newton's approximation method
     * 
     * @param ray
     * @param body
     * @param t Approximation of `t`
     * @return Always `hitApprox` true
     */
    private IntersectionRay approximateT(IntersectionRay intersection) {
        assert intersection.hitApprox;
        Ray ray = intersection.ray;
        Body body = intersection.body;
        float t = intersection.t;
        float tPrev = Float.NaN;
        for (int i = 0; i < approxSteps; i++) {
            Tuple3f rayPoint = ray.rayPoint(t);
            float fVal = body.f(rayPoint.getFloat());
            assert !Float.isNaN(fVal);
            if (fVal == 0) {
                return new IntersectionRay(ray, t, body, true, true);
            }
            if (i >= approxSteps - 1) {
                // Don't compute new value of `t` in the last iteration.
                break;
            }
            float fxVal = body.fx(rayPoint.getFloat());
            float fyVal = body.fy(rayPoint.getFloat());
            float fzVal = body.fz(rayPoint.getFloat());
            Tuple3f dir = ray.dir;
            float gPrime = dir.x * fxVal + dir.y * fyVal + dir.z * fzVal;
            float change = fVal / gPrime;
            t -= change;
            if (t == tPrev) {
                // t doesn't change when `change` is too small
                break;
            }
            // Note that `t` may oscillate between two values;
            // then unnecessary iterations will occur.
            tPrev = t;
        }
        return new IntersectionRay(ray, t, body, true, false);
    }
    
}
