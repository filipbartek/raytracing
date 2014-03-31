package raytracing;

public class TranslatedBody extends TransformedBody {

    private final Tuple3f translation;
    
    public TranslatedBody(Body body, Tuple3f translation) {
        super(body);
        this.translation = translation;
    }
    
    private float[/*3*/] getTranslatedPoint(float[/*3*/] point) {
        Tuple3f p = new Tuple3f(point);
        p.sub(translation);
        return p.getFloat();
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
