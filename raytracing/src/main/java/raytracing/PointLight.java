package raytracing;

import java.awt.Color;

public class PointLight implements Light {
    
    private final Tuple3f position;
    private final Color color;
    
    public PointLight(Tuple3f position, Color color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public float[] getDirection(float[] point) {
        Tuple3f pointTuple = new Tuple3f(point);
        pointTuple.sub(position);
        pointTuple.normalize();
        return pointTuple.getFloat();
    }

    @Override
    public Color getColor() {
        return color;
    }
    
}
