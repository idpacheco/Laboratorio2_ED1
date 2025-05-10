package Structures;

public class Node {
    public int data;
    public Node next;
    public int fila, columna, valor;

    public Node(int theData) {
        this.data = theData;
        this.next = null;
    }
    public Node(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }

}
