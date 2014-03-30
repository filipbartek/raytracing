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
public class Tuple3fTest {
    
    public Tuple3fTest() {
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
     * Test of add method, of class Tuple3f.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Tuple3f instance = new Tuple3f(1, 2, 3);
        Tuple3f t1 = new Tuple3f(2, 3, 4);
        Tuple3f expResult = new Tuple3f(3, 5, 7);
        instance.add(t1);
        assertEquals(expResult, instance);
    }

    /**
     * Test of scale method, of class Tuple3f.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        
        float s = 2.0F;
        Tuple3f instance = new Tuple3f(1, 1, 1);
        Tuple3f expResult = new Tuple3f(s, s, s);
        
        instance.scale(s);
        
        assertEquals(expResult, instance);
    }

    /**
     * Test of clone method, of class Tuple3f.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Tuple3f instance = new Tuple3f();
        Object result = instance.clone();
        assertNotSame(instance, result);
    }

    /**
     * Test of length method, of class Tuple3f.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        Tuple3f instance = new Tuple3f(1, 1, 1);
        float expResult = (float) Math.sqrt(3);
        float result = instance.length();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of normalize method, of class Tuple3f.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        
        Tuple3f instance = new Tuple3f(1, 1, 1);
        float expCoord = (float) Math.sqrt(1.0f / 3);
        Tuple3f expResult = new Tuple3f(expCoord, expCoord, expCoord);
        
        instance.normalize();
        
        assertEquals(expResult, instance);
    }
    
}
