package raytracing;

/**
 *
 * @author Filip Bartek
 */
public class Tuple3f {
    public float x;
    public float y;
    public float z;
    
    public Tuple3f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }
    
    public Tuple3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public final void get(float[] t) {
        t[0] = this.x;
        t[1] = this.y;
        t[2] = this.z;
    }
    
    public Tuple3f(float[/*3*/] t) {
        assert t.length >= 3;
        this.x = t[0];
        this.y = t[1];
        this.z = t[2];
    }
    
    public final void add(Tuple3f t1) {
        this.x += t1.x;
        this.y += t1.y;
        this.z += t1.z;
    }
    
    public final void scale(float s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
    }
}
