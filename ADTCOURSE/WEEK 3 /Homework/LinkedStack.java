
/**
* Documentation here
*
*/
public class LinkedStack<T> implements Stack<T> {

    /**
    * Documentation here
    * 
    */
    private class Node {
        private T    data; 
        private Node next; 
    
        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

    } // end Node

    private Node bottomNode;
    public LinkedStack() {
        bottomNode = new Node(null);
    }
    public int size;

    /**
     * Adds an item to the top of this stack.
     * @param item The item to add.
     */
    public void push(T item) {
        Node nodeItem = new Node(item);
        Node curr = bottomNode;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = nodeItem;
        size++;
    }
    
    /**
     * Removes and returns the item from the top of this stack.
     * @return the item at the top of the stack. Returns null if empty.
     */
    public T pop() {
        if (bottomNode.next == null) {
            return null;
        } else {
            Node curr = bottomNode;
            Node prev = curr;
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            size--;
            return curr.data;
        }
    }
    
    /**
     * Returns the item on top of the stack, without removing it.
     * @return the item at the top of the stack. Returns null if empty.
     */
    public T peek() {
        if (bottomNode.next == null) {
            return null;
        } else {
            Node curr = bottomNode;
            while (curr.next != null) {
                curr = curr.next;
            }
            return curr.data;
        }
    }
    
    /** 
     * Returns whether the stack is empty. 
     * @return true if the stack is empty; false otherwise
     */
    public boolean isEmpty() {
        if (bottomNode.next == null)  { return true; }
        return false;
    }
    
    /** 
     * Removes all items from the stack. 
     */
    public void clear() {
        bottomNode.next = null;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Hello there!");
        stack.push("How's your day?");
        stack.push("Are you okay?");
        System.out.println(stack.peek());
        System.out.println(stack.size);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
