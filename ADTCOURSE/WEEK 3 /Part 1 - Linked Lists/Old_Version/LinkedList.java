package Old_Version;
public class LinkedList<T> {
    private Node<T> head;
    private int size = 0;
    
    // public LinkedList() {
    //     init();
    // }
    // private void init() {
    //     head = new Node<T>(null);
    // }

    /**
     * Add a new element of type T to the list
     * @param element of type T
     */
    public void add(T element) {
        Node<T> elementNode = new Node<>(element);
        Node<T> tempHead = this.head;
        this.head = elementNode;
        if (head != null) {
            this.head.next = tempHead;
        }
        size++;
    }

    /**
     * Returns the node at a certain index 
     * @param index
     * @return Object of type Node<T>
     */ 
    public Node<T> getNodeAt(int index) {
        if (index < 0) {
            return null;
        }
        int i=0;
        Node<T> getNode = head;
        while (i != index) {
            getNode = getNode.next;
            i++;
        }
        return getNode;
    }

    /**
     * Append a node at the designated index
     * @param index index to add the node at 
     * @param element the node element to add
     */
    public void add(int index, T element) { // can actually loop through this entire linked list until you find the correct element and adjust it accordingly
        Node<T> nodeAdd = new Node<>(element);
        if (index > size) { 
            System.err.println("Index is out of range of linked list.");
            return;
        } else if (index == 0) { 
            Node<T> nextNode = head;
            head = nodeAdd;
            head.next = nextNode;
        } else if (index == size) { 
            Node<T> prevNode = getNodeAt(index-1);
            prevNode.next = nodeAdd;
        } else { 
            Node<T> previousNode = getNodeAt(index-1);
            Node<T> getNode = getNodeAt(index);
            previousNode.next = nodeAdd;
            nodeAdd.next = getNode;
        }
    }

    /**
     * Append another linked list to the caller
     * @param list to be linked with the other list.
     */
    public void combine(LinkedList<T> list) {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = list.head;
    }

    public void remove(int index) {
        if (index > size) {
            System.err.println("Index is out of range of list");
            return;
        } else if (index == size) {
            Node<T> prevNode = getNodeAt(index-1);
            prevNode.next = null;
            size--;
        } else if (index > 0) {
            Node<T> prevNode = getNodeAt(index-1);
            Node<T> postNode = getNodeAt(index+1);
            prevNode.next = postNode;
            size--;
        } else if (index == 0) {
            Node<T> headNode = head.next;
            head.next = null;
            head = headNode;
        }
    }

    /**
     * Returns a string representation of the linked list
     * @return String representation of the linked list
     */
    public String toString() {
        Node<T> temp = head;
        String stringVer = "";
        while (temp != null) {
            if (temp.next == null) {
                stringVer += temp.data;
            } else {
                stringVer += temp.data + " > ";
            }
            temp = temp.next;
        }
        return stringVer;
    }

    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        // LinkedList<String> stringList2 = new LinkedList<>();
        stringList.add("Hello");
        stringList.add("It's");
        stringList.add("Nice");
        stringList.add("To");
        stringList.add("Meet");
        stringList.add("You");

        // stringList.add(2, "How are you?");
        for (int i=0; i<20; i++) {
            stringList.remove(0);
        }
        System.out.println(stringList.toString());
    }
}
