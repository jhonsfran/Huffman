/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Comparator;

/**
 *
 * @author Univalle_F
 */
public class OrdenarPorFrecuencia implements Comparator {

    
    @Override
    public int compare(Object nodo1, Object nodo2){
        if (((NodoArbol)nodo1).getFrecuencia()-((NodoArbol)nodo2).getFrecuencia()!=0){
            return ((NodoArbol)nodo1).getFrecuencia()-((NodoArbol)nodo2).getFrecuencia();
        }
        return -1;
    }
    
}
