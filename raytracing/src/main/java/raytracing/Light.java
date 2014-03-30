package raytracing;

import java.awt.Color;

/**
 *
 * @author Filip Bartek
 */
public interface Light {
    public Tuple3f getDirection(Tuple3f point);
    public Color getColor();
}
