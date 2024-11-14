/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */public class PilaConArreglo {
    private int top;
    private Integer[] stack;
    private int maxSize;
    int value;

    public PilaConArreglo(int size) {
        maxSize = size;
        stack = new Integer[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("La pila está llena");
        } else {
            stack[++top] = value;
        }
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        } else {
            return stack[top--];
        }
    }

    public Integer top() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
