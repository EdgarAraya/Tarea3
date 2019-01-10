/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Button;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import tarea.pkg3.Jugador;

/**
 *
 * @author Luis
 */

//test
public class Juego extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    private static Juego p;
    private static int filas=6;
    private static int columnas = 4;
    
    private static boolean basico;

    public  boolean isBasico() {
        return basico;
    }

    public static void setBasico(boolean basico) {
        Juego.basico = basico;
    }

    public static int getFilas() {
        return filas;
    }

    public static void setFilas() {
        if(basico){
            Juego.filas=4;
        }else{
            Juego.filas=6;
        }
    }

    private String image;
    
 
    
    public static Juego getInstance(){
        if(p==null){
            p= new Juego();
        }
        return p;
    }
    
    public Juego() {
        
        image=Menu.getImagen();
        
        System.out.println(image);
        
        
        setFilas();
        
       
        
        
        
        System.out.println(filas);
        initComponents();
        
        System.out.println(filas);
        
        System.out.println("antes de botones");
        Botones();
        
        System.out.println("despues de botones");
        setCards();
 
    }
    
    Boton [] [] botones = new Boton [filas][columnas];
     long inicioms = System.currentTimeMillis();
     
    public void Botones(){
       // System.out.println("afuwea de i");
        for(int i=0; i<filas; i++){
            
          //  System.out.println("adentro de i");
            for(int j=0; j<columnas; j++){
                botones [i][j] = new Boton(130*j,130*i,100,120);
                jPanel1.add(botones[i][j]);
                    System.out.println(i+","+j);
                
                    MouseListener uno = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        //
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                       //
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    compare();
                               
                    }
                };
                    botones[i][j].addMouseListener(uno);
                    
               //     System.out.println("fin");
                    
            }
            
            
            
        }
    }
    
    CodigoJuego uno = new CodigoJuego();
    private boolean caraUp = false;
    private ImageIcon im1;
    private ImageIcon im2;
    private JButton[] pbtn = new JButton[2];
    private boolean primerc = false;
    
    
    public void enabled(JButton btn){
         if(!caraUp) {
            btn.setEnabled(false);
            im1 = (ImageIcon) btn.getDisabledIcon();
            pbtn[0] = btn;
            caraUp = true;
            primerc = false;
        }
        else {
            btn.setEnabled(false);
            im2 = (ImageIcon) btn.getDisabledIcon();
            pbtn[1] = btn;
            primerc = true;
            ganador();
        }
    }
    
     private void compare() {
        if(caraUp && primerc) {
            
            if(im1.getDescription().compareTo(im2.getDescription()) != 0) {
                pbtn[0].setEnabled(true);
                pbtn[1].setEnabled(true);
               
            }
            caraUp = false;
        }
    }
    
     
     private void setCards() {
        int[] numbers = uno.getCardNumbers(filas,columnas);
        int count=0;
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
               // botones [i][j].setDisabledIcon(new ImageIcon(getClass().getResource("../"+image+"/"+numbers[count]+".jpg")));
                botones [i][j].setDisabledIcon(new ImageIcon(getClass().getResource("../"+image+"/"+numbers[count]+".jpg")));
                count++;
            }
        }
        
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                int y=i;
                int aux=j;
                botones[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      enabled(botones[y][aux]);
                    }
                });
            }
        }
        
      for(int i = 0; i<filas ; i++){
            for(int j=0; j<columnas; j++){
                botones[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        //
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        //
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                       //
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                       compare();
                    }
                });
            }
        }
     } 
     
    
    
       private void ganador() {
           int count = 0;
           for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
               if(!botones[i][j].isEnabled()){
                    count++;
                }
            }
        }
        if(count==filas*columnas) {
            
            long duracion = (System.currentTimeMillis()- inicioms)/1000;
            JOptionPane.showMessageDialog(this, "Felicidades " + duracion + " segundos");
            Jugador j= Menu.getInstance().getJugador();
            Menu.getInstance().getLista().agregarTiempo(j.getNombre(),(int) duracion);
            
        }
        }
     
     
     
     
     
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTest = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setLocation(new java.awt.Point(500, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 756, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );

        jTest.setText("Probar dificultad");
        jTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTestActionPerformed(evt);
            }
        });

        jMenu1.setText("Juegos");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTest)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTest)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTestActionPerformed
        // TODO add your handling code here:
        
        System.out.println(basico);
        
        
       if (Menu.isDificultad()){
           System.out.println("basico");
       }
       else{
           System.out.println("medio");
       }
        
        
        
    }//GEN-LAST:event_jTestActionPerformed

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jTest;
    // End of variables declaration//GEN-END:variables
}
