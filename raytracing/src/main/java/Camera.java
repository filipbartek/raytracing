
import raytracing.Ray;
import raytracing.Tuple3f;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jus
 */
public class Camera {
    float loc[];  //location of the origin of the camera
    float dir[];  //the direction the camera is pointing
    
    public Camera(float loc[],float dir[]){
        this.loc=loc;
        this.dir=normalize(dir);
    }
    
    float[] getLocation(){
        return loc;
    }
    
    Ray[] getCameraRays(int resX,int resY){
        Ray[] rays=new Ray[resX*resY];
        float vectors[][]=new float[resX*resY][3];//first vector index, second the components of the vector
        float[] vect2=rotateYVector(dir);
        vect2[1]=0;
        vect2=normalize(vect2);
        float[] vect3=normalize(vectorProduct(dir, vect2));//dir, vect2, vect3 base vectors
        float[] x={0,0,0};
        float[] y={0,0,0};
        float[] temp={0,0,0};
        for(int i=0;i<3;i++){
            x[i]=(vect2[i])/(resX/2);
            y[i]=(vect3[i])/(resY/2);
            temp[i]=vect2[i];
        }
        
        for(int j=0;j<resY;j++){
            for(int i=0;i<resX;i++){
                vectors[j*resX+i][0]=dir[0]+vect2[0]+vect3[0];
                vectors[j*resX+i][1]=dir[1]+vect2[1]+vect3[1];
                vectors[j*resX+i][2]=dir[2]+vect2[2]+vect3[2];
                vectors[j*resX+i]=normalize(vectors[j*resX+i]);
                rays[j*resX+i]=new Ray(new Tuple3f(loc),new Tuple3f(vectors[j*resX+i]));
                vect2[0]-=x[0];
                vect2[1]-=x[1];
                vect2[2]-=x[2];
                if((vectorLength(vect2)>(-0.0001)&&vectorLength(vect2)<0.0001)&&(resX%2)==0){
                    vect2[0]-=x[0];
                    vect2[1]-=x[1];
                    vect2[2]-=x[2];
                }
            }
            //printVector(temp);
            vect2[0]=temp[0];
            vect2[1]=temp[1];
            vect2[2]=temp[2];
            vect3[0]-=y[0];
            vect3[1]-=y[1];
            vect3[2]-=y[2];
            if((vectorLength(vect3)>(-0.0001)&&vectorLength(vect3)<0.0001)&&(resY%2)==0){
                vect3[0]-=y[0];
                vect3[1]-=y[1];
                vect3[2]-=y[2];
            }
        }
        
        return rays;
    }
    
    float[][] getCameraVectors(int resX, int resY){ //returns resX*resY camera vectors
        float vectors[][]=new float[resX*resY][3];//first vector index, second the components of the vector
        float[] vect2=rotateYVector(dir);
        vect2[1]=0;
        vect2=normalize(vect2);
        float[] vect3=normalize(vectorProduct(dir, vect2));//dir, vect2, vect3 base vectors
        float[] x={0,0,0};
        float[] y={0,0,0};
        float[] temp={0,0,0};
        for(int i=0;i<3;i++){
            x[i]=(vect2[i])/(resX/2);
            y[i]=(vect3[i])/(resY/2);
            temp[i]=vect2[i];
        }
        
        for(int j=0;j<resY;j++){
            for(int i=0;i<resX;i++){
                vectors[j*resX+i][0]=dir[0]+vect2[0]+vect3[0];
                vectors[j*resX+i][1]=dir[1]+vect2[1]+vect3[1];
                vectors[j*resX+i][2]=dir[2]+vect2[2]+vect3[2];
                vect2[0]-=x[0];
                vect2[1]-=x[1];
                vect2[2]-=x[2];
                if((vectorLength(vect2)>(-0.0001)&&vectorLength(vect2)<0.0001)&&(resX%2)==0){
                    vect2[0]-=x[0];
                    vect2[1]-=x[1];
                    vect2[2]-=x[2];
                }
            }
            //printVector(temp);
            vect2[0]=temp[0];
            vect2[1]=temp[1];
            vect2[2]=temp[2];
            vect3[0]-=y[0];
            vect3[1]-=y[1];
            vect3[2]-=y[2];
            if((vectorLength(vect3)>(-0.0001)&&vectorLength(vect3)<0.0001)&&(resY%2)==0){
                vect3[0]-=y[0];
                vect3[1]-=y[1];
                vect3[2]-=y[2];
            }
        }
        
        return vectors;
    }
    
