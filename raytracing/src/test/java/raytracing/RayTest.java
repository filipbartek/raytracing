/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filip Bartek
 */
public class RayTest {
    
    public RayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of rayPoint method, of class Ray.
     */
    @Test
    public void testRayPoint() {
        System.out.println("rayPoint");
        
        Tuple3f startingPoint = new Tuple3f(0, 0, 0);
        Tuple3f dir = new Tuple3f(1, 1, 1);
        dir.normalize();
        float t = 1.5f;
        
        float expCoord = (float) Math.sqrt(t * t / 3);
        Tuple3f expResult = new Tuple3f(expCoord, expCoord, expCoord);
        Ray instance = new Ray(startingPoint, dir);
        
        Tuple3f result = instance.rayPoint(t);
        
        assertEquals(expResult, result);
    }
    
}
