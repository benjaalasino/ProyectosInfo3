/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */
public class Proyecto1 {
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }
    public static int sumatoria(int n){
        if(n== 1){
            return 1;
        }else{
            return n + sumatoria(n-1);
        }
    }
    public static int potencia(int base, int exponente){
        if(exponente == 0){
            return 1;
        }else{
            return base * potencia(base, exponente-1);
        }
    }
    public static int conteoRegresivo(int n){
        if(n == 1){
            return 1;
        }else{
            System.out.println(n+",");
            return conteoRegresivo(n-1);
        }
    }
    public static int sumaSucesiva(int n , int multiplo){
        if(multiplo== 0){
            
            return 0;
            
        }else{
            
            return n+sumaSucesiva(n,multiplo-1);
        }
    }
    public static void imprimirAlreves(int [] array, int index){
        if(index == 0 ){
            return;
        }else{
            System.out.println(array[index-1]+"");
            imprimirAlreves(array,index-1);
        }
        
    }
    public static void main() {
        int[] array = { 1 , 2 ,3 , 4 , 5 };
        System.out.println("\n Ejercicio 1: \nEl factorial de 4 es " +factorial(4));
        System.out.println("\n Ejercicio 2 : \nLa sumatoria de n = 4 es "+ sumatoria(4));
        System.out.println("\nEjercicio  3 : \nEl resultado de 3 elevado al cuadrado es "+potencia(3,2));
        System.out.println("\n Ejercicio 4 : \n Conteo desde 3 : ");
        System.out.println(conteoRegresivo(3));
        System.out.println("\n Ejercicio 4 : \n Dos por tres usando suma sucesiva "+ sumaSucesiva(2,3));
        System.out.println("\n Ejercicio 5 : \n ");
        System.out.println("Array original: ");
        for(int i = 0 ; i < array.length ; i++){
            System.out.println(array[i]);
        }
        System.out.println("Array al reves");
        imprimirAlreves(array,array.length);
        
    }
}
