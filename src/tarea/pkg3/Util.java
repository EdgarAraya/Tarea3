/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Luis
 */
public class Util {
    
    public  ListaJugadores cargarJugadores(String archivo) throws FileNotFoundException, IOException{
       String k;
        ListaJugadores lista= new ListaJugadores();
        File x= new File(archivo);
        BufferedReader b = new BufferedReader(new FileReader (x));
        while(( k = b.readLine())!= null){
            String [] parts= k.split(";");
            Jugador h= new Jugador(parts[0]);
            for (int i =1; i <parts.length;i++){
                h.agregarTiempo(Integer.parseInt(parts[i].trim()));
            }
            lista.agregarJugador(h);
            
        }
        return lista;
    }
    
    public static boolean guardarTiempo(Jugador jugador){
        return false;
        
    }
}
