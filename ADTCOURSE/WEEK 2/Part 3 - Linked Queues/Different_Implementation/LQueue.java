package Different_Implementation;

import java.util.Queue;

//http://opendsa-server.cs.vt.edu/OpenDSA/Books/CS2/html/QueueLinked.html
//https://www.geeksforgeeks.org/queue-linked-list-implementation/


public class LQueue<T> implements Queue<T> {
    private Link<T> front;
    private Link<T> end;
    private int size;

    public LQueue() {init();}
    public LQueue(T firstNode) {init(firstNode);}

    public void init() 
    {
        front = end = new Link<T>(null);
        size = 0;
    }

    /**
     * Adding an element to the end of the queue
     * @return False if cannot add more 
     */
    public boolean enqueue(T nodeData) 
    {
        Link<T> addedNode = new Link<T>(nodeData);
        end.nextLink(addedNode);
        end = addedNode;
        size ++;
        return true;
    }

    public Node<T> dequeue() 
    {
        if (size == 0) 
        {
            return null;
        }
        T it = front.getNext().element();
        front.setNext(front.getNext().getNext());
        if (front.next() == null) {end = front;}
        size --;
        return it;
    }

    public T frontValue() 
    {
        if (size == 0) {return null;}
        return front.getNext().element();
    }

    public boolean isEmpty() {return size == 0;}
 }
