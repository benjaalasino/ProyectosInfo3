/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
import java.util.*;
import java.util.*;

public class ColaConLista {
    private LinkedList<String> cola = new LinkedList<>();

    // Método para encolar un elemento
    public void enqueue(String elemento) {
        cola.addLast(elemento);
    }

    // Método para desencolar un elemento
    public String dequeue() {
        if (!cola.isEmpty()) {
            return cola.removeFirst();
        }
        return null; // Si la cola está vacía
    }

    // Método para ver el elemento al frente sin eliminarlo
    public String front() {
        if (!cola.isEmpty()) {
            return cola.getFirst();
        }
        return null; // Si la cola está vacía
    }

    // Ordenar una cola utilizando una pila como auxiliar
    public static void ordenarCola(ColaConLista cola) {
        PilaConLista pilaAuxiliar = new PilaConLista();
        while (cola.front() != null) {
            String temp = cola.dequeue();
            while (pilaAuxiliar.top() != null && Integer.parseInt(pilaAuxiliar.top()) > Integer.parseInt(temp)) {
                cola.enqueue(pilaAuxiliar.pop());
            }
            pilaAuxiliar.push(temp);
        }
        while (pilaAuxiliar.top() != null) {
            cola.enqueue(pilaAuxiliar.pop());
        }
    }

    // Verificar si una palabra o frase es un palíndromo
    public static boolean esPalindromo(String texto) {
        ColaConLista cola = new ColaConLista();
        for (char c : texto.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray()) {
            cola.enqueue(String.valueOf(c));
        }

        StringBuilder invertido = new StringBuilder();
        while (cola.front() != null) {
            invertido.append(cola.dequeue());
        }

        String original = texto.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return original.equals(invertido.toString());
    }
}
