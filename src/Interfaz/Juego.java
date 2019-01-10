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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static int columnas=4;
    
    
    
    
    
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
            filas=4;
        }else{
            filas=6;
        }
    }

    private static String image;
    
 
    
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
        
       //this.setTitle("Juego de"+Menu.getInstance().getJugador().getNombre());
        //botones= new Boton [filas][columnas];
        
        
        
        initComponents();
        
        System.out.println(filas);
        
        
        Botones();
        
       ;
        setCards();
 
    }
    
    Boton [] [] botones = new Boton [filas][columnas];
     long inicioms = System.currentTimeMillis();
     
    public void Botones(){
       
        for(int i=0; i<filas; i++){
            
          //  System.out.println("adentro de i");
            for(int j=0; j<columnas; j++){
                botones [i][j] = new Boton(130*j,130*i,100,120);
                jPanel1.add(botones[i][j]);
                    //System.out.println(i+","+j);
                
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
    
    private ArrayList<Integer>tiempos = new ArrayList();
    
    
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
    
     private void setCards1(){
         int[] numbers = uno.getCardNumbers(filas,columnas);
        int count=0;
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
               // botones [i][j].setDisabledIcon(new ImageIcon(getClass().getResource("../"+image+"/"+numbers[count]+".jpg")));
                botones [i][j].setDisabledIcon(new ImageIcon(getClass().getResource("../"+image+"/"+numbers[count]+".jpg")));
                count++;
            }
        }
        inicioms = System.currentTimeMillis();
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
     
    
     public void reiniciar(){
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
               botones[i][j].setEnabled(true);
            }
            primerc=false;
            caraUp=false;  
            setCards1();
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
          //  Jugador j= Menu.getInstance().getJugador();
            tiempos.add((int)duracion);
            
            
            //fix shit
            System.out.println("nombre jugador ganador: "+Menu.jugador.getNombre());
            
           // Menu.getInstance().getLista().agregarTiempo(Menu.jugador.getNombre(),(int) duracion);
            
            
            Menu.jugador.agregarTiempo(tiempos);
            
            
            
            
        }
        }
     
     
     
     
     
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTest = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jStart = new javax.swing.JMenuItem();
        jGuardar = new javax.swing.JMenuItem();
        jVerTiempos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setLocation(new java.awt.Point(500, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );

        jTest.setText("Reinicio");
        jTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTestActionPerformed(evt);
            }
        });

        jButton1.setText("Jugador actual");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Juegos");

        jStart.setText("Jugar");
        jMenu1.add(jStart);

        jGuardar.setText("Guardar juegos");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(jGuardar);

        jVerTiempos.setText("Ver tiempos");
        jVerTiempos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVerTiemposActionPerformed(evt);
            }
        });
        jMenu1.add(jVerTiempos);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTest)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        image=Menu.getImagen();
        
        System.out.println(image);
       reiniciar();
        
       
       
       
       
        
    }//GEN-LAST:event_jTestActionPerformed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        // TODO add your handling code here:
        
        
        
        try {
            Menu.getInstance().getLista().saveData();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jVerTiemposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerTiemposActionPerformed
        // TODO add your handling code here:
        
        System.out.println(Menu.jugador);
        
        JOptionPane.showMessageDialog(this, "Jugador: "+Menu.jugador.getNombre()+
                                            "\nTiempo Promedio: "+Menu.jugador.tiempoPromedio()+
                                            "\nMejor Tiempo: "+Menu.jugador.mejorTiempo()
        
        
        
        
        
        );
        
        
        
        
        
        
    }//GEN-LAST:event_jVerTiemposActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        System.out.println(Menu.jugador.getNombre());
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jGuardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jStart;
    private javax.swing.JButton jTest;
    private javax.swing.JMenuItem jVerTiempos;
    // End of variables declaration//GEN-END:variables
}
