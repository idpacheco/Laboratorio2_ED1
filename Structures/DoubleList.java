package Structures;
public abstract class DoubleList {
    public DoubleNode first;
    public DoubleNode last;


    public abstract void addStack(int theData);

    public abstract void addQueue(int theData);

    public abstract void traversalRight();

    public abstract void traversalLeft();

    public abstract Node search(int theData);

    public abstract void delete(int theData);

}