/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class Proyecto3 {

    // Ejercicio 2: Comprobación de Palíndromos con un arreglo de caracteres
    public static int esPalindromo(char[] arr) {
        int izquierda = 0;
        int derecha = arr.length - 1;
        
        // Comparar los caracteres de ambos extremos hacia el centro
        while (izquierda < derecha) {
            if (arr[izquierda] != arr[derecha]) {
                return 0; // Si no coinciden, no es un palíndromo
            }
            izquierda++;
            derecha--;
        }
        return 1; // Si todos los caracteres coinciden, es un palíndromo
    }

    // Ejercicio 3: Verificación de Expresiones Matemáticas Equilibradas con un arreglo de caracteres
    public static boolean estaEquilibrada(char[] expresion) {
        int contador = 0;
        for (char c : expresion) {
            if (c == '(') {
                contador++;
            } else if (c == ')') {
                if (contador == 0) {
                    return false;
                }
                contador--;
            }
        }
        return contador == 0;
    }

    // Ejercicio 5: Ordenar un arreglo de enteros en orden ascendente
    public static void ordenarArregloAscendente(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Intercambiar el elemento mínimo encontrado con el primer elemento del subarreglo
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main() {
        // Prueba del Ejercicio 2: Palíndromo
        System.out.println("Ejercicio 2: Palíndromo");
        char[] palabra1 = {'m', 'e', 'n', 'e', 'm'};
        System.out.println("Palabra: menem");
        if (esPalindromo(palabra1) == 1) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }

        char[] palabra2 = {'h', 'o', 'l', 'a'};
        System.out.println("Palabra: hola");
        if (esPalindromo(palabra2) == 1) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }

        // Prueba del Ejercicio 3: Expresiones Matemáticas Equilibradas
        System.out.println("\nEjercicio 3: Expresiones Matemáticas Equilibradas");
        char[] expresion1 = {'(', '1', '+', '2', ')', '*', '(', '3', '/', '4', ')'};
        System.out.println("Expresión: (1+2)*(3/4)");
        System.out.println(estaEquilibrada(expresion1) ? "Está equilibrada" : "No está equilibrada");

        char[] expresion2 = {'(', '(', '1', '+', '2', ')', '*', '3', '/', '4', ')'};
        System.out.println("Expresión: ((1+2)*3/4)");
        System.out.println(estaEquilibrada(expresion2) ? "Está equilibrada" : "No está equilibrada");

        // Prueba del Ejercicio 5: Ordenar un arreglo en orden ascendente
        System.out.println("\nEjercicio 5: Ordenar un Arreglo en Orden Ascendente");
        int[] arregloOriginal = {4, 1, 3, 2};

        System.out.print("Arreglo original: ");
        for (int i : arregloOriginal) {
            System.out.print(i + " ");
        }
        
        // Llamada al método de ordenación
        ordenarArregloAscendente(arregloOriginal);

        System.out.print("\nArreglo ordenado: ");
        for (int i : arregloOriginal) {
            System.out.print(i + " ");
        }
    }
}
