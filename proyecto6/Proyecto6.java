/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
public class Proyecto6 {
    public static void main() {
        // Ejercicio 2: Generar árbol AVL con valores desordenados
        System.out.println("\nEjercicio 2:\n");
        ArbolAVL arbol1 = new ArbolAVL();
        int[] valores1 = {10, 100, 20, 80, 40, 70};
        for (int valor : valores1) {
            arbol1.insertar(valor);
        }
        arbol1.inorder();

        // Ejercicio 3: Generar árbol AVL con valores ordenados
        System.out.println("\nEjercicio 3:\n");
        ArbolAVL arbol2 = new ArbolAVL();
        int[] valores2 = {5, 10, 20, 30, 40, 50, 60};
        for (int valor : valores2) {
            arbol2.insertar(valor);
        }
        arbol2.inorder();

        // Ejercicio 4: Eliminar nodo con valor 1 y 30 del árbol
        System.out.println("\nEjercicio 4:\n");
        arbol2.eliminar(1);
        arbol2.inorder();
        arbol2.eliminar(30);
        arbol2.inorder();

        // Profundidad del árbol
        System.out.println("\nProfundidad del Arbol: \n" + arbol2.depth());
    }
}
