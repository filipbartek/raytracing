package raytracing;

/**
 *
 * @author Filip Bartek
 */
public abstract class Intersection {
    public Body body;
    public boolean hitApprox;
    public boolean hitExact;
    
    public Intersection() {
        this.body = null;
        this.hitApprox = false;
        this.hitExact = false;
    }

    public Intersection(Body body, boolean hitApprox, boolean hitExact) {
        this.body = body;
        this.hitApprox = hitApprox;
        this.hitExact = hitExact;
    }

    /**
     * Returns point of intersection with the body.
     * @return intersection point
     */
    public abstract Tuple3f getPoint();

    public float[/*3*/] getPointFloat() {
        return getPoint().getFloat();
    }
}
