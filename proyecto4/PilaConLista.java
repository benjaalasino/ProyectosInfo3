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
public class PilaConLista {
    private List<String> pila = new ArrayList<>();

    // Método para apilar un elemento
    public void push(String elemento) {
        pila.add(elemento);
    }

    // Método para desapilar un elemento
    public String pop() {
        if (!pila.isEmpty()) {
            return pila.remove(pila.size() - 1);
        }
        return null; // Si la pila está vacía
    }

    // Método para ver el elemento en la cima sin eliminarlo
    public String top() {
        if (!pila.isEmpty()) {
            return pila.get(pila.size() - 1);
        }
        return null; // Si la pila está vacía
    }

    // Verificación de paréntesis balanceados
    public static boolean verificarParentesis(String expresion) {
        PilaConLista pila = new PilaConLista();
        for (char c : expresion.toCharArray()) {
            if (c == '(') {
                pila.push(String.valueOf(c));
            } else if (c == ')') {
                if (pila.top() == null) {
                    return false; // No hay paréntesis para cerrar
                }
                pila.pop();
            }
        }
        return pila.top() == null; // Si la pila está vacía, los paréntesis están balanceados
    }

    // Conversión de decimal a binario utilizando una pila
    public static String decimalABinario(int numero) {
        PilaConLista pila = new PilaConLista();
        while (numero > 0) {
            pila.push(String.valueOf(numero % 2));
            numero /= 2;
        }
        StringBuilder binario = new StringBuilder();
        while (pila.top() != null) {
            binario.append(pila.pop());
        }
        return binario.toString();
    }
}
