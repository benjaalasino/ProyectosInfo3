/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info3;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Recursividad {
    public static void main(String[] args) {
        System.out.println(Factorial(3));
        System.out.println(Sumatoria(4));
        System.out.println(Fibonacci(8));
        System.out.println(Potencia(5,2));
    }
    public static int Factorial(int a){
        if(a != 1){
            return a*(Factorial(a-1));
        }else{
            return a;
        }
    }
    public static int Sumatoria(int a){
        if(a != 0){
            return a + Sumatoria(a-1);
        }else{
            return 0;
        }
    }
    public static int Fibonacci(int x){
        if( (x - 1 ) > 0){
            return Fibonacci(x-2) + Fibonacci(x-1);
        }else{
            return x;
        }
    }
    public static int Potencia(int a,int b){
        if(b == 0 ){
            return 1;
        }else{
            b--;
            return (a *Potencia(a,b));
        }
    }
}
