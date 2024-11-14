/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
import java.util.LinkedList;

public class TablaHash {
    private LinkedList<Entry>[] tabla;
    private int capacidad;

    @SuppressWarnings("unchecked")
    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        tabla = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    // Clase interna para representar una entrada de clave-valor
    private static class Entry {
        int clave;
        String valor;

        Entry(int clave, String valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    // Función hash
    private int hash(int clave) {
        return clave % capacidad;
    }

    // Insertar un elemento
    public void insertar(int clave, String valor) {
        int indice = hash(clave);
        for (Entry entrada : tabla[indice]) {
            if (entrada.clave == clave) {
                entrada.valor = valor;
                return;
            }
        }
        tabla[indice].add(new Entry(clave, valor));
    }

    // Buscar un elemento por su clave
    public String buscar(int clave) {
        int indice = hash(clave);
        for (Entry entrada : tabla[indice]) {
            if (entrada.clave == clave) {
                return entrada.valor;
            }
        }
        return null; // Retorna null si no encuentra el elemento
    }

    // Eliminar un elemento por su clave
    public boolean eliminar(int clave) {
        int indice = hash(clave);
        for (Entry entrada : tabla[indice]) {
            if (entrada.clave == clave) {
                tabla[indice].remove(entrada);
                return true;
            }
        }
        return false; // Retorna false si no encuentra el elemento
    }

    // Mostrar la tabla hash
    public void mostrarTabla() {
        for (int i = 0; i < capacidad; i++) {
            System.out.print("Índice " + i + ": ");
            for (Entry entrada : tabla[i]) {
                System.out.print("[" + entrada.clave + "->" + entrada.valor + "] ");
            }
            System.out.println();
        }
    }
}
