/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

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
    @org.junit.Test
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
        
        Ray ray = new Ray(startingPoint, dir);
        float[] rayPoint = ray.startingPoint.getFloat();
        float[] rayDir = ray.dir.getFloat();
        Body body0 = new SphereBody(radius);
        Body body1 = new SphereBody(radius / 2);
        Body[] bodies = {body0, body1};
        NewtonRayCaster instance = new NewtonRayCaster(step, limit, approxSteps);
        float[] result = instance.castRay(rayPoint, rayDir, bodies);
        for (int i = 0; i < 3; i++) {
            assertEquals(expResult[i], result[i], delta);
        }
    }
    
}
