/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.Random;

/**
 *
 * @author luisbenitez
 */
public class CodigoJuego2 {
    
    public int[] getCardNumbers() {
        
        int[] numbers = new int[24];
        int count = 0;
        
        while(count < 24) {
            Random r = new Random();
            int na = r.nextInt(12) + 1;
            int nvr = 0;
            
            for (int i = 0; i < 24; i++) {
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
