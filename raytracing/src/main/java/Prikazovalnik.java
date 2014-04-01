
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import raytracing.Ray;
import raytracing.Scene;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jus
 */
public class Prikazovalnik extends JPanel{
    BufferedImage izvirnaSlika=null;
    BufferedImage slikaEffekt=null;
    BufferedImage slika=null;
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(slika!=null){
            setPreferredSize(new Dimension(slika.getWidth(), slika.getHeight()));
            revalidate();
            g.drawImage(slika, 0, 0, null);
        }
    }
    
    
    public void odpriDatoteko(File f){
        //System.out.println("odpiram datoteko");
        try {
            BufferedImage slikatemp=ImageIO.read(f);
            izvirnaSlika= new BufferedImage(slikatemp.getWidth(),slikatemp.getHeight(),BufferedImage.TYPE_INT_RGB);
            slika= new BufferedImage(slikatemp.getWidth(),slikatemp.getHeight(),BufferedImage.TYPE_INT_RGB);
            slikaEffekt= new BufferedImage(slikatemp.getWidth(),slikatemp.getHeight(),BufferedImage.TYPE_INT_RGB);
            for(int i=0;i<slika.getWidth();i++){
                for(int j=0;j<slika.getHeight();j++){
                    slika.setRGB(i, j,slikatemp.getRGB(i, j));
                    izvirnaSlika.setRGB(i, j,slikatemp.getRGB(i, j));
                    slikaEffekt.setRGB(i, j,slikatemp.getRGB(i, j));
                }
            }
            repaint();
        } catch (Exception e) {
            System.out.println("nepravilen format");
        }
    }
    
    public void render(Camera cam, Scene s, int resX, int resY){
        try {
            Ray []r=cam.getCameraRays(resX, resY);
            izvirnaSlika= new BufferedImage(resX, resY,BufferedImage.TYPE_INT_RGB);
            slika= new BufferedImage(resX, resY,BufferedImage.TYPE_INT_RGB);
            slikaEffekt= new BufferedImage(resX, resY,BufferedImage.TYPE_INT_RGB);
            for(int i=0;i<slika.getWidth();i++){
                for(int j=0;j<slika.getHeight();j++){
                    slika.setRGB(i, j, s.getRGB(r[resX*j+(resX-(i+1))]).getRGB());
                    izvirnaSlika.setRGB(i, j, s.getRGB(r[resX*j+(resX-(i+1))]).getRGB());
                    slikaEffekt.setRGB(i, j, s.getRGB(r[resX*j+(resX-(i+1))]).getRGB());
                }
            }
            repaint();
        } catch (Exception e) {
            System.out.println("nepravilen format");
        }
    }
    
    public void setSlika(BufferedImage i){
        slika=i;
        repaint();
    }
    
    public BufferedImage getSlika(){
        return slika;
    }
    public void original(){
        slika=izvirnaSlika;
        slikaEffekt=izvirnaSlika;
        repaint();
    }
    
    public void kanali(String barva){
        //System.out.println(barva);
        BufferedImage novaSlika=new BufferedImage(slika.getWidth(), slika.getHeight(), BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<slika.getWidth();i++){
            for(int j=0;j<slika.getHeight();j++){
                int rgb=slikaEffekt.getRGB(i, j);
                int red=(rgb>>16)& 0xFF;
                int green=(rgb>>8)& 0xFF;
                int blue=rgb& 0xFF;
                int noviRGB=0;
                if(barva.equals("Red")){
                    noviRGB=(new Color(red,0,0)).getRGB();
                }else if(barva.equals("Green")){
                    noviRGB=(new Color(0,green,0)).getRGB();
                }else if(barva.equals("Blue")){
                    noviRGB=(new Color(0,0,blue)).getRGB();
                }
                novaSlika.setRGB(i, j, noviRGB);
            }
        }
        slika=novaSlika;
        repaint();
    }
    
    public void narediTransformacijo(float effect[]){
        int dim=(int)Math.sqrt(effect.length);        
        BufferedImageOp operacija=new ConvolveOp(new Kernel(dim,dim,effect));
        slika=operacija.filter(slika, null);
        slikaEffekt=operacija.filter(slikaEffekt, null);
        repaint();
    }
    
    
}
