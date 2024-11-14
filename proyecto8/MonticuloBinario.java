/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;

public class MonticuloBinario {
    private ArrayList<Integer> heap;

    public MonticuloBinario() {
        heap = new ArrayList<>();
    }

    // Insertar un elemento en el montículo
    public void insertar(int valor) {
        heap.add(valor);
        int i = heap.size() - 1;
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (heap.get(i) >= heap.get(padre)) break;
            intercambiar(i, padre);
            i = padre;
        }
    }

    // Extraer el elemento de menor prioridad (para un min-heap)
    public int extraerMinimo() {
        if (heap.isEmpty()) throw new IllegalStateException("El montículo está vacío");
        int minimo = heap.get(0);
        int ultimo = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, ultimo);
            hundir(0);
        }
        return minimo;
    }

    private void hundir(int i) {
        int menor = i;
        int izquierdo = 2 * i + 1;
        int derecho = 2 * i + 2;

        if (izquierdo < heap.size() && heap.get(izquierdo) < heap.get(menor)) {
            menor = izquierdo;
        }
        if (derecho < heap.size() && heap.get(derecho) < heap.get(menor)) {
            menor = derecho;
        }
        if (menor != i) {
            intercambiar(i, menor);
            hundir(menor);
        }
    }

    private void intercambiar(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Visualizar el montículo
    public void mostrarMonticulo() {
        System.out.println(heap);
    }
}
