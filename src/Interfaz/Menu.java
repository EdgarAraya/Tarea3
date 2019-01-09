/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import tarea.pkg3.Jugador;
import tarea.pkg3.ListaJugadores;

/**
 *
 * @author Edgar-pc
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    
    private static Menu p;
    private static int dificultad;
    
    private static ListaJugadores lista;

    public static ListaJugadores getLista() {
        return lista;
    }

    public static void setLista(ListaJugadores lista) {
        Menu.lista = lista;
    }
    
    public static Menu getInstance(){
        
        if (p==null){
            p= new Menu();
        }
        return p;
    }
    
    

    public static void setDificultad(int dificultad) {
        Menu.dificultad = dificultad;
    }

    public static int getDificultad() {
        return dificultad;
    }

    public  void setjJugadores(JComboBox<String> jJugadores) {
        this.jJugadores = jJugadores;
    }
    
    public void fillJugadores()
   {
       ArrayList<String> nombres= lista.getNombres();
       System.out.println( System.getProperty("user.dir"));
       
       System.out.println(nombres.size());
       System.out.println("hey"+lista.size());
       
       for (int i=0;i< nombres.size();i++){
           
          
        if ( jJugadores.getItemAt(i) == null )//parche          
                 {
                    jJugadores.addItem(nombres.get(i));
                 }
       
       
       
       
       }
       
       
       
   }
    
    
    private void loadData(){
        
        ArrayList<Integer> tiempos;
        
        lista= new ListaJugadores();
                
        
        String path=  System.getProperty("user.dir");
        try {
        Scanner sc = new Scanner(new File(path+"\\Memorice.txt")).useDelimiter(";|\n");

        while (sc.hasNext()) {
            String nombre= "";
            tiempos= new ArrayList();
   
      
            nombre = sc.next();
      
      
          while (sc.hasNextInt()){
              tiempos.add(sc.nextInt());
              
          }
              
              
           System.out.println(nombre);
           System.out.println(tiempos.toString());
           
           Jugador nuevo= new Jugador(nombre);
           nuevo.setTiempos(tiempos);
            System.out.println(nuevo);
            System.out.println(lista.agregarJugador(nuevo));
            System.out.println("sss"+lista.size());
           
        }

        sc.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        
        
        
       
        
    }
    
    
    
    
    
    
    
     
    
    
    
    
    public Menu() {
        loadData();
       // Jugador unnamed=new Jugador("Sin Nombre");
        
       // lista = new ListaJugadores();
       // System.out.println(lista.agregarJugador(unnamed));
        
        initComponents();
        
        fillJugadores();
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jDificultad1 = new javax.swing.JRadioButton();
        jDificultad2 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jTemas = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jJugadores = new javax.swing.JComboBox<>();
        jCrear = new javax.swing.JButton();
        jJugar = new javax.swing.JButton();
        test = new javax.swing.JComboBox<>();
        bla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego Memoria");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nivel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        buttonGroup1.add(jDificultad1);
        jDificultad1.setText("Básico");

        buttonGroup1.add(jDificultad2);
        jDificultad2.setText("Medio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDificultad1)
                .addGap(18, 18, 18)
                .addComponent(jDificultad2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDificultad1)
                    .addComponent(jDificultad2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jTemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disney", "Animales", "Los Simpsons"}));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jJugadores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        jCrear.setText("Crear Nuevo Jugador");
        jCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCrear)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jJugar.setText("Jugar");
        jJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJugarActionPerformed(evt);
            }
        });

        test.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bla.setText("bla");
        bla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jJugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bla)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jJugar)
                    .addComponent(bla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(test, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jJugarActionPerformed
        // TODO add your handling code here:
        
        if (jDificultad1.isSelected()) dificultad=1;
        else{
            dificultad=2;
        }
        
        
        
        
        
    }//GEN-LAST:event_jJugarActionPerformed

    private void jCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCrearActionPerformed
        // TODO add your handling code here:
        
        NuevoJugador.getInstance().setVisible(true);
        
        
        
    }//GEN-LAST:event_jCrearActionPerformed

    private void blaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blaActionPerformed
        // TODO add your handling code here:
        
        fillJugadores();
        
        
        
    }//GEN-LAST:event_blaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bla;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jCrear;
    private javax.swing.JRadioButton jDificultad1;
    private javax.swing.JRadioButton jDificultad2;
    private javax.swing.JComboBox<String> jJugadores;
    private javax.swing.JButton jJugar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> jTemas;
    private javax.swing.JComboBox<String> test;
    // End of variables declaration//GEN-END:variables
}
