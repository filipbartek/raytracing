package raytracing;

import java.awt.Color;

/**
 *
 * @author Filip Bartek
 */
public interface Light {
    /**
     * Gets the direction of the light in a given point.
     * @param point
     * @return Directional vector of light in `point`
     */
    public float[/*3*/] getDirection(float[/*3*/] point);
    
    /**
     * @return Color of the light
     */
    public Color getColor();
}
