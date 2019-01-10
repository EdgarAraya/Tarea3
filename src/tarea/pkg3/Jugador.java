/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg3;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Luis
 */
public class Jugador implements Comparable<Jugador> {
    
    private final String nombre;
    private  ArrayList<Integer>tiempos;
    
    
    
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.tiempos = new ArrayList();
    }

    public String getNombre(){
        return this.nombre;
    }
    
    @Override
    public int compareTo(Jugador j){
        return this.nombre.compareToIgnoreCase(j.nombre);
    }
    
    @Override
    public boolean equals(Object o){
        return o instanceof Jugador && this.getNombre().equalsIgnoreCase(((Jugador)o).nombre);
    }
    
    public float tiempoPromedio(){
        float suma=0;
        float prom;
        for(Integer alguno: this.tiempos){
            suma=suma+alguno;
        }
        
        prom=suma/this.tiempos.size();
        
        return prom;   
    }
    
    @Override
    public String toString(){
         String datos="";
        
        
        
        if (this.tiempos.size()!=0){
        datos+= this.nombre;
                
                for(int i =0; i < this.totalJuegos();i++){
                    
                    datos+=";"+tiempos.get(i);   
                }      
        }
        else{
            return this.nombre + " 0";
        }
        
        return datos;
        
        
    }
    
    public void agregarTiempo(int tiempo){
        tiempos.add(tiempo);
    }
    
    public int mejorTiempo(){
       Collections.sort(this.tiempos);
        return this.tiempos.get(0);
    }
    
    public int totalJuegos(){
        return tiempos.size();
    }

    public ArrayList<Integer> getTiempos() {
        return tiempos;
    }
    //test
    public void setTiempos(ArrayList<Integer> tiempos)  {
        this.tiempos=tiempos;
    }
    
    
    
    
    
   
    
    
    
}
