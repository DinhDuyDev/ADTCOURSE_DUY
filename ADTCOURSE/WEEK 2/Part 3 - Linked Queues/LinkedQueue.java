import java.util.ArrayList;

/**
* A class that implements a linked structure.
Acknowledgements: Uses the node class and method descriptions provided by Data Structures and Abstractions with Java by Frank M. Carrano, Timothy M. Henry
*/
public class LinkedQueue<T> {
    Node<T> front = null;//or head
    Node<T> end = null;//or tail

    /** Add a node item to the end of the linked queue
     * 
     * @param newItem Item of reference type T 
     * @return end node
     */
    public void enqueue(T newItem) {

        // Create a new node
        Node<T> newNode = new Node<>(newItem);

        // If the queue is initially empty, the new node is both the front and the end of the queue
        if (end == null) {
            end = newNode;
            front = newNode;
        } else {
            // Creating a new node, setting the next to that node, and the end to the new node
            end.next = newNode;
            end = newNode;
        }
    }

    /**
     * Removes the front node from the queue, and returns the front node
     * @return the front node
     */
    public Node<T> dequeue() {
        if (this.isEmpty()) {
            return null;
        }
        Node<T> frontNode = front;
        if (front != null) {
            if (front.next == end) {
                front = end;
                end = null;
            } else {
                front = front.next;
            }
            return frontNode;
        }
        return null;
    }

    public boolean isEmpty() {
        if (front == null && end == null) {
            return true;
        }
        return false;
    }

    public int getSize(int currentSize, Node<T> nodeItem) {
        if (nodeItem != null) {
            currentSize ++;
            return getSize(currentSize, nodeItem.next);
        } else {
            return currentSize;
        }
    }
    public String toString(Node<T> front, String inputString) {
        if (front == null) {
            inputString += "";
            return inputString;
        } else {
            inputString += front.data + ", ";
            return toString(front.next, inputString);
        }
    } 

    public static void main(String[] args) {
        LinkedQueue<Integer> integerQueue = new LinkedQueue<>();

        integerQueue.enqueue(4);
        integerQueue.enqueue(1);
        integerQueue.enqueue(1);
        integerQueue.enqueue(10);
        integerQueue.enqueue(1);
        integerQueue.enqueue(22);
        integerQueue.enqueue(1);
        integerQueue.enqueue(34);
        integerQueue.enqueue(16);


        integerQueue.dequeue();
        integerQueue.dequeue();
        integerQueue.dequeue();
        integerQueue.dequeue();
        integerQueue.dequeue();
        integerQueue.dequeue();
        integerQueue.dequeue();

        
        System.out.println(integerQueue.getSize(0, integerQueue.front));
        System.out.println(integerQueue.toString(integerQueue.front, ""));
    }
}