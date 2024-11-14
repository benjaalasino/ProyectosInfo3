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

public class Proyecto4 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        PilaConLista pila = new PilaConLista();
        ColaConLista cola = new ColaConLista();
        int opcion;

        do {
            System.out.println("Selecciona una opcion:");
            System.out.println("1. Implementacion de una Pila con lista");
            System.out.println("2. Pila de Palabras");
            System.out.println("3. Verificación de Parentesis");
            System.out.println("4. Conversion de Decimal a Binario");
            System.out.println("5. Implementacion de una Cola con lista");
            System.out.println("6. Cola de Numeros");
            System.out.println("7. Ordenamiento de Cola");
            System.out.println("8. Verificacion de Palindromos con Cola");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Para consumir el salto de línea después de la opción

            switch (opcion) {
                case 1:
                    // Pila con lista
                    System.out.println("Implementación de una Pila con lista:");
                    pila.push("Elemento 1");
                    pila.push("Elemento 2");
                    pila.push("Elemento 3");
                    System.out.println("Cima de la pila: " + pila.top());
                    System.out.println("Desapilando: " + pila.pop());
                    System.out.println("Cima después de desapilar: " + pila.top());
                    break;

                case 2:
                    // Pila de Palabras
                    PilaConLista pilaPalabras = new PilaConLista();
                    System.out.println("Ingresa palabras para apilar. Escribe 'fin' para terminar.");
                    String palabra;
                    while (true) {
                        palabra = scanner.nextLine();
                        if (palabra.equals("fin")) break;
                        pilaPalabras.push(palabra);
                    }
                    System.out.println("Palabras desapiladas en orden inverso:");
                    while (pilaPalabras.top() != null) {
                        System.out.println(pilaPalabras.pop());
                    }
                    break;

                case 3:
                    // Verificación de Paréntesis
                    System.out.println("Ingresa una expresión matemática:");
                    String expresion = scanner.nextLine();
                    if (PilaConLista.verificarParentesis(expresion)) {
                        System.out.println("Paréntesis balanceados");
                    } else {
                        System.out.println("Paréntesis desbalanceados");
                    }
                    break;

                case 4:
                    // Conversión de Decimal a Binario
                    System.out.println("Ingresa un numero decimal:");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Para consumir el salto de línea
                    System.out.println("Numero binario: " + PilaConLista.decimalABinario(numero));
                    break;

                case 5:
                    // Cola con lista
                    System.out.println("Implementacion de una Cola con lista:");
                    cola.enqueue("Elemento 1");
                    cola.enqueue("Elemento 2");
                    cola.enqueue("Elemento 3");
                    System.out.println("Elemento al frente: " + cola.front());
                    System.out.println("Desencolando: " + cola.dequeue());
                    System.out.println("Elemento al frente después de desencolar: " + cola.front());
                    break;

                case 6:
                    // Cola de Números
                    ColaConLista colaNumeros = new ColaConLista();
                    System.out.println("Ingresa números para encolar. Escribe 'fin' para terminar.");
                    int numeroEncolado;
                    while (true) {
                        String entrada = scanner.nextLine();
                        if (entrada.equals("fin")) break;
                        try {
                            numeroEncolado = Integer.parseInt(entrada);
                            colaNumeros.enqueue(String.valueOf(numeroEncolado));
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor ingresa un número valido.");
                        }
                    }
                    int suma = 0;
                    while (colaNumeros.front() != null) {
                        suma += Integer.parseInt(colaNumeros.dequeue());
                    }
                    System.out.println("La suma de los numeros es: " + suma);
                    break;

                case 7:
                    // Ordenamiento de Cola
                    System.out.println("Ingresa numeros para encolar (escribe 'fin' para terminar):");
                    ColaConLista colaParaOrdenar = new ColaConLista();
                    while (true) {
                        String entrada = scanner.nextLine();
                        if (entrada.equals("fin")) break;
                        try {
                            numeroEncolado = Integer.parseInt(entrada);
                            colaParaOrdenar.enqueue(String.valueOf(numeroEncolado));
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor ingresa un número valido.");
                        }
                    }
                    ColaConLista.ordenarCola(colaParaOrdenar);
                    System.out.println("Cola ordenada:");
                    while (colaParaOrdenar.front() != null) {
                        System.out.println(colaParaOrdenar.dequeue());
                    }
                    break;

                case 8:
                    // Verificación de Palíndromos con Cola
                    System.out.println("Ingresa una palabra o frase para verificar si es un palíndromo:");
                    String frase = scanner.nextLine();
                    if (ColaConLista.esPalindromo(frase)) {
                        System.out.println("Es un palindromo.");
                    } else {
                        System.out.println("No es un palindromo.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while(opcion!=0);
        
    }
}