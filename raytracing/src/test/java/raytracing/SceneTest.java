/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Filip Bartek
 */
public class SceneTest {
    
    private static Color colorLeft;
    private static Color colorRight;
    private static Color bgColor;
    private static Scene scene;

    @BeforeClass
    public static void setUpClass() throws Exception {
        colorLeft = Color.RED;
        Body body0 = new TranslatedBody(new SphereBody(colorLeft, 2.0f), new Tuple3f(-1, 0, 0));
        colorRight = Color.YELLOW;
        Body body1 = new TranslatedBody(new SphereBody(colorRight, 2.0f), new Tuple3f(1, 0, 0));
        Light light0 = new PointLight(new Tuple3f(0, 0, -8), Color.WHITE);
        Light light1 = new PointLight(new Tuple3f(0, 0, -8), Color.WHITE);
        float step = 1.0f / 32;
        float limit = 32;
        int approxSteps = 16;
        LightingModel lighting = new ColorInterpolation();
        bgColor = Color.BLACK;
        
        Body[] bodies = {body0, body1};
        Light[] lights = {light0, light1};
        RayCaster rayCaster = new NewtonRayCaster(step, limit, approxSteps);
        scene = new Scene(bodies, lights, rayCaster, lighting, bgColor);
    }

    /**
     * Test of getRGB method, of class Scene.
     */
    @Test
    public void testGetRGBBody() {
        System.out.println("getRGB body");
        
        Ray rayLeft = new Ray(new Tuple3f(-1, 0, -4), new Tuple3f(0, 0, 1));
        Color resultLeft = scene.getRGB(rayLeft);
        assertEquals(colorLeft, resultLeft);
        
        Ray rayRight = new Ray(new Tuple3f(1, 0, -4), new Tuple3f(0, 0, 1));
        Color resultRight = scene.getRGB(rayRight);
        assertEquals(colorRight, resultRight);
    }
    
    /**
     * Test of getRGB method, of class Scene.
     */
    @Test
    public void testGetRGBBg() {
        System.out.println("getRGB background");
        
        Ray rayBg = new Ray(new Tuple3f(0, 4, -4), new Tuple3f(0, 0, 1));
        Color resultBg = scene.getRGB(rayBg);
        assertEquals(bgColor, resultBg);
    }
    
}
