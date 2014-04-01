package raytracing;

/**
 * 
 * @author Filip Bartek
 */
public class ScaledBody extends TransformedBody {

    private final Tuple3f scale;
    
    /**
     * @param body
     * @param scale Each component must be nonzero!
     */
    public ScaledBody(Body body, Tuple3f scale) {
        super(body);
        assert scale.x != 0;
        assert scale.y != 0;
        assert scale.z != 0;
        this.scale = scale;
    }
    
    private float[/*3*/] getScaledPoint(float[/*3*/] point) {
        point[0] /= scale.x;
        point[1] /= scale.y;
        point[2] /= scale.z;
        return point;
    }
    
    @Override
    public float f(float[] point) {
        return body.f(getScaledPoint(point));
    }

    @Override
    public float fx(float[] point) {
        return body.fx(getScaledPoint(point)) * scale.x;
    }

    @Override
    public float fy(float[] point) {
        return body.fy(getScaledPoint(point)) * scale.y;
    }

    @Override
    public float fz(float[] point) {
        return body.fz(getScaledPoint(point)) * scale.z;
    }
    
}
