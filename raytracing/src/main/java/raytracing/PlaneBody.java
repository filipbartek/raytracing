/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package raytracing;

import java.awt.Color;

/**
 * YZ plane facing the positive x axis
 * @author Filip Bartek
 */
public class PlaneBody extends ColoredBody {
    
    public PlaneBody(Color color) {
        super(color);
    }
    
    @Override
    public float f(float[] point) {
        return point[0];
    }

    @Override
    public float fx(float[] point) {
        return 1;
    }

    @Override
    public float fy(float[] point) {
        return 0;
    }

    @Override
    public float fz(float[] point) {
        return 0;
    }

}
