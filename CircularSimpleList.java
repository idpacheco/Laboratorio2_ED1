
public class CircularSimpleList extends List {

    @Override
    void addStack(int theData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addStack'");
    }

    @Override
    void addQueue(int theData) {
        Node newNode = new Node(theData);
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;

        }
        last.next = first;
    }

    @Override
    void traversal() {
        if (first == null)
            System.out.println("Empty list");
        else {
            System.out.println("Elementos en la lista:");
            Node aux = first;
            do {
                System.out.print(aux.data + "|");
                aux = aux.next;
            } while (aux != first);
            System.out.println();
        }
    }

    @Override
    Node search(int theData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    void delete(int theData) {
        if (first == first.next && first.data == theData) {
            first = null;
            last = null;
        } else {
                if (first.data == theData) {
                    last.next = first.next;
                    first = first.next;
                } else {
                      if(last.data== theData){
                          Node antLast= first;
                          while (antLast.next != last) {
                              antLast = antLast.next;
                          }
                          antLast.next = first;
                          last = antLast;
                      }else{
                            Node antp = first;
                            Node p = first.next;
                            while (p != last && p.data != theData) {
                                antp = p;
                                p = p.next;
                            }
                            if (p.data == theData) {
                                antp.next = p.next;
                                p.next = null;
                            } 
                }

        }
    }

}
}