
package raytracing;


public class NewtonRayCaster implements RayCaster {
    
    private final float step;
    private final float limit;
    
    public NewtonRayCaster(float step, float limit) {
        this.step = step;
        this.limit = limit;
    }

    @Override
    public float[] castRay(Ray ray, Body[] bodies) {
        float[] result = {0, 0, 0};
        for (float t = 0; t < limit; t += step) {
            float[] point = ray.startingPoint;
        }
        return result;
    }
    
}
