/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.Random;

/**
 * @author Edgar Araya
 * @author Luis Benitez
 */
public class CodigoJuego {
    
    public int[] getCardNumbers(int filas, int columnas) {
        int size=filas*columnas;
        int[] numbers = new int[size];
        int count = 0;
        while(count < size) {
            Random r = new Random();
            int na = r.nextInt(size/2) + 1;
            int nvr = 0;
            
            for (int i = 0; i < size; i++) {
                if(numbers[i] == na) {
                    nvr++;
                }
            }
            if(nvr < 2) {
                numbers[count] = na;
                count++;
            }//fin
        }
        
        
        return numbers;
    }
    
}
