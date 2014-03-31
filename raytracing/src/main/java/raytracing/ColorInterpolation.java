package raytracing;

import java.awt.Color;

/**
 *
 * @author Jure Malovrh
 */
public class ColorInterpolation implements LightingModel{
	
	
	/*method calculates */
	public static Color ColorCalculatingNoReflection(Intersection i, Light[] l){
		//int [] RGB = {0,0,0};
		
            float[] intersect = i.getPointFloat();
            Body b = i.body;
            float x = b.fx(intersect);
            float y = b.fy(intersect);
            float z = b.fz(intersect);
            
            float[] normal = {x,y,z};
            Color pixelColor = new Color(0,0,0);
            Color c = b.getColor();
            int red = c.getRed();
            int blue = c.getBlue();
            int green = c.getGreen();
            int tmpR=0;
            int tmpG=0;
            int tmpB=0;
            for(Light light : l){
            //float[] lig = light.getDirection(intersect);
                float multiplic = multiplicateVectors(normal,light.getDirection(intersect));
		//float lengthNormal = calculateLength(normal);
		//float lengthLight = calculateLength(lig);

                float cosAlpha = multiplic;
                
             
                if(cosAlpha < 0){ // calculates the new color. because of for, it sums every light source 
                	cosAlpha *=-1;
                	tmpR += Math.round(red*cosAlpha);
                	tmpG += Math.round(green*cosAlpha);
                	tmpB += Math.round(blue*cosAlpha);
                }
                
            }
            if(tmpR > 255){
                tmpR = 255;
            }
            if(tmpG > 255){
                tmpG = 255;
            }
            if(tmpB > 255){
                tmpB = 255;
            }
            
            return (new Color(tmpR,tmpG,tmpB));
            
	}

	private static float calculateLength(float[] t) {
		float result = (float) Math.sqrt(t[0]*t[0]+t[1]*t[1]+t[2]*t[2]);
		return result;
	}

	private static float multiplicateVectors(float[] n, float[] q) {
		float result = 0;
		int size = n.length;
		for (int i = 0; i < size; i++) {
			result += n[i]*q[i];
		}
		return result;
		
		
	}
	private static float[] getProjection (float a, float[] p){
		float[] tmp = new float[3];
		for (int i = 0; i < p.length; i++) {
			tmp[i]=a*p[i];
		}
		return tmp;
	}
	private static float[] calculateVector (float[] v, float[] p){
		float[] tmp = new float[3];
		for (int i = 0; i < p.length; i++) {
			tmp[i]=v[i]-p[i];
		}
		return tmp;
		
	}
	public static void ColorCalculatingReflection (float[] n, float[] v, int i, int j){ //normal vector of camera, v=vector of light
		float[] norN = normalize(n);
		float[] norV = normalize(v);
		float[] p = new float[3];
		float[] w = new float[3];
		
		float vec = multiplicateVectors(norN, norV);
		p = getProjection(vec, norN);
		p = getProjection(2, p);
		w = calculateVector(norV, p);
		
		float multiplic = multiplicateVectors(w,norV);
		float lengthV = calculateLength(norV);
		float lengthW = calculateLength(w);
		
		float cosAlpha = multiplic / (lengthV*lengthW); //calulate cos of angle between color vector and vector of reflected ray
		
		/*now we can continue with ray tracing on following vector w that becomes light vector a
		 * and old camera vector */
		
		
		
		
		
	}

	private static float[] normalize(float[] n) {
		float length = calculateLength(n);
		float[] tmp = new float[3];
		for (int i = 0; i < n.length; i++) {
			tmp[i] = n[i]/length;
		}
		return tmp;
	}
	
    @Override
    public Color getRGB(Intersection i, Light[] l) {
    	float[] intersect = i.getPointFloat();
        Body b = i.body;
        float x = b.fx(intersect);
        float y = b.fy(intersect);
        float z = b.fz(intersect);
        
        float[] normalNotNormalized = {x,y,z};
		float[] normal = normalize(normalNotNormalized);
        Color pixelColor = new Color(0,0,0);
        Color c = b.getColor();
        int red = c.getRed();
        int blue = c.getBlue();
        int green = c.getGreen();
        int tmpR=0;
        int tmpG=0;
        int tmpB=0;
        for(Light light : l){
        //float[] lig = light.getDirection(intersect);
            float multiplic = multiplicateVectors(normal,light.getDirection(intersect));
	//
	//float lengthLight = calculateLength(lig);

	float cosAlpha = multiplic;
            
         
            if(cosAlpha > 0){ // calculates the new color. because of for, it sums every light source 
               tmpR += Math.round(red*cosAlpha);
               tmpG += Math.round(green*cosAlpha);
               tmpB += Math.round(blue*cosAlpha);
            }
            
        }
        if(tmpR > 255){
            tmpR = 255;
        }
        if(tmpG > 255){
            tmpG = 255;
        }
        if(tmpB > 255){
            tmpB = 255;
        }
        
        return (new Color(tmpR,tmpG,tmpB));
        
    }
}