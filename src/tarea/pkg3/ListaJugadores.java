/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Luis
 */
public class ListaJugadores {
    
    public TreeSet<Jugador>jugadores;
    
    /**
     * Constructor que crea una Lista de Jugadores
     */
    
    public ListaJugadores(){
        this.jugadores = new TreeSet();
    }

    /**
     * Retorna la lista de jugadores
     * @return jugadores
     */
    
    public TreeSet<Jugador> getJugadores() {
        return jugadores;
    }
    
    /**
     * Retorna tamaño lista jugadores
     * @return cantidad de jugadores
     */
    
    public int size(){
        return this.jugadores.size();
    }
    
    /**
     * Incorpora un nuevo jugador a la colección
     * @param nuevo, - jugador que se quiere incorporar
     * @return true en caso de éxito y false en caso contrario
     */
    
    
    public boolean agregarJugador(Jugador nuevo){
        return this.jugadores.add(nuevo);
    }
    
     /**
     * Muestra atributos de ListaJugadores en String
     * @return datos de la lista, nombre y tiempos de Jugador
     */
    
    @Override
    public String toString(){
        
        String lista="";
        
        for(Jugador p: this.jugadores){
            lista+=p.toString()+"\r\n";
        }
        return lista;
        
    }
    
    /**
     * Retorna nombre de Jugadores
     * @return nombre de jugadores
     */
    
    public ArrayList<String> getNombres(){
        ArrayList<String> nombres= new ArrayList();
        
        for (Jugador jug: jugadores){
            nombres.add(jug.getNombre());
            
        }
        return nombres;
        
    }
    
    /**
     * Busca un jugador dado su nombre
     * @param nombre, - nombre del jugador buscado
     * @return Jugador en caso de éxito y null en caso de que no exista
     */
    
    public Jugador buscarJugador(String nombre){
        
    for(Jugador alguno: this.jugadores){
        if(nombre.equalsIgnoreCase(alguno.getNombre())){
            return alguno;
        }
    }
    return null; 

    }
    
     /**
     * Guarda datos en archivo txt
     */
    
    public void saveData() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String path=  System.getProperty("user.dir");
        
        String path2= System.getProperty("user.home");
        
        if( this.jugadores.first().getNombre().isEmpty()){
            
            jugadores.remove(jugadores.first());
            
        }
        
        
        //t}guardar en carpeta proyecto
        // try (PrintWriter writer = new PrintWriter(path+"\\Memorice_test.txt", "UTF-8"))
        System.out.println("guardado en "+path);
        
        
        try (PrintWriter writer = new PrintWriter(path+"\\Memorice.txt", "UTF-8")) {
            writer.println(this.toString());
            System.out.println("fin");
        }
        
        
        /*
         try {
            //Whatever the file path is.
            File statText = new File(path+"\\the-file-name.txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);
            w.write(this.toString());
            w.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file");
        }
        
         */
        
        
         /*
          
        */


}
    
        
     /**
     * Agrega tiempo a un jugador espec{ifico
     *@param nombre, nombre del jugador del tiempo agregar
     *@param tiempo, tiempo a gregar al jugador
     * @return true en caso de haberse agregado, false en caso de que no.
     */
    
       public boolean agregarTiempo(String nombre,int tiempo)  {
           
           Jugador jug= new Jugador(nombre);
           
           if( this.jugadores.contains(jug)){
               
               for (Jugador j:jugadores){
                   
                  if(j.getNombre().equalsIgnoreCase(nombre)){
                      j.agregarTiempo(tiempo);
                      return true;
                  }
                   
                   
                   
               }
               
               
           }
           
               return false;
           
           
           
           
           
       }
    
    

        
        
        
    }
    
    
    
    
    
    

