/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Edgar Araya
 * @author Luis Benitez
 */
public class Jugador implements Comparable<Jugador> {
    
    private final String nombre;
    private  ArrayList<Integer>tiempos;
    
    
    
     /**
     * Constructor que crea un Jugador
     * @param nombre, corresponde al nombre de Jugador a Ingresar
     */
    
    
    public Jugador(String nombre){
        this.nombre=nombre;
        this.tiempos = new ArrayList();
    }
  
    /**
     * Retorna el nombre del Jugador
     * @return nombre de Jugador
     */
    
    public String getNombre(){
        return this.nombre;
    }
    
    
    /**
     * Compara este objeto con el objeto especificado por orden
     * @param j - el objeto a comparar.
     * @return un entero negativo, cero o un entero positivo ya que este objeto es menor, igual o mayor que el objeto especificado.
     */
    
    @Override
    public int compareTo(Jugador j){
        return this.nombre.compareToIgnoreCase(j.nombre);
    }
    
     /**
     * Compara 2 Jugadores, 2 Jugadores son iguales si sus nombres son iguales
     * @param o, - segundo Jugador
     * @return true en caso de igualdad y false en caso contrario
     */
    
    @Override
    public boolean equals(Object o){
        return o instanceof Jugador && this.getNombre().equalsIgnoreCase(((Jugador)o).nombre);
    }
    
     /**
     * Retorna el tiempo promedio de sus juegos
     * @return decimal que representa el tiempo promedio
     */
    
    
    public float tiempoPromedio(){
        float suma=0;
        float prom;
        for(Integer alguno: this.tiempos){
            suma=suma+alguno;
        }
        
        prom=suma/this.tiempos.size();
        
        return prom;   
    }
    
    /**
     * Muestra atributos objeto tipo Jugador en String 
     * @return datos de nombre y tiempos de Jugador
     */
    
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
            return this.nombre + ";";
        }
        
        return datos;
        
        
    }
    
    /**
     * Agrega un nuevo tiempo al registro del jugador
     * @param tiempo, - segundos que demora en terminar un juego
     */
    
    
    public void agregarTiempo(int tiempo){
        tiempos.add(tiempo);
    }
    
     /**
     * Agrega tiempos a lista
     * @param tiempos, -tiempos a agregar
     */
    
    public void agregarTiempo(ArrayList<Integer> tiempos){
        for (int i=0; i < tiempos.size();i++){
            this.agregarTiempo(tiempos.get(i));
            
        }
    }
    
      
    /**
     * Retornar el mejor tiempo (menor cantidad de segundos) en terminar un juego
     * @return mejor tiempo
     */
    
    public int mejorTiempo(){
       Collections.sort(this.tiempos);
        return this.tiempos.get(0);
    }
    
    /**
     * Retorna el total de jugadores registrados
     * @return total de juegos que el jugador tiene registrados
     */
    
    public int totalJuegos(){
        return tiempos.size();
    }
    
    /**
     * Retorna la lista de tiempos
     * @return tiempos
     */
    

    public ArrayList<Integer> getTiempos() {
        return tiempos;
    }
    
    /**
     * Setea valores de tiempos 
     * @param tiempos
     */
    
    public void setTiempos(ArrayList<Integer> tiempos)  {
        this.tiempos=tiempos;
    }
    
    
    
    
    
   
    
    
    
}
