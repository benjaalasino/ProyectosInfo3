/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
public class Proyecto7 {
    public static void main() {
        ArbolRB arbol = new ArbolRB();

        // Ejercicio 2a: Insertar valores
        System.out.println("\nEjercicio 2:\n");
        int[] valores = {10, 20, 30, 40, 50, 60, 70};
        for (int valor : valores) {
            arbol.insertar(valor);
            arbol.inorder();
        }

        // Ejercicio 3b: Eliminar nodo con valor 30
        System.out.println("\nEjercicio 3:\n");
        arbol.eliminar(30);
        arbol.inorder();

        // Ejercicio 5a: Verificar propiedades
        System.out.println("\nEjercicio 5:");
        System.out.println("Cumple propiedades de arbol rojinegro: " + arbol.verificarPropiedades());

        // Ejercicio 6a: Calcular altura negra
        System.out.println("\nEjercicio 6:\n");
        System.out.println("Altura negra del arbol: " + arbol.alturaNegra());
    }
}
