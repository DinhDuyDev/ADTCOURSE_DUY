public class Stack {

    private class Node {
        int data;
        Node next;
        private Node(int d, Node n) {
            data = d;
            next = n;
        }
    }
    public Node front = new Node(0, null);
    public void add(int data) {
        Node head = front;
        Node nodeAdd = new Node(data, null);
        while (head.next != null) {
            head = head.next;
        }
        head.next = nodeAdd;
    }

    public int remove() {
        int retVal;
        Node head = front;
        Node previous = front;
        while (head.next != null) {
            previous = head;
            head = head.next;
        }
        retVal = head.data;
        previous.next = null;
        return retVal;
    }

    public void printStack() {
        Node head = front.next;
        while (head != null) {
            System.out.print(head.data + " - ");
            head = head.next;
        }
        System.out.println("");
    }

    public int get() {
        Node head = front;
        while (head.next != null) {
            head = head.next;
        }
        if (head == front) {
            return 0;
        }
        return head.data;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.printStack();
        stack.remove();
        stack.remove();
        stack.remove();
        stack.remove();
        stack.remove();
        stack.remove();
        stack.remove();
        stack.printStack();
    }
}
