/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
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
        
        Point3f startingPoint = new Point3f(2, 2, 2);
        Vector3f dir = new Vector3f(-1, -1, -1);
        float step = 1.0f / 2;
        float limit = 10;
        int approxSteps = 16;
        float radius = 1;
        float expCoord = (float) Math.sqrt(radius * radius / 3);
        Point3f expResult = new Point3f(expCoord, expCoord, expCoord);
        
        Ray ray = new Ray(startingPoint, dir);
        Body body = new SphereBody(radius);
        Body[] bodies = {body};
        NewtonRayCaster instance = new NewtonRayCaster(step, limit, approxSteps);
        Point3f result = instance.castRay(ray, bodies);
        assertEquals(expResult, result);
    }
    
}
