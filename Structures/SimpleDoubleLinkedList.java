package Structures;
public class SimpleDoubleLinkedList extends DoubleList {

    @Override
    public void addStack(int theData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStack'");
    }

    @Override
    public void addQueue(int theData) {
        DoubleNode newNode = new DoubleNode(theData);
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.setRight(newNode);
            newNode.setLeft(last);
            last = newNode;
        }
    }

    @Override
    public void traversalRight() {
        if (first != null) {
            DoubleNode current = first;
            while (current != null) {
                System.out.print(current.getData() + "|");
                current = current.getRight(); // Avanzamos al siguiente nodo
            }
            System.out.println();
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    

    @Override
    public void traversalLeft() {
        if (first != null) {
            DoubleNode p = last;  // Comienza desde last
            while (p != null) {
                System.out.print(p.getData() + "|");
                p = p.getLeft();  // Recorrer hacia la izquierda
            }
            System.out.println();
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    

    public DoubleNode buscarNodo(int data) {
        DoubleNode temp = first;
        while (temp != null) {
            if (temp.getData() == data) {
                return temp;
            }
            temp = temp.getRight();
        }
        return null;
    }
    
    


    @Override
    public Node search(int theData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public void delete(int theData) {
        if (first != null) {
            DoubleNode p = first;
    
            // Caso 1: Eliminar el primero
            if (p.getData() == theData) {
                if (p != last) {
                    first = p.getRight();
                    first.setLeft(null);
                } else {
                    first = null;
                    last = null;
                }
                return;
            }
    
            // Caso 2: Eliminar el último
            if (theData == last.getData()) {
                last = last.getLeft();
                if (last != null) {
                    last.setRight(null);
                } else {
                    first = null;  // Solo había un nodo
                }
                return;
            }
    
            // Caso 3: Eliminar en el medio
            p = p.getRight();
            while (p != null && p.getData() != theData) {
                p = p.getRight();
            }
    
            if (p != null && p.getData() == theData) {
                p.getLeft().setRight(p.getRight());
                p.getRight().setLeft(p.getLeft());
                // Limpieza
                p.setLeft(null);
                p.setRight(null);
            } else {
                System.out.println("Dato no encontrado!");
            }
        }
    }
    


}
