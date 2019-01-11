/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import tarea.pkg3.Jugador;
import tarea.pkg3.ListaJugadores;
import tarea.pkg3.Util;

/**
 *
 * @author Edgar-pc
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    
    private static Menu p;
    private static boolean dificultad=true;
    public static Jugador jugador;
    private static String imagen;
    
    private static ListaJugadores lista;
    
    private static ArrayList<String> listaNombres;
    
    
    

    public static String getImagen() {
        return imagen;
    }
    
    
    
    
//achtung static
    public  ListaJugadores getLista() {
        return lista;
    }
    
    public static ListaJugadores getLista2(){
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

    public  String getjTema() {
        
        int a=jTemas.getSelectedIndex();
        
        System.out.println(a);
        imagen="";
        imagen+= "Imagenes"+(a+1);
        
        
        return imagen;
        
        
        
    }
    
    public static boolean isDificultad() {
        
        return dificultad;
       
        
    }

    public static void setDificultad(boolean dificultad) {
        Menu.dificultad = dificultad;
    }
    
    public   Jugador getJugador(){
        
        
        if(jJugadores.getItemCount()>0){
            int a;
            a = jJugadores.getSelectedIndex();

            System.out.println("jugador"+ a);
            ArrayList<String> nombres= lista.getNombres();

                  nombres.get(a);

            Menu.jugador=lista.buscarJugador(nombres.get(a));

            return lista.buscarJugador(nombres.get(a));
        
             
        }
           return null;     
                
    }

    public  JComboBox<String> getjJugadores() {
        return jJugadores;
    }

   

    public static  void setjJugadores(JComboBox<String> jJugadores,String nombre) {
        jJugadores.addItem(nombre);
    }

    public static ArrayList<String> getListaNombres() {
        return listaNombres;
    }

    public static void setListaNombres(ArrayList<String> listaNombres) {
        Menu.listaNombres = listaNombres;
    }
    
    
    
    
    
    public  void fillJugadores()
   {
      // ArrayList<String> nombres= lista.getNombres();
      
       
       System.out.println(listaNombres);
     //  System.out.println("size "+lista.size());
       
       
     
       /*
       for (int i=0;i< nombres.size();i++){

        if ( jJugadores.getItemAt(i) == null )//parche          
                 {
                    jJugadores.addItem(nombres.get(i));
                 }
       }
       */
       
       
       /*temp
       if(jJugadores.getItemCount()>0){
            jJugadores.removeAllItems();
            System.out.println("borrado");
       }
       */
       
       for (int i=0;i< listaNombres.size();i++){

        if ( jJugadores.getItemAt(i) == null )//parche          
                 {
                    jJugadores.addItem(listaNombres.get(i));
                     System.out.println("agregado:"+listaNombres.get(i));
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
   
            System.out.println("Estoy en nombre");
            
            
            nombre = sc.next();
      
      
          while (sc.hasNextInt()){
              tiempos.add(sc.nextInt());
              
          }

           System.out.println("nombre"+nombre);
           
           
           Jugador nuevo= new Jugador(nombre);
           nuevo.setTiempos(tiempos);
            System.out.println(nuevo);
            System.out.println("agrega "+lista.agregarJugador(nuevo));
           
           
        }
        
        
            System.out.println("size"+lista.size());
        sc.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        
        
        
       
        
    }
    
    //Delete
    private void loadData2(){
        
        Util util= new Util();
        
        ListaJugadores test= new ListaJugadores();
        
        String path= System.getProperty("user.dir");
        
        try {
            test= util.cargarJugadores(path+"\\Memorice.txt");
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println(test);
      
        lista= test;
        
        
    }
    
      
    
     
    
    
    
    
    public Menu() {
        //loadData();
       // Jugador unnamed=new Jugador("Sin Nombre");
        
       // lista = new ListaJugadores();
       // System.out.println(lista.agregarJugador(unnamed));
       
        loadData2();
    
        listaNombres= lista.getNombres();
        
        System.out.println("array:"+listaNombres);
        
        initComponents();
        
        fillJugadores();
        
        //loadData2();
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Juego Memoria");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nivel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        buttonGroup1.add(jDificultad1);
        jDificultad1.setSelected(true);
        jDificultad1.setText("Básico");
        jDificultad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDificultad1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jDificultad2);
        jDificultad2.setText("Medio");
        jDificultad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDificultad2ActionPerformed(evt);
            }
        });

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
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jTemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animales", "Disney", "Los Simpsons"}));
        jTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTemasActionPerformed(evt);
            }
        });

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
        jJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJugadoresActionPerformed(evt);
            }
        });

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
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCrear))
        );

        jJugar.setText("Jugar");
        jJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJugarActionPerformed(evt);
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
                .addGap(107, 107, 107)
                .addComponent(jJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jJugar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jJugarActionPerformed
        // TODO add your handling code here:
        
        imagen=this.getjTema();
        
        //jugador= getJugador();
        
        
        
        //Juego Juego = new Juego();
        
        Juego.setFilas();
        
        Juego.getInstance().setTitle("Juego de "+jugador.getNombre());
        System.out.println("basico en menu: "+dificultad);
        Juego.setBasico(dificultad);
        
        
        //Juego.getInstance().build();
        
        //System.out.println("dificultad "+Juego.getInstance().isBasico());
        
        //Juego.setFilas();
        
        Juego.getInstance().setVisible(true);
        
        
        
        
    }//GEN-LAST:event_jJugarActionPerformed

    private void jCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCrearActionPerformed
        // TODO add your handling code here:
        
       // NuevoJugador.getInstance().setVisible(true);
   
        
        String nombre = JOptionPane.showInputDialog("Nombre Jugador:");
        if(nombre == null) return;
        if(! nombre.isEmpty()){
           Jugador nuevo = new Jugador(nombre) ;
           System.out.println(nombre);
            if(lista.agregarJugador(nuevo)){
                listaNombres.add(nombre);
                
                for (int i = 0; i < listaNombres.size();i++){

                 if ( jJugadores.getItemAt(i) == null )//parche 
                     
                    {
                        System.out.println("inside if: "+nuevo.getNombre());
                      jJugadores.addItem(nuevo.getNombre());
                    }
                
                }
                JOptionPane.showMessageDialog(null,"Jugador "+ nombre+" agregado", "Jugador",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Jugador "+ nombre+" ya esta en la lista", "Error",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Error: campo esta vacio", "Error",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        fillJugadores();
       
        
        
        
        
        
        
        
    }//GEN-LAST:event_jCrearActionPerformed

    
    
    
    
    
    
    
    
    private void jDificultad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDificultad2ActionPerformed
        // TODO add your handling code here:
        
        dificultad=jDificultad1.isSelected();
        
        
        
        
    }//GEN-LAST:event_jDificultad2ActionPerformed

    private void jDificultad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDificultad1ActionPerformed
        // TODO add your handling code here:
        
        dificultad=jDificultad1.isSelected();
        
        
    }//GEN-LAST:event_jDificultad1ActionPerformed

    private void jJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jJugadoresActionPerformed
        // TODO add your handling code here:
        
        int a;
        a=jJugadores.getSelectedIndex();
        
        //ArrayList<String> nombres= lista.getNombres();
        
        
        
        jugador= lista.buscarJugador(listaNombres.get(a));
        
        
        
       
        System.out.println(jugador);
        
        
        
        
        
        
    }//GEN-LAST:event_jJugadoresActionPerformed

    private void jTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemasActionPerformed
        // TODO add your handling code here:
        int a= jTemas.getSelectedIndex();
        
        imagen="Imagenes"+(a+1) ;
        
        
        
    }//GEN-LAST:event_jTemasActionPerformed

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
    // End of variables declaration//GEN-END:variables
}
