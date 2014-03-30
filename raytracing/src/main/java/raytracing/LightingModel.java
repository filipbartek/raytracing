package raytracing;

import java.awt.Color;

/**
 *
 * @author Filip Bartek
 */
public interface LightingModel {
    /**
     * Get color of the intersection point with the given lights
     * @param intersection
     * @param lights
     * @return Color of the point of intersection
     */
    public Color getRGB(Intersection intersection, Light[] lights);
}
