/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import tarea.pkg3.Jugador;



/**
 *
 * @author luisbenitez
 */
public class Juego4x4 extends javax.swing.JFrame {
    private static Juego4x4 p;
    
    private CodigoJuego uno= new CodigoJuego();
    private boolean caraUp = false;
    private ImageIcon im1;
    private ImageIcon im2;
    private JButton[] pbtn = new JButton[2];
    private boolean primerc = false;
    
    //private jButton butArr[]= new butArr
    
   
    
    long inicioms = System.currentTimeMillis();
    
     public static Juego4x4 getInstance(){
        
        if (p==null){
            p= new Juego4x4();
        }
        return p;
    }
    
    
    
    
    
    
    
    
    
    public Juego4x4() {
        initComponents();
        
        setCards();
    }

   
    
    private void setCards() {
        int[] numbers = uno.getCardNumbers(4,4);
        
        boton1.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[0]+".jpg")));
        boton2.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[1]+".jpg")));
        boton3.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[2]+".jpg")));
        boton4.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[3]+".jpg")));
        boton5.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[4]+".jpg")));
        boton6.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[5]+".jpg")));
        boton7.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[6]+".jpg")));
        boton8.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[7]+".jpg")));
        boton9.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[8]+".jpg")));
        boton10.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[9]+".jpg")));
        boton11.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[10]+".jpg")));
        boton12.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[11]+".jpg")));
        boton13.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[12]+".jpg")));
        boton14.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[13]+".jpg")));
        boton15.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[14]+".jpg")));
        boton16.setDisabledIcon(new ImageIcon(getClass().getResource("../Imagenes1/"+numbers[15]+".jpg")));
        
    } 
    
    
    private void botonEnabled(JButton btn) {
        
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
    
    
     private void ganador() {
        if(!boton1.isEnabled() && !boton2.isEnabled() && !boton3.isEnabled() && !boton4.isEnabled() && !boton5.isEnabled() && !boton6.isEnabled() && 
                !boton7.isEnabled() && !boton8.isEnabled() && !boton9.isEnabled() && !boton10.isEnabled() && !boton11.isEnabled() && 
                !boton12.isEnabled() && !boton13.isEnabled() && !boton14.isEnabled() && !boton15.isEnabled() && !boton16.isEnabled()) {
            
            long duracion = (System.currentTimeMillis()- inicioms)/1000;
            JOptionPane.showMessageDialog(this, "Felicidades " + duracion + " segundos");
         
            
            Jugador j= Menu.getInstance().getJugador();
            
            
            
            
            
            Menu.getInstance().getLista().agregarTiempo(j.getNombre(),(int) duracion);
            
            
            
            
            
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boton1 = new javax.swing.JButton();
        boton2 = new javax.swing.JButton();
        boton3 = new javax.swing.JButton();
        boton4 = new javax.swing.JButton();
        boton5 = new javax.swing.JButton();
        boton6 = new javax.swing.JButton();
        boton7 = new javax.swing.JButton();
        boton8 = new javax.swing.JButton();
        boton9 = new javax.swing.JButton();
        boton10 = new javax.swing.JButton();
        boton11 = new javax.swing.JButton();
        boton12 = new javax.swing.JButton();
        boton13 = new javax.swing.JButton();
        boton14 = new javax.swing.JButton();
        boton15 = new javax.swing.JButton();
        boton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        boton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton1MouseExited(evt);
            }
        });
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton2MouseExited(evt);
            }
        });
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton3MouseExited(evt);
            }
        });
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        boton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton4MouseExited(evt);
            }
        });
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        boton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton5MouseExited(evt);
            }
        });
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        boton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton6MouseExited(evt);
            }
        });
        boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton6ActionPerformed(evt);
            }
        });

        boton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton7MouseExited(evt);
            }
        });
        boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton7ActionPerformed(evt);
            }
        });

        boton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton8MouseExited(evt);
            }
        });
        boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton8ActionPerformed(evt);
            }
        });

        boton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton9MouseExited(evt);
            }
        });
        boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton9ActionPerformed(evt);
            }
        });

        boton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton10MouseExited(evt);
            }
        });
        boton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton10ActionPerformed(evt);
            }
        });

        boton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton11MouseExited(evt);
            }
        });
        boton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton11ActionPerformed(evt);
            }
        });

        boton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton12MouseExited(evt);
            }
        });
        boton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton12ActionPerformed(evt);
            }
        });

        boton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton13MouseExited(evt);
            }
        });
        boton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton13ActionPerformed(evt);
            }
        });

        boton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton14MouseExited(evt);
            }
        });
        boton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton14ActionPerformed(evt);
            }
        });

        boton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton15MouseExited(evt);
            }
        });
        boton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton15ActionPerformed(evt);
            }
        });

        boton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes1/signo.png"))); // NOI18N
        boton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton16MouseExited(evt);
            }
        });
        boton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(boton9)
                        .addGap(18, 18, 18)
                        .addComponent(boton10)
                        .addGap(18, 18, 18)
                        .addComponent(boton11)
                        .addGap(18, 18, 18)
                        .addComponent(boton12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(boton5)
                        .addGap(18, 18, 18)
                        .addComponent(boton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton7)
                        .addGap(18, 18, 18)
                        .addComponent(boton8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(boton1)
                        .addGap(12, 12, 12)
                        .addComponent(boton2)
                        .addGap(18, 18, 18)
                        .addComponent(boton3)
                        .addGap(18, 18, 18)
                        .addComponent(boton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(boton13)
                        .addGap(18, 18, 18)
                        .addComponent(boton14)
                        .addGap(18, 18, 18)
                        .addComponent(boton15)
                        .addGap(18, 18, 18)
                        .addComponent(boton16)))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(boton4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(boton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(boton2)
                            .addComponent(boton3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton6)
                            .addComponent(boton5)
                            .addComponent(boton7)
                            .addComponent(boton8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boton10)
                            .addComponent(boton9)
                            .addComponent(boton11)))
                    .addComponent(boton12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton13)
                    .addComponent(boton14)
                    .addComponent(boton15)
                    .addComponent(boton16))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        botonEnabled(boton1);
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        botonEnabled(boton2);
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        botonEnabled(boton3);
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        botonEnabled(boton4);
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        botonEnabled(boton5);
    }//GEN-LAST:event_boton5ActionPerformed

    private void boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton6ActionPerformed
       botonEnabled(boton6);
    }//GEN-LAST:event_boton6ActionPerformed

    private void boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton7ActionPerformed
        botonEnabled(boton7);
    }//GEN-LAST:event_boton7ActionPerformed

    private void boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton8ActionPerformed
        botonEnabled(boton8);
    }//GEN-LAST:event_boton8ActionPerformed

    private void boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton9ActionPerformed
        botonEnabled(boton9);
    }//GEN-LAST:event_boton9ActionPerformed

    private void boton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton10ActionPerformed
        botonEnabled(boton10);
    }//GEN-LAST:event_boton10ActionPerformed

    private void boton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton11ActionPerformed
        botonEnabled(boton11);
    }//GEN-LAST:event_boton11ActionPerformed

    private void boton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton12ActionPerformed
        botonEnabled(boton12);
    }//GEN-LAST:event_boton12ActionPerformed

    private void boton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton13ActionPerformed
        botonEnabled(boton13);
    }//GEN-LAST:event_boton13ActionPerformed

    private void boton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton14ActionPerformed
        botonEnabled(boton14);
    }//GEN-LAST:event_boton14ActionPerformed

    private void boton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton15ActionPerformed
        botonEnabled(boton15);
    }//GEN-LAST:event_boton15ActionPerformed

    private void boton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton16ActionPerformed
        botonEnabled(boton16);
    }//GEN-LAST:event_boton16ActionPerformed

    private void boton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton1MouseExited
        compare();
    }//GEN-LAST:event_boton1MouseExited

    private void boton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton2MouseExited
        compare();
    }//GEN-LAST:event_boton2MouseExited

    private void boton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton3MouseExited
        compare();
    }//GEN-LAST:event_boton3MouseExited

    private void boton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton4MouseExited
        compare();
    }//GEN-LAST:event_boton4MouseExited

    private void boton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton5MouseExited
        compare();
    }//GEN-LAST:event_boton5MouseExited

    private void boton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton6MouseExited
        compare();
    }//GEN-LAST:event_boton6MouseExited

    private void boton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton7MouseExited
        compare();
    }//GEN-LAST:event_boton7MouseExited

    private void boton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton8MouseExited
        compare();
    }//GEN-LAST:event_boton8MouseExited

    private void boton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton9MouseExited
       compare();
    }//GEN-LAST:event_boton9MouseExited

    private void boton10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton10MouseExited
        compare();
    }//GEN-LAST:event_boton10MouseExited

    private void boton11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton11MouseExited
        compare();
    }//GEN-LAST:event_boton11MouseExited

    private void boton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton12MouseExited
        compare();
    }//GEN-LAST:event_boton12MouseExited

    private void boton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton13MouseExited
        compare();
    }//GEN-LAST:event_boton13MouseExited

    private void boton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton14MouseExited
        compare();
    }//GEN-LAST:event_boton14MouseExited

    private void boton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton15MouseExited
        compare();
    }//GEN-LAST:event_boton15MouseExited

    private void boton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boton16MouseExited
        compare();
    }//GEN-LAST:event_boton16MouseExited

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
            java.util.logging.Logger.getLogger(Juego4x4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego4x4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego4x4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego4x4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego4x4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton10;
    private javax.swing.JButton boton11;
    private javax.swing.JButton boton12;
    private javax.swing.JButton boton13;
    private javax.swing.JButton boton14;
    private javax.swing.JButton boton15;
    private javax.swing.JButton boton16;
    private javax.swing.JButton boton2;
    private javax.swing.JButton boton3;
    private javax.swing.JButton boton4;
    private javax.swing.JButton boton5;
    private javax.swing.JButton boton6;
    private javax.swing.JButton boton7;
    private javax.swing.JButton boton8;
    private javax.swing.JButton boton9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
