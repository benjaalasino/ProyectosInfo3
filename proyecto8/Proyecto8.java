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

public class Proyecto8 {
    public static void main() {
        MonticuloBinario monticulo = new MonticuloBinario();
        TablaHash tablaHash = new TablaHash(10);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insertar en monticulo");
            System.out.println("2. Extraer del monticulo");
            System.out.println("3. Insertar en tabla hash");
            System.out.println("4. Buscar en tabla hash");
            System.out.println("5. Eliminar de tabla hash");
            System.out.println("6. Mostrar monticulo");
            System.out.println("7. Mostrar tabla hash");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un valor para insertar en el monticulo: ");
                    int valorMonticulo = scanner.nextInt();
                    monticulo.insertar(valorMonticulo);
                    break;
                case 2:
                    try {
                        int min = monticulo.extraerMinimo();
                        System.out.println("Elemento extraido del monticulo: " + min);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Ingrese una clave para la tabla hash: ");
                    int clave = scanner.nextInt();
                    System.out.print("Ingrese un valor para la tabla hash: ");
                    String valor = scanner.next();
                    tablaHash.insertar(clave, valor);
                    break;
                case 4:
                    System.out.print("Ingrese la clave a buscar en la tabla hash: ");
                    clave = scanner.nextInt();
                    String resultado = tablaHash.buscar(clave);
                    if (resultado != null) {
                        System.out.println("Valor encontrado: " + resultado);
                    } else {
                        System.out.println("Clave no encontrada en la tabla hash.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la clave a eliminar de la tabla hash: ");
                    clave = scanner.nextInt();
                    boolean eliminado = tablaHash.eliminar(clave);
                    System.out.println(eliminado ? "Elemento eliminado." : "Clave no encontrada.");
                    break;
                case 6:
                    System.out.println("Monticulo:");
                    monticulo.mostrarMonticulo();
                    break;
                case 7:
                    System.out.println("Tabla Hash:");
                    tablaHash.mostrarTabla();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion > 0);
        
    }
}
