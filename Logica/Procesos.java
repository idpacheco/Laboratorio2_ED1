package Logica;
import Structures.CircularSimpleList;
import Structures.DoubleNode;
import Structures.Node;
import Structures.Pila;
import Structures.SimpleDoubleLinkedList;

public class Procesos {
    // Enunciado 1
    // Metodo para multiplicar dos matrices dispersas representadas como listas enlazadas
    public static Node multiplicar(Node A, Node B, int n) {
        Node resultado = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int suma = 0;
                for (int k = 0; k < n; k++) {
                    int valA = obtenerValor(A, i, k);
                    int valB = obtenerValor(B, k, j);
                    suma += valA * valB;
                }
                if (suma != 0) {
                    resultado = insertarNodo(resultado, i, j, suma);
                }
            }
        }

        return resultado;
    }
    // Obtiene el valor en una posición específica (i, j) de la lista
    public static int obtenerValor(Node cabeza, int i, int j) {
        Node actual = cabeza;
        while (actual != null) {
            if (actual.fila == i && actual.columna == j) {
                return actual.valor;
            }
            actual = actual.next;
        }
        return 0;
    }
    //Inserta un nodo en la lista enlazada al final
    public static Node insertarNodo(Node cabeza, int fila, int columna, int valor) {
        Node nuevo = new Node(fila, columna, valor);
        if (cabeza == null) return nuevo;

        Node actual = cabeza;
        while (actual.next != null) {
            actual = actual.next;
        }
        actual.next = nuevo;
        return cabeza;
    }
    // Calcula A^potencia usando multiplicación repetida
    public static Node potenciaMatriz(Node A, int potencia, int n) {
        if (potencia == 1) return copiarLista(A);
        Node resultado = copiarLista(A);
        for (int i = 1; i < potencia; i++) {
            resultado = multiplicar(resultado, A, n);
        }
        return resultado;
    }

    // Copia la lista enlazada
    public static Node copiarLista(Node original) {
        if (original == null) return null;
        Node nuevo = new Node(original.fila, original.columna, original.valor);
        nuevo.next = copiarLista(original.next);
        return nuevo;
    }

    // Imprime la lista enlazada
    public static void imprimirLista(Node cabeza) {
        Node actual = cabeza;
        while (actual != null) {
            System.out.println("(" + actual.fila + ", " + actual.columna + ", " + actual.valor + ")");
            actual = actual.next;
        }
    }

    // Enunciado 2
    // Método para agregar un nodo a la lista doblemente enlazada en orden
    public void addOrder(DoubleNode X, SimpleDoubleLinkedList list) {
        DoubleNode C = list.first;
        if (C != null) {
            if (list.first.getData() > X.getData()) { //Verifica si el primer nodo es mayor que el nuevo nodo
                // Si es verdadero, inserta el nuevo nodo al inicio y actualiza el primer nodo de la lista
                X.setRight(list.first);
                list.first.setLeft(X);
                X.setLeft(null);
                list.first = X;

            } else if (list.last.getData() < X.getData()) { //Verifica si el último nodo es menor que el nuevo nodo
                // Si es verdadero, inserta el nuevo nodo al final y actualiza el último nodo de la lista
                X.setLeft(list.last);
                list.last.setRight(X);
                X.setRight(null);
                list.last = X;

            } else {
                //Ya que el nuevo nodo no es ni el primero ni el último, se busca la posición correcta para insertarlo
                while (C.getData() < X.getData() && C != list.last) {
                    C = C.getRight();
                }

                if (C.getData() > X.getData()) {
                    X.setRight(C);
                    X.setLeft(C.getLeft());
                    C.getLeft().setRight(X);
                    C.setLeft(X);
                } 
            }
        } 
        }
    
    

// Enunciado 2
//Función para mezclar una lista doblemente enlazada y una lista circular simplemente enlazada
//Si un nodo de la lista circular ya existe en la lista doblemente enlazada, se elimina de ambas listas
//Si no existe, se agrega a la lista doblemente enlazada en orden
public void mixingList (SimpleDoubleLinkedList PTR1, CircularSimpleList PTR2) {
    if (PTR1.first != null){
        if (PTR2.first != null) {
            Node p2 = PTR2.first;
            boolean evaluarFirst = true;
            while (p2 != PTR2.first || evaluarFirst) {
                evaluarFirst = false;
                
                boolean found = false;
                DoubleNode p= PTR1.first; 

                while (p != null) {
                    if (p2.data == p.getData()) {
                        found = true;
                        break;
                    }
                    p = p.getRight();
                }
                Node Nextp2 = p2.next;
                if (found == false) {
                    DoubleNode X = new DoubleNode(p2.data);
                    addOrder(X, PTR1);
            }   else {
                     PTR1.delete(p2.data);
                     PTR2.delete(p2.data);
            }
                p2 = Nextp2;
            }
    } else {
        System.out.println("La lista circular está vacía");
            }       
    } else {
        System.out.println("La lista doblemente enlazada está vacía");
    }
    PTR2 = null; // Liberar la memoria de la lista circular
}
// Enunciado 3
/* * Este programa verifica si una expresión tiene correctamente balanceados los siguientes símbolos:
 * paréntesis (), corchetes [] y llaves {}.
 *
 * Reglas:
 * - Cada símbolo de apertura debe tener su símbolo de cierre correspondiente.
 * - El orden de los símbolos debe ser correcto; por ejemplo, la expresión [(]) no es válida.
 * - Si hay símbolos de cierre sin haber uno de apertura correspondiente antes, la expresión es inválida.
 *
 * El programa debe:
 * - Recorrer la cadena ingresada.
 * - Usar una estructura de datos tipo pila (stack) para realizar la verificación.
 * - Mostrar un mensaje indicando si la expresión está "balanceada" o "no balanceada".
 */ 
 public static boolean esBalanceada(String expresion) {
         int tam = expresion.length();
        Pila.pila = new char[tam]; 
        Pila.tope = -1; 

        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);

            if (simbolo == '(' || simbolo == '[' || simbolo == '{') {
                Pila.inPila( tam, simbolo);
            } else if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                Character elem = Pila.outPila(tam);  

                if (elem == null) {
                    return false;
                }

                if ((simbolo == ')' && elem != '(') ||
                    (simbolo == ']' && elem != '[') ||
                    (simbolo == '}' && elem != '{')) {
                    return false;
                }
            }
        }
        if (Pila.tope == -1) {
            return true; // La pila está vacía, la expresión está balanceada
        } else {
            return false; // Quedan símbolos de apertura sin cerrar
        }

    }



}
