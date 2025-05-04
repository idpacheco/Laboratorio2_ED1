public class Main {
    public static void main(String[] args) {
        Procesos proc = new Procesos();
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
    }
}

