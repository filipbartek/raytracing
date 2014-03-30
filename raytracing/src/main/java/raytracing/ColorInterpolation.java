package RayTracing;


public class ColorInterpolation {
	
	
	/*method calculates */
	public static void ColorCalculatingNoReflection(float[] n, float[] q, int i, int j){
		int [] RGB = {0,0,0};
		
		float multiplic = multiplicateVectors(n,q);
		float lengthQ = calculateLength(q);
		float lengthN = calculateLength(n);
		
		float cosAlpha = multiplic / (lengthN*lengthQ);
		
		/*calculate color with this new cosAlpha as a vector*/
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
}