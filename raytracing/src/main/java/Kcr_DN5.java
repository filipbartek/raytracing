
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import raytracing.Body;
import raytracing.ColorInterpolation;
import raytracing.Light;
import raytracing.LightingModel;
import raytracing.NewtonRayCaster;
import raytracing.PointLight;
import raytracing.RayCaster;
import raytracing.ScaledBody;
import raytracing.Scene;
import raytracing.SphereBody;
import raytracing.TorusBody;
import raytracing.TranslatedBody;
import raytracing.Tuple3f;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Kcr_DN5.java
 *
 * Created on 23.5.2013, 20:52:13
 */
/**
 *
 * @author Jus
 */
public class Kcr_DN5 extends javax.swing.JFrame {

    /** Creates new form Kcr_DN5 */
    public Kcr_DN5() {
        initComponents();
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("jpg image", "jpg"));
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("png image", "png"));
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("gif image", "gif"));
        jfc.addChoosableFileFilter(new FileNameExtensionFilter("bmp image", "bmp"));
    }
    float[][]effect={{0.001f,0.004f,0.008f,0.010f,0.008f,0.004f,0.001f,0.004f,0.012f,0.024f,0.030f,0.024f,0.012f,0.004f,0.008f,0.024f,0.047f,0.059f,0.047f,0.024f,0.008f,0.010f,0.030f,0.059f,0.073f,0.059f,0.030f,0.010f,0.008f,0.024f,0.047f,0.059f,0.047f,0.024f,0.008f,0.004f,0.012f,0.024f,0.030f,0.024f,0.012f,0.004f,0.001f,0.004f,0.008f,0.010f,0.008f,0.004f,0.001f},{0,-1,0,-1,5,-1,0,-1,0},{0,0,0,-1,-1,-1,0,0,0,0,-2,-3,-3,-3,-3,-3,-2,-0,0,-3,-2,-1,-1,-1,-2,-3,0,-1,-3,-1,9,9,9,-1,-3,-1,-1,-3,-1,9,19,9,-1,-3,-1,-1,-3,-1,9,9,9,-1,-3,-1,0,-3,-2,-1,-1,-1,-2,-3,0,0,-2,-3,-3,-3,-3,-3,-2,-0,0,0,0,-1,-1,-1,0,0,0}};//blur,sharpen,edges
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfc = new javax.swing.JFileChooser();
        message = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        izvirna = new Prikazovalnik();
        jScrollPane2 = new javax.swing.JScrollPane();
        spremenjena = new Prikazovalnik();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        quit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        blur = new javax.swing.JMenuItem();
        sharpen = new javax.swing.JMenuItem();
        edges = new javax.swing.JMenuItem();
        original = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        red = new javax.swing.JMenuItem();
        green = new javax.swing.JMenuItem();
        blue = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RayTracer");
        setMinimumSize(new java.awt.Dimension(800, 600));

        message.setText("Message:");
        getContentPane().add(message, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setViewportView(izvirna);

        jTabbedPane1.addTab("Izvirna", jScrollPane1);

        jScrollPane2.setViewportView(spremenjena);

        jTabbedPane1.addTab("Spremenjena", jScrollPane2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setMnemonic('f');
        jMenu1.setText("File");

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        open.setMnemonic('o');
        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odpri(evt);
            }
        });
        jMenu1.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setMnemonic('s');
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save(evt);
            }
        });
        jMenu1.add(save);

        quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quit.setMnemonic('q');
        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quit(evt);
            }
        });
        jMenu1.add(quit);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('e');
        jMenu2.setText("Edit");

        blur.setMnemonic('b');
        blur.setText("Blur");
        blur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effekt(evt);
            }
        });
        jMenu2.add(blur);

        sharpen.setMnemonic('s');
        sharpen.setText("Sharpen");
        sharpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effekt(evt);
            }
        });
        jMenu2.add(sharpen);

        edges.setMnemonic('e');
        edges.setText("Edges");
        edges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effekt(evt);
            }
        });
        jMenu2.add(edges);

        original.setMnemonic('o');
        original.setText("Original");
        original.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                original(evt);
            }
        });
        jMenu2.add(original);

        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('c');
        jMenu3.setText("Channels");

        red.setMnemonic('r');
        red.setText("Red");
        red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kanal(evt);
            }
        });
        jMenu3.add(red);

        green.setMnemonic('g');
        green.setText("Green");
        green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kanal(evt);
            }
        });
        jMenu3.add(green);

        blue.setMnemonic('b');
        blue.setText("Blue");
        blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kanal(evt);
            }
        });
        jMenu3.add(blue);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Render");

        jMenuItem1.setText("Scene");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                render(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);
        jMenu4.getAccessibleContext().setAccessibleName("render");

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void quit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quit
    System.exit(0);
}//GEN-LAST:event_quit

