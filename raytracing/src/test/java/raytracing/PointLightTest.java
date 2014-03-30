/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filip Bartek
 */
public class PointLightTest {
    
    public PointLightTest() {
    }

    /**
     * Test of getDirection method, of class PointLight.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        
        Tuple3f position = new Tuple3f(1, 0, 0);
        Color color = Color.WHITE;
        float[] point = {3, 2, 2};
        float expCoord = (float) Math.sqrt(1.0 / 3);
        float[] expResult = {expCoord, expCoord, expCoord};
        
        PointLight instance = new PointLight(position, color);
        
        float[] result = instance.getDirection(point);
        
        assertArrayEquals(expResult, result, 0.0f);
    }

    /**
     * Test of getColor method, of class PointLight.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        
        Tuple3f position = new Tuple3f(0, 0, 0);
        Color color = Color.WHITE;
        Color expResult = Color.WHITE;
        
        PointLight instance = new PointLight(position, color);
        
        
        Color result = instance.getColor();
        
        assertEquals(expResult, result);
    }
    
}
