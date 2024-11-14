/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;

/**
 *
 * @author Usuario
 */public class ColaConArreglo {
    private Integer[] queue;
    private int front, back, maxSize, size;

    public ColaConArreglo(int size) {
        maxSize = size;
        queue = new Integer[maxSize];
        front = 0;
        back = -1;
        this.size = 0;
    }

    public void enqueue(Integer item) {
        if (size == maxSize) {
            System.out.println("La cola está llena");
        } else {
            back = (back + 1) % maxSize;
            queue[back] = item;
            size++;
        }
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        } else {
            Integer item = queue[front];
            front = (front + 1) % maxSize;
            size--;
            return item;
        }
    }

    public Integer top() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        } else {
            return queue[front];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