private void kanal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kanal
    JMenuItem tip=(JMenuItem)evt.getSource();
    spremenjena.kanali(tip.getText());
    if(message.getText().contains("Red")){
        message.setText(message.getText().replaceAll("Red", tip.getText()));
    }else if(message.getText().contains("Green")){
        message.setText(message.getText().replaceAll("Green", tip.getText()));
    }else if(message.getText().contains("Blue")){
        message.setText(message.getText().replaceAll("Blue", tip.getText()));
    }else{
        message.setText(message.getText()+" "+tip.getText());
    }
}//GEN-LAST:event_kanal

private void odpri(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odpri
    if(jfc.showOpenDialog(this)== JFileChooser.APPROVE_OPTION){
        izvirna.odpriDatoteko(jfc.getSelectedFile());
        message.setText("Message: "+jfc.getSelectedFile().getName());
        spremenjena.odpriDatoteko(jfc.getSelectedFile());
        
    }
}//GEN-LAST:event_odpri

private void original(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_original
    spremenjena.original();
    if(message.getText().contains("Red")){
        message.setText(message.getText().replaceAll("Red", ""));
    }else if(message.getText().contains("Green")){
        message.setText(message.getText().replaceAll("Green", ""));
    }else if(message.getText().contains("Blue")){
        message.setText(message.getText().replaceAll("Blue", ""));
    }
}//GEN-LAST:event_original

private void effekt(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effekt
    if(evt.getSource()==blur){
        spremenjena.narediTransformacijo(effect[0]);
        if(!message.getText().contains("Blur")){
            message.setText(message.getText()+" Blur");
        }
    }else if(evt.getSource()==sharpen){
        spremenjena.narediTransformacijo(effect[1]);
        if(!message.getText().contains("Sharpen")){
            message.setText(message.getText()+" Sharpen");
        }
    }else if(evt.getSource()==edges){
        spremenjena.narediTransformacijo(effect[2]);
        if(!message.getText().contains("Edges")){
            message.setText(message.getText()+" Edges");
        }
    }
}//GEN-LAST:event_effekt

private void save(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save
    if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File selectedFile = jfc.getSelectedFile();
        try {
            ImageIO.write(izvirna.getSlika(), selectedFile.getName().substring(selectedFile.getName().length()-3), selectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}//GEN-LAST:event_save

    public static Scene buildScene() throws Exception {
        Color colorLeft = Color.RED;
        Color colorRight = Color.YELLOW;
        Body body0 = new TranslatedBody(new SphereBody(colorRight, 0.75f), new Tuple3f(-1, 0, 0));
        Body body1 = new TranslatedBody(new SphereBody(colorRight, 0.75f), new Tuple3f(1, 0, 0));
        Body body2 = new TranslatedBody(new ScaledBody(new SphereBody(colorLeft, 1.0f), new Tuple3f(1, 2, 1)), new Tuple3f(0, 1, 0));
        //Body bodyTorus = new TranslatedBody(new TorusBody(Color.PINK, 1, 2f), new Tuple3f(0, 0, 0));
        Light light0 = new PointLight(new Tuple3f(0, 5, 0), Color.WHITE);
        Light light1 = new PointLight(new Tuple3f(0, 5, 5), Color.WHITE);
        float step = 1.0f / 32;
        float limit = 32;
        int approxSteps = 16;
        LightingModel lighting = new ColorInterpolation();
        Color bgColor = Color.DARK_GRAY;
        
        Body[] bodies = {body0, body1, body2};
        //Body[] bodies = {bodyTorus};
        Light[] lights = {light0, light1};
        RayCaster rayCaster = new NewtonRayCaster(step, limit, approxSteps);
        return new Scene(bodies, lights, rayCaster, lighting, bgColor);
    }

    private void render(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_render
        //float[] loc={0,-0.6f,4};
        //float[] dir={0,0.25f,-1};
        float[] loc={3,3,3};
        float[] dir={-1,-1,-1};
        
        Camera cam=new Camera(loc,dir);
        try {
            message.setText("Message: Rendering");
            izvirna.render(cam, buildScene(), 512, 512);
            message.setText("Message: Render complete");
        } catch (Exception e) {
            message.setText("Message: Render error");
        }
    }//GEN-LAST:event_render

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kcr_DN5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kcr_DN5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kcr_DN5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kcr_DN5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Kcr_DN5().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem blue;
    private javax.swing.JMenuItem blur;
    private javax.swing.JMenuItem edges;
    private javax.swing.JMenuItem green;
    private Prikazovalnik izvirna;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JFileChooser jfc;
    private javax.swing.JLabel message;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem original;
    private javax.swing.JMenuItem quit;
    private javax.swing.JMenuItem red;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem sharpen;
    private Prikazovalnik spremenjena;
    // End of variables declaration//GEN-END:variables
}
