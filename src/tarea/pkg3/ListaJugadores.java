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
            lista+=p.toString()+"\r\n";
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
    
    public void saveData() throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String path=  System.getProperty("user.dir");
        
        
        
        try (PrintWriter writer = new PrintWriter(path+"\\Memorice_test.txt", "UTF-8")) {
            writer.println(this.toString());
            System.out.println("here");
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
            FileWriter fileWriter = new FileWriter(path+"\\the-file-name.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Some String\r\n");
        printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
        printWriter.close();

        */


}
         
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
    
    
    
    
    
    

