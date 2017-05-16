/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Univalle_F
 */
public class Arbol {
    
    private NodoArbol raiz;

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public Arbol(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public Arbol(String s, Integer suma) {
        raiz = new NodoArbol(s, suma);
    }

    public void AgregarHojas(NodoArbol izq, NodoArbol der) {
        raiz.setIzq(izq);
        raiz.setDer(der);
    }
    
}
