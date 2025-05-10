package Main;
import Logica.Procesos;
import static Logica.Procesos.esBalanceada;
import static Logica.Procesos.imprimirLista;
import static Logica.Procesos.insertarNodo;
import static Logica.Procesos.potenciaMatriz;
import Structures.CircularSimpleList;
import Structures.Node;
import Structures.SimpleDoubleLinkedList;
public class Main {
    public static void main(String[] args) {
        Procesos proc = new Procesos();
        // Enunciado 1
        // (0, 0, 1) -> (0, 1, 2) -> (1, 1, 3) -> (2, 2, 4)
        Node matriz = null;
        matriz = insertarNodo(matriz, 0, 0, 1);
        matriz = insertarNodo(matriz, 0, 1, 2);
        matriz = insertarNodo(matriz, 1, 1, 3);
        matriz = insertarNodo(matriz, 2, 2, 4);

        int potencia = 3; // Potencia a la que se elevará la matriz
        int tamaño = 3;

        Node resultado = potenciaMatriz(matriz, potencia, tamaño);
        System.out.println("Matriz elevada a la potencia " + potencia + ":");
        imprimirLista(resultado);

        // Enunciado 2
        // Lista doblemente enlazada SIMPLE
        System.out.println("Lista doblemente enlazada simple");
        SimpleDoubleLinkedList PTR1 = new SimpleDoubleLinkedList();
        PTR1.addQueue(0);
        PTR1.addQueue(2);
        PTR1.addQueue(3);
        PTR1.addQueue(5);
        PTR1.addQueue(40);
        PTR1.traversalRight();

        System.out.println("Lista circular simplemente enlazada");
        CircularSimpleList PTR2 = new CircularSimpleList();
        PTR2.addQueue(10);
        PTR2.addQueue(0);
        PTR2.addQueue(30);
        PTR2.addQueue(40);
        PTR2.addQueue(6);
        PTR2.traversal();

        // Mezcla de listas
        proc.mixingList(PTR1, PTR2);
        System.out.println("Lista doblemente enlazada simple después de mezclar:");
        PTR1.traversalRight();

        //Enunciado 3
       String expresion = "(((()))"; 
         if (esBalanceada(expresion)) {
            System.out.println("La expresión está BALANCEADA");
        } else {
            System.out.println("La expresión NO está balanceada");
    }
}
}
