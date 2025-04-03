package New_Version;

public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    private int size = 0;

    public LinkedList() {
        this.head = this.tail = new Node<>(null);
        this.head.setLink(tail);
    } // end constructor 

    /**
     * Adds a new element to the head of the linked list and increment the size variable
     * @param element the new element to be added
     */
    public void add(T element) {
        Node<T> addNode = new Node<>(element);
        Node<T> formerHeadNode = this.head.getLink();
        this.head.setLink(addNode);
        addNode.setLink(formerHeadNode);
        size++;
    } // end add

    private Node<T> getNodeAt(int index) {
        int i = -1; 
        Node<T> curr = this.head;
        while (i < index) {
            curr = curr.getLink();
            i++;
        }
        return curr;
    }

    /**
     * Adds an element at a specified index 
     * @param index int value
     * @param element element to be added
     */
    public void add(int index, T element) {
        Node<T> nodeAtIndex = getNodeAt(index);
        Node<T> nodeAdd = new Node<>(element);
        Node<T> prevNode = getNodeAt(index-1);
        if (index > size) {
            System.err.println("Index is out of range.");
            return;
        } else {
            prevNode.setLink(nodeAdd);
            nodeAdd.setLink(nodeAtIndex);
            size++;
        }
    }

    /**
     * Adds all the elements of another list to this one
     * @param listAdd
     */
    public void combine(LinkedList<T> listAdd) {
        Node<T> curr = listAdd.head;
        while (curr.getLink().getElement() != null) {
            this.add(curr.getLink().getElement());
            curr = curr.getLink();
        }
    } // end combine

    /**
     * Returns the size of the linked list 
     * @return integer value of the linked list's size
     */
    public int getSize() {return size;}

    /**
     * Displays the linked list in string form
     * @return String version of the linked list, with ">" as a delineator
     */
    public String toString() {
        Node<T> currNode = head.getLink();
        String returnedString = "";
        while (currNode != this.tail) {
            if (currNode.getLink() != this.tail) {
                returnedString = returnedString + currNode.getElement() + " > ";
            } else {
                returnedString = returnedString + currNode.getElement();
            }
            currNode = currNode.getLink();
        }
        return returnedString;
    } // end toString

    public static void main(String[] args) {
        LinkedList<String> greetingList = new LinkedList<>();
        LinkedList<String> byeList = new LinkedList<>();

        greetingList.add("Hi!");
        greetingList.add("Nice");
        greetingList.add("To");
        greetingList.add("Meet");
        greetingList.add("You.");
        greetingList.add(5, "Thanks!");

        byeList.add("Goodbye");
        byeList.add("Dude!");
        byeList.add("See");
        byeList.add("You");
        byeList.add("Tomorrow.");

        greetingList.combine(byeList);
        System.out.println(greetingList.toString());
    } // end main

} // end LinkedList
