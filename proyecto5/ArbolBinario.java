/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
import java.util.Random;

public class ArbolBinario {
    private Nodo raiz;

    // Método para insertar nodos en el árbol sin duplicados
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo; // ignora valores duplicados
    }

    // Generar árbol binario con 10 números aleatorios entre 0 y 25
    public void generarArbol() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int valor = rand.nextInt(26); // valores entre 0 y 25
            insertar(valor);
        }
    }

    // Método inorder para recorrer el árbol en orden
    public void inorder() {
        inorderRecursivo(raiz);
    }

    private void inorderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inorderRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorderRecursivo(nodo.derecho);
        }
    }

    // Método para verificar si permite duplicados
    public boolean permiteDuplicados() {
        // Este árbol no permite duplicados ya que se ignoran en el método insertar
        return false;
    }

    // Método para contar la profundidad (niveles) del árbol
    public int profundidad() {
        return profundidadRecursiva(raiz);
    }

    private int profundidadRecursiva(Nodo nodo) {
        if (nodo == null) return 0;
        int izq = profundidadRecursiva(nodo.izquierdo);
        int der = profundidadRecursiva(nodo.derecho);
        return Math.max(izq, der) + 1;
    }

    // Método para eliminar un nodo con un valor específico
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            System.out.println("No se encontro el valor " + valor + " en el arbol.");
            return null;
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        } else {
            // Nodo con el valor encontrado
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;

            nodo.valor = valorMin(nodo.derecho);
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.valor);
        }
        return nodo;
    }

    private int valorMin(Nodo nodo) {
        int minValor = nodo.valor;
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
            minValor = nodo.valor;
        }
        return minValor;
    }
    // Método para imprimir el árbol de manera visual
    public void imprimirArbol() {
        imprimirArbolRecursivo(raiz, "", true);
    }

    private void imprimirArbolRecursivo(Nodo nodo, String prefix, boolean esHijoIzquierdo) {
            if (nodo != null) {
                System.out.println(prefix + (esHijoIzquierdo ? "|-- " : "\\-- ") + nodo.valor);
                imprimirArbolRecursivo(nodo.izquierdo, prefix + (esHijoIzquierdo ? "|   " : "    "), true);
                imprimirArbolRecursivo(nodo.derecho, prefix + (esHijoIzquierdo ? "|   " : "    "), false);
            }
        }
}