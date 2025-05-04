public class Procesos {
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
        
}
          

