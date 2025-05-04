package Structures;
public abstract class List {
    public Node first;
    protected Node last;


    public abstract void addStack(int theData);

    public abstract void addQueue(int theData);

    public abstract void traversal();

    public abstract Node search(int theData);

    public abstract void delete(int theData);

}