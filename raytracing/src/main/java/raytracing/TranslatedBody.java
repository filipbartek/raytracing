package raytracing;

/**
 * Translates a body (i.e. moves in space)
 * @author Filip Bartek
 */
public class TranslatedBody extends TransformedBody {

    private final Tuple3f translation;
    
    public TranslatedBody(Body body, Tuple3f translation) {
        super(body);
        this.translation = translation;
    }
    
    private float[/*3*/] getTranslatedPoint(float[/*3*/] point) {
        float[] result = {point[0] - translation.x, point[1] - translation.y, point[2] - translation.z};
        return result;
    }
    
    @Override
    public float f(float[] point) {
        return body.f(getTranslatedPoint(point));
    }

    @Override
    public float fx(float[] point) {
        return body.fx(getTranslatedPoint(point));
    }

    @Override
    public float fy(float[] point) {
        return body.fy(getTranslatedPoint(point));
    }

    @Override
    public float fz(float[] point) {
        return body.fz(getTranslatedPoint(point));
    }
    
}
/*
Usage:

Body body = new SphereBody(Color.WHITE, 1);
Tuple3f translation = new Tuple3f(1, 2, 3);
TranslatedBody tBody = new TranslatedBody(body, translation);
float[] point = {1, 2, 2};
float fVal = tBody.f(point);
assert fVal == 0;
*/
