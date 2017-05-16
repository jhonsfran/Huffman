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
public class NodoArbol {
    
    private String dato;
    private Integer frecuencia;
    private NodoArbol izq;
    private NodoArbol der;
    private String valor_rama;

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public NodoArbol(String d) {
        dato = d;
        frecuencia = 1;
        izq = null;
        der = null;
        valor_rama = "";
    }

    public NodoArbol(String d, Integer n) {
        dato = d;
        frecuencia = n;
        izq = null;
        der = null;
        valor_rama = "";
    }

    /**
     * @return the valor_rama
     */
    public String getValor_rama() {
        return valor_rama;
    }

    /**
     * @param valor_rama the valor_rama to set
     */
    public void setValor_rama(String valor_rama) {
        this.valor_rama = valor_rama;
    }
}
