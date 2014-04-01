import java.awt.Color;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import raytracing.Body;
import raytracing.ColorInterpolation;
import raytracing.Light;
import raytracing.LightingModel;
import raytracing.MemoizedBody;
import raytracing.NewtonRayCaster;
import raytracing.PointLight;
import raytracing.RayCaster;
import raytracing.Scene;
import raytracing.SphereBody;
import raytracing.TranslatedBody;
import raytracing.Tuple3f;

/**
 *
 * @author Filip Bartek
 */
public class PrikazovalnikTest {
    
    private Camera cam;
    private Scene scene;
    private int resX;
    private int resY;
    
    private static Scene buildScene() {
        Color colorLeft = Color.RED;
        Color colorRight = Color.YELLOW;
        Body body0 = new MemoizedBody(new TranslatedBody(new SphereBody(colorRight, 0.75f), new Tuple3f(-1, 0, 0)));
        Body body1 = new MemoizedBody(new TranslatedBody(new SphereBody(colorRight, 0.75f), new Tuple3f(1, 0, 0)));
        Body body2 = new MemoizedBody(new TranslatedBody(new SphereBody(colorLeft, 1.0f), new Tuple3f(0, -1, 0)));
        Light light0 = new PointLight(new Tuple3f(0, 5, 0), Color.WHITE);
        Light light1 = new PointLight(new Tuple3f(0, 5, 5), Color.WHITE);
        float step = 1.0f / 8;
        float limit = 32;
        int approxSteps = 16;
        LightingModel lighting = new ColorInterpolation();
        Color bgColor = Color.DARK_GRAY;
        
        Body[] bodies = {body0, body1, body2};
        Light[] lights = {light0, light1};
        RayCaster rayCaster = new NewtonRayCaster(step, limit, approxSteps);
        
        return new Scene(bodies, lights, rayCaster, lighting, bgColor);
    }
    
    @Before
    public void setUp() {
        float[] loc={0,-0.6f,4};
        float[] dir={0,0,-1};
        
        cam = new Camera(loc,dir);
        scene = buildScene();
        
        resX = 256;
        resY = 256;
    }
    
    /**
     * Test of render method, of class Prikazovalnik.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        
        Prikazovalnik instance = new Prikazovalnik();
        instance.render(cam, scene, resX, resY);
    }
}
