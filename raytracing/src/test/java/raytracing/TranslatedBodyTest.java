package raytracing;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filip Bartek
 */
public class TranslatedBodyTest {
    
    public TranslatedBodyTest() {
    }

    /**
     * Test of f method, of class TranslatedBody.
     */
    @Test
    public void testF() {
        System.out.println("f");
        
        Body body = new SphereBody(Color.WHITE, 2);
        Tuple3f translation = new Tuple3f(0, 1, 2);
        TranslatedBody instance = new TranslatedBody(body, translation);
        
        float[] point = {0, 1, 0};
        float expResult = 0.0F;
        
        float result = instance.f(point);
        
        assertEquals(expResult, result, 0.0);
        
        expResult = -4.0f;
        point[0] = 0;
        point[1] = 1;
        point[2] = 2;
        
        result = instance.f(point);
        
        assertEquals(expResult, result, 0.0);
    }
    
}
