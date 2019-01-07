/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg3;

import Interfaz.Menu;

/**
 *
 * @author Luis
 */
public class Tarea3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Jugador uno = new Jugador("Luis");
        Jugador dos = new Jugador("Franco");
        Jugador tres = new Jugador("Riki");
        
        ListaJugadores lista = new ListaJugadores();
        
        uno.agregarTiempo(1);
        uno.agregarTiempo(2);
        uno.agregarTiempo(3);
        dos.agregarTiempo(1);
        dos.agregarTiempo(1);
        tres.agregarTiempo(1);
        tres.agregarTiempo(1);
        
        lista.agregarJugador(uno);
        System.out.println(lista.agregarJugador(dos));
        lista.agregarJugador(tres);
        
        
        System.out.println(lista);
        
        Menu m= new Menu();
        
        m.setVisible(true);
        
        
    }
    
}
