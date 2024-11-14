/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;
import java.util.Scanner;
import java.lang.String;
/**
 *
 * @author Usuario
 */
public class MainProyectos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int op;
            do{
            System.out.println("\nCual proyecto quieres ver?");
            System.out.println("1. Recursividad");
            System.out.println("2. Ordenamiento");
            System.out.println("3. Pila y Cola con arreglos");
            System.out.println("4. Pila y Cola con lista");
            System.out.println("5. Arbol Binario");
            System.out.println("6. Arbol Binario AVL");
            System.out.println("7. Arbol Rojinegro");
            System.out.println("8. Monticulo binario y Tabla Hash");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");

            op = s.nextInt();

            switch (op) {
                case 1:
                    Proyecto1.main();
                    break;
                case 2:
                    Proyecto2.main();
                    break;
                case 3:
                    Proyecto3.main();
                    break;
                case 4:
                    Proyecto4.main();
                    break;
                case 5:
                    Proyecto5.main();
                    break;
                case 6:
                    Proyecto6.main();
                    break;
                case 7:
                    Proyecto7.main();
                    break;
                case 8:
                    Proyecto8.main();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No existe tal numero de proyecto");
                    break;
            }
            }while(op!=0);
        s.close();
    }
}


