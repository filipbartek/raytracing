package rayTracing;



public class ColorInterpolation {
	
	
	/*method calculates */
	public static void ColorCalculatingNoReflection(double[] n, double[] q, int i, int j){
		int [] RGB = {0,0,0};
		
		double multiplic = multiplicateVectors(n,q);
		double lengthQ = calculateLength(q);
		double lengthN = calculateLength(n);
		
		double cosAlpha = multiplic / (lengthN*lengthQ);
		
		/*calculate color with this new cosAlpha as a vector*/
	}

	private static double calculateLength(double[] t) {
		double result = Math.sqrt(t[0]*t[0]+t[1]*t[1]+t[2]*t[2]);
		return result;
	}

	private static double multiplicateVectors(double[] n, double[] q) {
		double result = 0;
		int size = n.length;
		for (int i = 0; i < size; i++) {
			result += n[i]*q[i];
		}
		return result;
		
		
	}
	private static double[] getProjection (double a, double[] p){
		double[] tmp = new double[3];
		for (int i = 0; i < p.length; i++) {
			tmp[i]=a*p[i];
		}
		return tmp;
	}
	private static double[] calculateVector (double[] v, double[] p){
		double[] tmp = new double[3];
		for (int i = 0; i < p.length; i++) {
			tmp[i]=v[i]-p[i];
		}
		return tmp;
		
	}
	public static void ColorCalculatingReflection (double[] n, double[] v, int i, int j){ //normal vector of camera, v=vector of light
		double[] norN = normalize(n);
		double[] norV = normalize(v);
		double[] p = new double[3];
		double[] w = new double[3];
		
		double vec = multiplicateVectors(norN, norV);
		p = getProjection(vec, norN);
		p = getProjection(2, p);
		w = calculateVector(norV, p);
		
		double multiplic = multiplicateVectors(w,norV);
		double lengthV = calculateLength(norV);
		double lengthW = calculateLength(w);
		
		double cosAlpha = multiplic / (lengthV*lengthW); //calulate cos of angle between color vector and vector of reflected ray
		
		/*now we can continue with ray tracing on following vector w that becomes light vector a
		 * and old camera vector */
		
		
		
		
		
	}

	private static double[] normalize(double[] n) {
		double length = calculateLength(n);
		double[] tmp = new double[3];
		for (int i = 0; i < n.length; i++) {
			tmp[i] = n[i]/length;
		}
		return tmp;
	}
}