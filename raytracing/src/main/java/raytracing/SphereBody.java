/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import javax.vecmath.Point3f;

// Represents a sphere with radius `radius` and center in [0, 0, 0].
public class SphereBody implements Body {
    
    private final float radiusSquare;
    
    public SphereBody(float radius) {
        this.radiusSquare = radius * radius;
    }

    @Override
    public float f(float[/*3*/] p) {
        Point3f point = new Point3f(p);
        return point.x * point.x + point.y * point.y + point.z * point.z - radiusSquare;
    }

    @Override
    public float fx(float[/*3*/] p) {
        Point3f point = new Point3f(p);
        return 2 * point.x;
    }

    @Override
    public float fy(float[/*3*/] p) {
        Point3f point = new Point3f(p);
        return 2 * point.y;
    }

    @Override
    public float fz(float[/*3*/] p) {
        Point3f point = new Point3f(p);
        return 2 * point.z;
    }
    
}
