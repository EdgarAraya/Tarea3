/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Edgar Araya
 * @author Luis Benitez
 */
public class Util {
    
    /**
     * Carga Jugadores a Juego
     *@param archivo, ruta del archivo en String
     * @return lista con jugadores cargados
     */
    
    public  ListaJugadores cargarJugadores(String archivo) throws FileNotFoundException, IOException{
        /*
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
    */
        ListaJugadores lista = new ListaJugadores();
        try{
            File datos = new File(archivo);
            datos.createNewFile();
        
            BufferedReader br = new BufferedReader(new FileReader (datos));
            String aux[], line;
            for(line=br.readLine(); line!=null; line=br.readLine()){
                aux = line.split(";");
                Jugador e = new Jugador(aux[0].trim());
                for(int i=1;i<aux.length;i++){
                    e.agregarTiempo(Integer.parseInt(aux[i].trim()));
                }
                
                if (!e.getNombre().trim().isEmpty()){
                
                lista.agregarJugador(e);
                
                }
                
            }
            JOptionPane.showMessageDialog(null,"Se han cargado datos de:\n"+archivo);
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"no se cargaron datos correctamente");
        }
        
        
       
        
        return lista;

    }
    
    /**
     * Guarda tiempos
     * @param ar, String con ruta
     * @param lista, Lista a la cual agregar tiempos
     * @return true en caso de que se guardo, false en caso de que no
     */
    
    public static boolean guardarTiempo(String ar, ListaJugadores lista){
        try(BufferedWriter bw = new BufferedWriter (new FileWriter(ar))){
            for(Jugador alguno:lista.getJugadores()){
                bw.write(alguno.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }catch(IOException e){
            
        }
        return false;
    
}
   
    
    
    
    
}