    float[][] getCameraVectorsNormal(int resX, int resY){ //returns resX*resY nprmalized camera vectors
        float vectors[][]=new float[resX*resY][3];//first vector index, second the components of the vector
        float[] vect2=rotateYVector(dir);
        vect2[1]=0;
        vect2=normalize(vect2);
        float[] vect3=normalize(vectorProduct(dir, vect2));//dir, vect2, vect3 base vectors
        float[] x={0,0,0};
        float[] y={0,0,0};
        float[] temp={0,0,0};
        for(int i=0;i<3;i++){
            x[i]=(vect2[i])/(resX/2);
            y[i]=(vect3[i])/(resY/2);
            temp[i]=vect2[i];
        }
        
        for(int j=0;j<resY;j++){
            for(int i=0;i<resX;i++){
                vectors[j*resX+i][0]=dir[0]+vect2[0]+vect3[0];
                vectors[j*resX+i][1]=dir[1]+vect2[1]+vect3[1];
                vectors[j*resX+i][2]=dir[2]+vect2[2]+vect3[2];
                vectors[j*resX+i]=normalize(vectors[j*resX+i]);
                vect2[0]-=x[0];
                vect2[1]-=x[1];
                vect2[2]-=x[2];
                if((vectorLength(vect2)>(-0.0001)&&vectorLength(vect2)<0.0001)&&(resX%2)==0){
                    vect2[0]-=x[0];
                    vect2[1]-=x[1];
                    vect2[2]-=x[2];
                }
            }
            //printVector(temp);
            vect2[0]=temp[0];
            vect2[1]=temp[1];
            vect2[2]=temp[2];
            vect3[0]-=y[0];
            vect3[1]-=y[1];
            vect3[2]-=y[2];
            if((vectorLength(vect3)>(-0.0001)&&vectorLength(vect3)<0.0001)&&(resY%2)==0){
                vect3[0]-=y[0];
                vect3[1]-=y[1];
                vect3[2]-=y[2];
            }
        }
        
        return vectors;
    }
    
    static float[] normalize(float vect[]){
        float leng=(float)Math.sqrt((vect[0]*vect[0])+(vect[1]*vect[1])+(vect[2]*vect[2]));
        for(int i=0;i<3;i++){
            vect[i]/=leng;
        }
        return vect;
    }
    
    static float vectorLength(float[] vect){
        return (float)Math.sqrt((vect[0]*vect[0])+(vect[1]*vect[1])+(vect[2]*vect[2]));
    }
    
    static float[] vectorProduct(float[] u,float[] v){//also cross-product
        float[] out=new float[3];
        
        out[0]=u[1]*v[2]-u[2]*v[1];
        out[1]=u[2]*v[0]-u[0]*v[2];
        out[2]=u[0]*v[1]-u[1]*v[0];
        
        return out;
    }
    
    static float[] rotateYVector(float[] vect){ //rotate the vector 90 deg on y
        //float[][] R={{0,0,1},{0,1,0},{-1,0,0}};
        float[] vect2={0,0,0};
        vect2[0]=vect[2];
        vect2[1]=vect[1];
        vect2[2]=vect[0]*(-1);
        return vect2;
    }
    
    static void printVector(float[] vect){
        for(int i=0;i<3;i++){
            System.out.print(vect[i]+", ");
        }
        System.out.println();
    }
    
    public static void main(String []args){//test
        /*float vect1[]={1,1,1};
        vect1=normalize(vect1);
        
        float[] vect2=rotateYVector(vect1);
        vect2[1]=0;
        vect2=normalize(vect2);
        float[] vect3=normalize(vectorProduct(vect1, vect2));
        for(int i=0;i<3;i++){
            vect3[i]*=0.1;
        }
        printVector(vect1);
        System.out.println(vectorLength(vect1));
        printVector(vect2);
        System.out.println(vectorLength(vect2));
        printVector(vect3);
        System.out.println(vectorLength(vect3));*/
        
        Camera camera=new Camera(new float[]{0,0,0},new float[]{1,0,0});
        int resX=2000;
        int resY=2000;
        Ray[] rays=camera.getCameraRays(resX, resY);
        
        /*for(int i=0;i<resX*resY;i++){
            printVector(rays[i].dir.getFloat());
        }*/
    }
}