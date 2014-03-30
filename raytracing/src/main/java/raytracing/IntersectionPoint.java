package raytracing;

/**
 *
 * @author Filip Bartek
 */
public class IntersectionPoint extends Intersection {
    public Tuple3f point;
    
    public IntersectionPoint(Tuple3f point, Body body) {
        super();
        this.point = point;
        this.body = body;
    }
    
    @Override
    public Tuple3f getPoint() {
        return point;
    }
}
