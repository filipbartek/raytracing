package raytracing;

import java.awt.Color;

/**
 *
 * @author Filip Bartek
 */
public interface LightingModel {
    public Color getRGB(Intersection intersection, Light[] lights);
}
