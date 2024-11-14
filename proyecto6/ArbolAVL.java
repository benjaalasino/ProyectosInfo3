package PFINAL;

public class ArbolAVL {
    private NodoAVL raiz;

    // Método para obtener la altura de un nodo
    private int altura(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.altura;
        }
    }

    // Método para obtener el factor de balance de un nodo
    private int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return altura(nodo.izquierdo) - altura(nodo.derecho);
        }
    }

    // Rotación derecha
    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    // Rotación izquierda
    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    // Método para insertar un nodo en el árbol AVL
    public NodoAVL insertar(NodoAVL nodo, int valor) {
        if (nodo == null) {
            return new NodoAVL(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertar(nodo.derecho, valor);
        } else {
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        int balance = obtenerBalance(nodo);

        if (balance > 1 && valor < nodo.izquierdo.valor) {
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && valor > nodo.derecho.valor) {
            return rotacionIzquierda(nodo);
        }

        if (balance > 1 && valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && valor < nodo.derecho.valor) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }
    // Método recursivo para calcular la altura de un nodo
    private int calcularAltura(NodoAVL nodo) {
        if (nodo == null) {
            return 0; // La altura de un nodo vacío es 0
        } else {
            // La altura es 1 más la altura máxima de los subárboles izquierdo y derecho
            int alturaIzquierda = calcularAltura(nodo.izquierdo);
            int alturaDerecha = calcularAltura(nodo.derecho);
            return 1 + Math.max(alturaIzquierda, alturaDerecha);
        }
    }

    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    // Método para encontrar el nodo con el valor mínimo
    private NodoAVL valorMinimo(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }

    // Método para eliminar un nodo en el árbol AVL
    public NodoAVL eliminar(NodoAVL nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminar(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null || nodo.derecho == null) {
                if (nodo.izquierdo != null) {
                    nodo = nodo.izquierdo;
                } else {
                    nodo = nodo.derecho;
                }
            } else {
                NodoAVL temp = valorMinimo(nodo.derecho);
                nodo.valor = temp.valor;
                nodo.derecho = eliminar(nodo.derecho, temp.valor);
            }
        }

        if (nodo == null) {
            return nodo;
        }

        nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;
        int balance = obtenerBalance(nodo);

        if (balance > 1 && obtenerBalance(nodo.izquierdo) >= 0) {
            return rotacionDerecha(nodo);
        }

        if (balance > 1 && obtenerBalance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecho) <= 0) {
            return rotacionIzquierda(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecho) > 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        return nodo;
    }

    public void eliminar(int valor) {
        raiz = eliminar(raiz, valor);
    }

    // Método inorder para mostrar el árbol en orden
    public void inorder() {
        inorderRec(raiz);
        System.out.println();
    }

    private void inorderRec(NodoAVL nodo) {
        if (nodo != null) {
            inorderRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorderRec(nodo.derecho);
        }
    }

    // Método para obtener la profundidad (altura) del árbol
    public int depth() {
        return depthRec(raiz);
    }

    private int depthRec(NodoAVL nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return Math.max(depthRec(nodo.izquierdo), depthRec(nodo.derecho)) + 1;
        }
    }
}
