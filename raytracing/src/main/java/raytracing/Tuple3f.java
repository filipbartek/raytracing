package raytracing;

/**
 * Mimics javax.vecmath.Tuple3f
 *   Reference: http://download.java.net/media/java3d/javadoc/1.3.2/javax/vecmath/Tuple3f.html
 *   Source: https://java.net/projects/vecmath/sources/svn/content/trunk/src/javax/vecmath/Tuple3f.java
 * Encapsulates three real (`float`) coordinates (a point or vector in 3D)
 * @author Filip Bartek
 */
public class Tuple3f implements Cloneable {
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
    
    /**
     * @return Array of length 3 that contains the coordinates
     */
    public final float[/*3*/] getFloat() {
        float[/*3*/] result = {this.x, this.y, this.z};
        return result;
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
    
    public final void sub(Tuple3f t) {
        this.x -= t.x;
        this.y -= t.y;
        this.z -= t.z;
    }
    
    public final void scale(float s) {
        this.x *= s;
        this.y *= s;
        this.z *= s;
    }
    
    public final float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
    
    public void normalize() {
        float s = 1.0f / length();
        scale(s);
    }
    
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Float.floatToIntBits(this.x);
        hash = 47 * hash + Float.floatToIntBits(this.y);
        hash = 47 * hash + Float.floatToIntBits(this.z);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tuple3f other = (Tuple3f) obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        if (Float.floatToIntBits(this.z) != Float.floatToIntBits(other.z)) {
            return false;
        }
        return true;
    }
}
