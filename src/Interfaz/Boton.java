/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Boton extends JButton implements ActionListener{
    
    public Boton(int posx, int posy, int ancho, int alto){
    super.setBounds(posx, posy, ancho, alto); 
    addActionListener(this);
    setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes1/signo.png"))); 
    }
    
  private boolean caraUp = false;
    private ImageIcon im1;
    private ImageIcon im2;
    private JButton[] pbtn = new JButton[2];
    private boolean primerc = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        botonEnabled();
    }
    
  
        public void mouse(){
        MouseListener uno = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                compare();
                System.out.println("jjj");
            }
            
            
        };
        
        
      }
    
  
      public void botonEnabled() {
        
        if(!caraUp) {
            this.setEnabled(false);
            im1 = (ImageIcon) this.getDisabledIcon();
            pbtn[0] = this;
            caraUp = true;
            primerc = false;
        }
        else {
            this.setEnabled(false);
            im2 = (ImageIcon) this.getDisabledIcon();
            pbtn[1] = this;
            primerc = true; 
        }
    }
    
   
    public void compare() {
        if(caraUp && primerc) {
            
            if(im1.getDescription().compareTo(im2.getDescription()) != 0) {
                pbtn[0].setEnabled(true);
                pbtn[1].setEnabled(true);
               
            }
            caraUp = false;
        }
    }
    
    
   
   
    
}
