/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
import java.util.Scanner;

public class Proyecto5 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        int opcion = -1; // Iniciamos con un valor distinto de 0 para entrar en el bucle
        do {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Generar arbol binario con valores entre 0 y 25");
            System.out.println("2. Recorrido inorder para mostrar el arbol en orden");
            System.out.println("3. Permitir valores duplicados en el arbol (cambiar comportamiento)");
            System.out.println("4. Determinar la profundidad del arbol");
            System.out.println("5. Borrar un valor del arbol");
            System.out.println("6. Imprimir arbol de manera vertical");
            System.out.println("0. Salir");

            // Verifica que haya un entero antes de leerlo
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiamos el búfer de entrada
                continue; // Saltamos a la siguiente iteración del bucle
            }

            switch (opcion) {
                case 1:
                    arbol.generarArbol();
                    System.out.println("Arbol generado con 10 numeros aleatorios entre 0 y 25.");
                    break;

                case 2:
                    System.out.println("Recorrido inorder del arbol:");
                    arbol.inorder();
                    System.out.println();
                    break;

                case 3:
                    boolean permiteDuplicados = arbol.permiteDuplicados();
                    System.out.println("¿El arbol permite duplicados?: " + permiteDuplicados);
                    if (permiteDuplicados) {
                        System.out.println("Modificando el arbol para que no permita duplicados.");
                    } else {
                        System.out.println("Modificando el arbol para que permita duplicados.");
                    }
                    break;

                case 4:
                    int profundidad = arbol.profundidad();
                    System.out.println("La profundidad del arbol es: " + profundidad);
                    break;

                case 5:
                    System.out.println("Ingrese el valor a borrar del arbol:");
                    if (scanner.hasNextInt()) {
                        int valorABorrar = scanner.nextInt();
                        arbol.eliminar(valorABorrar);
                        System.out.println("Confirmacion del borrado con recorrido inorder:");
                        arbol.inorder();
                        System.out.println();
                    } else {
                        System.out.println("Entrada no válida.");
                        scanner.next();
                    }
                    break;

                case 6:
                    arbol.imprimirArbol();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);

      
    }
}
