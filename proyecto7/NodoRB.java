/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
public class NodoRB {
    int valor;
    NodoRB izquierdo, derecho, padre;
    boolean color; // true = negro, false = rojo

    public NodoRB(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
        this.color = false; // Nuevo nodo es rojo
    }
}

