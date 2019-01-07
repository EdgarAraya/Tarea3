/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg3;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Luis
 */
public class ListaJugadores {
    
    public TreeSet<Jugador>jugadores;
    
    public ListaJugadores(){
        this.jugadores = new TreeSet();
    }

    public TreeSet<Jugador> getJugadores() {
        return jugadores;
    }
    
    public int size(){
        return this.jugadores.size();
    }
    
    
    
    public boolean agregarJugador(Jugador nuevo){
        return this.jugadores.add(nuevo);
    }
    
    @Override
    public String toString(){
        
        String lista="";
        
        for(Jugador p: this.jugadores){
            lista+=p.toString()+"\n";
        }
        return lista;
        
    }
    
    public ArrayList<String> getNombres(){
        ArrayList<String> nombres= new ArrayList();
        
        for (Jugador jug: jugadores){
            nombres.add(jug.getNombre());
            
        }
        return nombres;
        
    }
    
    
    public Jugador buscarJugador(String nombre){
        
    for(Jugador alguno: this.jugadores){
        if(nombre.equalsIgnoreCase(alguno.getNombre())){
            return alguno;
        }
    }
    return null; 

    }
    
    
}
