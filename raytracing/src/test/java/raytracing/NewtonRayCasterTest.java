/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Filip Bartek
 */
public class NewtonRayCasterTest {
    
    public NewtonRayCasterTest() {
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
     * Test of castRay method, of class NewtonRayCaster.
     */
    @Test
    public void testCastRay() {
        System.out.println("castRay");
        
        Tuple3f startingPoint = new Tuple3f(2, 2, 2);
        Tuple3f dir = new Tuple3f(-1, -1, -1);
        float step = 1.0f / 2;
        float limit = 10;
        int approxSteps = 16;
        float radius = 1;
        float expCoord = (float) Math.sqrt(radius * radius / 3);
        float[] expResult = {expCoord, expCoord, expCoord};
        double delta = 0.0;
        Color color = Color.WHITE;
        
        Ray ray = new Ray(startingPoint, dir);
        Body body0 = new SphereBody(color, radius);
        Body body1 = new SphereBody(color, radius / 2);
        Body[] bodies = {body0, body1};
        NewtonRayCaster instance = new NewtonRayCaster(step, limit, approxSteps);
        
        Intersection result = instance.castRay(ray, bodies);
        
        float[] resultFloat = result.getPointFloat();
        for (int i = 0; i < 3; i++) {
            assertEquals(expResult[i], resultFloat[i], delta);
        }
    }
    
}
