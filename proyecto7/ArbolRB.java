/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PFINAL;


 public class ArbolRB {
    private NodoRB raiz;
    private final boolean NEGRO = true;
    private final boolean ROJO = false;

    // Rotacion izquierda
    private void rotarIzquierda(NodoRB nodo) {
        NodoRB derecho = nodo.derecho;
        nodo.derecho = derecho.izquierdo;
        if (derecho.izquierdo != null)
            derecho.izquierdo.padre = nodo;

        derecho.padre = nodo.padre;
        if (nodo.padre == null)
            raiz = derecho;
        else if (nodo == nodo.padre.izquierdo)
            nodo.padre.izquierdo = derecho;
        else
            nodo.padre.derecho = derecho;

        derecho.izquierdo = nodo;
        nodo.padre = derecho;
    }

    // Rotacion derecha
    private void rotarDerecha(NodoRB nodo) {
        NodoRB izquierdo = nodo.izquierdo;
        nodo.izquierdo = izquierdo.derecho;
        if (izquierdo.derecho != null)
            izquierdo.derecho.padre = nodo;

        izquierdo.padre = nodo.padre;
        if (nodo.padre == null)
            raiz = izquierdo;
        else if (nodo == nodo.padre.derecho)
            nodo.padre.derecho = izquierdo;
        else
            nodo.padre.izquierdo = izquierdo;

        izquierdo.derecho = nodo;
        nodo.padre = izquierdo;
    }

    // Insercion de un nuevo nodo
    public void insertar(int valor) {
        NodoRB nuevo = new NodoRB(valor);
        raiz = insertarRec(raiz, nuevo);
        fijarViolacion(nuevo);
    }

    private NodoRB insertarRec(NodoRB raiz, NodoRB nodo) {
        if (raiz == null)
            return nodo;

        if (nodo.valor < raiz.valor) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, nodo);
            raiz.izquierdo.padre = raiz;
        } else if (nodo.valor > raiz.valor) {
            raiz.derecho = insertarRec(raiz.derecho, nodo);
            raiz.derecho.padre = raiz;
        }
        return raiz;
    }

    // Arreglo de violaciones en el arbol rojo-negro
    private void fijarViolacion(NodoRB nodo) {
        NodoRB padre, abuelo;

        while (nodo != raiz && nodo.color == ROJO && nodo.padre.color == ROJO) {
            padre = nodo.padre;
            abuelo = padre.padre;

            if (padre == abuelo.izquierdo) {
                NodoRB tio = abuelo.derecho;
                if (tio != null && tio.color == ROJO) {
                    abuelo.color = ROJO;
                    padre.color = NEGRO;
                    tio.color = NEGRO;
                    nodo = abuelo;
                } else {
                    if (nodo == padre.derecho) {
                        rotarIzquierda(padre);
                        nodo = padre;
                        padre = nodo.padre;
                    }
                    rotarDerecha(abuelo);
                    boolean temp = padre.color;
                    padre.color = abuelo.color;
                    abuelo.color = temp;
                    nodo = padre;
                }
            } else {
                NodoRB tio = abuelo.izquierdo;
                if (tio != null && tio.color == ROJO) {
                    abuelo.color = ROJO;
                    padre.color = NEGRO;
                    tio.color = NEGRO;
                    nodo = abuelo;
                } else {
                    if (nodo == padre.izquierdo) {
                        rotarDerecha(padre);
                        nodo = padre;
                        padre = nodo.padre;
                    }
                    rotarIzquierda(abuelo);
                    boolean temp = padre.color;
                    padre.color = abuelo.color;
                    abuelo.color = temp;
                    nodo = padre;
                }
            }
        }
        raiz.color = NEGRO;
    }

    // Metodo para eliminar un nodo
    public void eliminar(int valor) {
        NodoRB nodo = buscarNodo(raiz, valor);
        if (nodo != null)
            eliminarNodo(nodo);
    }

    private NodoRB buscarNodo(NodoRB nodo, int valor) {
        if (nodo == null || valor == nodo.valor)
            return nodo;

        if (valor < nodo.valor)
            return buscarNodo(nodo.izquierdo, valor);
        return buscarNodo(nodo.derecho, valor);
    }

    private void eliminarNodo(NodoRB nodo) {
        // Implementacion del metodo de eliminacion con balance
        // Este es un metodo complejo y requiere balanceo y color del arbol
    }

    // Metodo inorder para mostrar el arbol en orden
    public void inorder() {
        inorderRec(raiz);
        System.out.println();
    }

    private void inorderRec(NodoRB nodo) {
        if (nodo != null) {
            inorderRec(nodo.izquierdo);
            System.out.print(nodo.valor + (nodo.color == NEGRO ? "N " : "R "));
            inorderRec(nodo.derecho);
        }
    }

    // Metodo para verificar si el arbol cumple las propiedades de un arbol rojinegro
    public boolean verificarPropiedades() {
        return raiz.color == NEGRO && verificarPropiedadesRec(raiz) != -1;
    }

    private int verificarPropiedadesRec(NodoRB nodo) {
        if (nodo == null) return 1;
        int izquierdo = verificarPropiedadesRec(nodo.izquierdo);
        int derecho = verificarPropiedadesRec(nodo.derecho);

        if (izquierdo == -1 || derecho == -1 || izquierdo != derecho) return -1;
        if (nodo.color == NEGRO) izquierdo++;
        return izquierdo;
    }

    // Calcular la altura negra
    public int alturaNegra() {
        return alturaNegraRec(raiz);
    }

    private int alturaNegraRec(NodoRB nodo) {
        if (nodo == null) return 0;
        int altura = alturaNegraRec(nodo.izquierdo);
        return nodo.color == NEGRO ? altura + 1 : altura;
    }
}
