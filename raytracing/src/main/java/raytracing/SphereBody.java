/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import javax.vecmath.Point3f;


public class SphereBody implements Body {
    
    private final float radiusSquare;
    
    public SphereBody(float radius) {
        this.radiusSquare = radius * radius;
    }

    @Override
    public float f(Point3f point) {
        return point.x * point.x + point.y * point.y + point.z * point.z - radiusSquare;
    }

    @Override
    public float fx(Point3f point) {
        return 2 * point.x;
    }

    @Override
    public float fy(Point3f point) {
        return 2 * point.y;
    }

    @Override
    public float fz(Point3f point) {
        return 2 * point.z;
    }
    
}
