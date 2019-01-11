/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Button;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
public class Juego extends javax.swing.JDialog {

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
        
        System.out.println("setfilas-");
        System.out.println("basico: "+basico);
        
        basico=Menu.isDificultad();
        
        
        
        if(basico){
            System.out.println("estoy en basico");
            Juego.filas=4;
        }else{
            Juego.filas=6;
        }
    }

    private static String image;
    
 
    
    public static Juego getInstance(){
        if(p==null){
            p= new Juego();
        }
        return p;
    }
    
    public  void build(){
        
        
        botones= new Boton [filas][columnas];
        Botones();
        
       
        setCards();
        
    }
 
    
    
    
    public Juego() {
        this.setModal(true);
        image=Menu.getImagen();
        
        System.out.println(image);
        
        System.out.println("antes filas:"+filas);
        
        System.out.println("CONSTRUCTOr");
        
        //setFilas();
        System.out.println("despues filas:"+filas);
        botones= new Boton [filas][columnas];
        
        acciones();
       //this.setTitle("Juego de"+Menu.getInstance().getJugador().getNombre());
        //botones= new Boton [filas][columnas];
        
        
        
        initComponents();
        
        System.out.println(filas);
        
        jPanel1.setLayout(new GridLayout(filas,columnas));
        Botones();
        
       
        setCards();
 
    }
    
    private static Boton [] [] botones ;
     long inicioms = System.currentTimeMillis();
     
    public  void Botones(){
       
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
    
    public void acciones(){
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                //
            }

            @Override
            public void windowClosing(WindowEvent e) {
             
                Object [] aux ={"Aceptar","Cancelar"};
                int opcion = JOptionPane.showOptionDialog(rootPane,"Sus últimos "+tiempos.size()+" juegos no se guardarán.\n¿Está seguro(a) que desea salir?","Cierre de Sesión",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,aux,"Aceptar");
                if(opcion==JOptionPane.YES_OPTION){
                    dispose();
                       p=null;
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                p=null;
            }

            @Override
            public void windowIconified(WindowEvent e) {
                //
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                //
            }

            @Override
            public void windowActivated(WindowEvent e) {
                //
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                //
            }
        });
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
     
     public  void setCards() {
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
            
            
           // Menu.jugador.agregarTiempo(tiempos);
            
            Menu.getLista2().agregarTiempo(Menu.jugador.getNombre(), (int) duracion);
            
            System.out.println(Menu.getLista2().buscarJugador(Menu.jugador.getNombre()).toString());
            
        }
        }
     
     
     
     
     
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jStart = new javax.swing.JMenuItem();
        jGuardar = new javax.swing.JMenuItem();
        jVerTiempos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setLocation(new java.awt.Point(500, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 817, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Jugador");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jMenu1.setText("Juegos");

        jStart.setText("Jugar");
        jStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStartActionPerformed(evt);
            }
        });
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addContainerGap(639, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        // TODO add your handling code here:
        
        
        
        try {
            Menu.getLista2().saveData();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        tiempos.clear();
        
        
        
        
        
        
        
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jVerTiemposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVerTiemposActionPerformed
        // TODO add your handling code here:
        
        System.out.println(Menu.jugador);
        
        JOptionPane.showMessageDialog(this, "Jugador: "+Menu.jugador.getNombre()+
                                            "\nTiempo Promedio: "+Menu.jugador.tiempoPromedio()+
                                            "\nMejor Tiempo: "+Menu.jugador.mejorTiempo()
        
        
        
        
        
        );
        
        
        
        
        
        
    }//GEN-LAST:event_jVerTiemposActionPerformed

    private void jStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStartActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jStartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            System.out.println(Menu.jugador.getNombre());
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    
    
    
    
    
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
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuItem jGuardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jStart;
    private javax.swing.JMenuItem jVerTiempos;
    // End of variables declaration//GEN-END:variables
}
