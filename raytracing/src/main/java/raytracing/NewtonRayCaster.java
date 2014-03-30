
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
    public Intersection castRay(Ray ray, Body[] bodies) {
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
    
    // Estimate t by making linearly spaced steps
    // TODO: Identify the intersecting body more precisely
    private IntersectionRay stepT(Ray ray, Body[] bodies) {
        float t;
        boolean hitApprox = false;
        boolean hitExact = false;
        float[] fSignumsPrev = new float[bodies.length];
        int i = 0;
        Tuple3f stepVec = (Tuple3f) ray.dir.clone();
        stepVec.scale(step);
        Tuple3f rayPoint = (Tuple3f) ray.startingPoint.clone();
        for (t = 0.0f; t < limit; t += step) {
            // assert rayPoint.equals(ray.rayPoint(t));
            // Now we have rayPoint for this iteration (value of t).
            for (i = 0; i < bodies.length; i++) {
                Body body = bodies[i];
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
                if (t != 0.0f) {
                    // We're not in the first iteration.
                    if (fSignum != fSignumsPrev[i]) {
                        hitApprox = true;
                        break;
                    }
                }
                fSignumsPrev[i] = fSignum;
            }
            if (hitApprox) {
                break;
            }
            rayPoint.add(stepVec);
        }
        
        if (t >= limit) {
            t = Float.POSITIVE_INFINITY;
        }
        
        return new IntersectionRay(ray, t, bodies[i], hitApprox, hitExact);
    }
    
    /** Apply Newton's approximation method
     * 
     * @param intersection Approximate intersection
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
