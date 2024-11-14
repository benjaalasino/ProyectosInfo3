/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */import java.util.Arrays;
import java.util.Random;
import java.util.Arrays;
import java.util.Random;

import java.util.Arrays;
import java.util.Random;

import java.util.Arrays;
import java.util.Random;

public class Proyecto2 {

    // 1a. Método de ordenación por inserción
    public static void insercion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // 1b. Método de ordenación Shellsort
    public static void shellsort(int[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    // 1c. Método de ordenación Quicksort
    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quicksort(array, low, pi - 1);
            quicksort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // 2. Función para mostrar un array en pantalla
    public static void mostrarArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // 3. Función para generar un array de números aleatorios de longitud n
    public static int[] generarArrayAleatorio(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10000); // Números aleatorios entre 0 y 9999
        }
        return array;
    }

    // 4. Captura de tiempos de ejecución para cada algoritmo y tamaño de array
    public static void medirTiempos(int n) {
        int[] array = generarArrayAleatorio(n);
        
        int[] copiaInsercion = Arrays.copyOf(array, array.length);
        int[] copiaShellsort = Arrays.copyOf(array, array.length);
        int[] copiaQuicksort = Arrays.copyOf(array, array.length);

        System.out.println("Tiempos de ordenacion para " + n + " elementos:");

        // Tiempo para Inserción
        long start = System.nanoTime();
        insercion(copiaInsercion);
        long end = System.nanoTime();
        System.out.println("Insercion: " + (end - start) / 1_000_000.0 + " ms");

        // Tiempo para Shellsort
        start = System.nanoTime();
        shellsort(copiaShellsort);
        end = System.nanoTime();
        System.out.println("Shellsort: " + (end - start) / 1_000_000.0 + " ms");

        // Tiempo para Quicksort
        start = System.nanoTime();
        quicksort(copiaQuicksort, 0, copiaQuicksort.length - 1);
        end = System.nanoTime();
        System.out.println("Quicksort: " + (end - start) / 1_000_000.0 + " ms");

        System.out.println();
    }

    // 5. Ejercicio 4: Función para calcular el tiempo de ejecución de un algoritmo adicional (Por ejemplo: MergeSort)
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void medirTiemposConMergeSort(int n) {
        int[] array = generarArrayAleatorio(n);
        int[] copiaMergeSort = Arrays.copyOf(array, array.length);

        // Tiempo para MergeSort
        long start = System.nanoTime();
        mergeSort(copiaMergeSort, 0, copiaMergeSort.length - 1);
        long end = System.nanoTime();
        System.out.println("MergeSort: " + (end - start) / 1_000_000.0 + " ms");
        System.out.println();
    }

    public static void main() {
        // Ejecución con diferentes tipos de datos y tamaños
        System.out.println("Ejercicio 1: Ordenacion de enteros utilizando Insercion, Shellsort y Quicksort");
        
        int[] enteros = {4, 1, 3, 5, 2};
        System.out.println("Ordenacion de enteros (Insercion):");
        mostrarArray(enteros);
        insercion(enteros);
        mostrarArray(enteros);

        System.out.println("\nOrdenacion de enteros (Shellsort):");
        int[] enterosShell = {4, 1, 3, 5, 2};
        mostrarArray(enterosShell);
        shellsort(enterosShell);
        mostrarArray(enterosShell);

        System.out.println("\nOrdenacion de enteros (Quicksort):");
        int[] enterosQuick = {4, 1, 3, 5, 2};
        mostrarArray(enterosQuick);
        quicksort(enterosQuick, 0, enterosQuick.length - 1);
        mostrarArray(enterosQuick);

        System.out.println("\nEjercicio 2: Medicion de tiempos de ordenacion con diferentes tamanios de array");
        medirTiempos(100);
        medirTiempos(1000);
        medirTiempos(10000);

        System.out.println("\nEjercicio 3: Ejemplo de ordenacion de arrays con tamanios mayores:");
        int[] enterosGrandes = generarArrayAleatorio(100000);
        System.out.println("Array de tamanio 100000 generado aleatoriamente y ordenado con Quicksort:");
        quicksort(enterosGrandes, 0, enterosGrandes.length - 1);
        mostrarArray(enterosGrandes);

        System.out.println("\nEjercicio 4: Medicion de tiempos con MergeSort");
        medirTiemposConMergeSort(100);
        medirTiemposConMergeSort(1000);
        medirTiemposConMergeSort(10000);
    }
}
