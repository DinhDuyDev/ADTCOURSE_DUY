package Book_Work;
public class LinkedList<T> {
    private Node firstNode;
    private int numberOfEntries;
    public LinkedList()
    {
        firstNode = null;
        numberOfEntries = 0;
    }
    private class Node 
    {
        private T    data;
        private Node next;
        private Node(T dataPortion) { // can never instantiate that class
            this(dataPortion, null);
        }
        private Node(T dataPortion, Node nextNode) { // this is used to have two different constructors
            this.data = dataPortion;
            this.next = nextNode;
        }
    }
}