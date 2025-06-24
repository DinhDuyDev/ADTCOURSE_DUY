import java.util.Random;

public class OrderedList implements OrderedListInterface {
    private Node front, end;
    private int size;
    private String order = "ASCENDING";

    /**
     * Initializes an object
     * @param orderType String value for how to order the linked list
     */
    public OrderedList(String orderType) {
        front = end = new Node(0);
        front.setLink(end);
        order = orderType;
    } // end constructor 

    /**
     * @param item a primitive value to be added
     */
    public void add(int item) {
        Node nodeAdd = new Node(item);
        Node curr = front.getLink();
        Node prevNode = front;
        if (order == "ASCENDING") {
            while (nodeAdd.getData() > curr.getData() && curr != end) {
                prevNode = curr;
                curr = curr.getLink();
            }
            prevNode.setLink(nodeAdd);
            nodeAdd.setLink(curr);
            size++;
        } else if (order == "DESCENDING") {
            while (nodeAdd.getData() < curr.getData() && curr != end) {
                prevNode = curr;
                curr = curr.getLink();
            }
            prevNode.setLink(nodeAdd);
            nodeAdd.setLink(curr);
            size++;
        }
    } // end add

    /**
     * Returns String representation of the linked list
     * @return String representation of the linked list
     */
    public String toString() {
        String stringForm = "";
        Node curr = front.getLink();
        while (curr != end) {
            String delineate = ", ";
            if (curr.getLink() == end) {delineate = "";}
            stringForm += curr.getData() + delineate;
            curr = curr.getLink();
        }
        return stringForm;
    }
    
    /**
     * Removes an item from the ordered list
     * @param item integer value held by node that is to be removed
     * @return True if an item is removed, False if an item isn't removed
     */
    public boolean remove(int item) {
        Node curr = front.getLink();
        Node prevNode = front;
        while (curr != end) {
            if (curr.getData() == item) {
                prevNode.setLink(curr.getLink());
                curr.setLink(null);
                return true;
            } else {
                prevNode = curr;
                curr = curr.getLink();
            }
        }
        return false;
    }

    /**
     * Searches for a specific item inside the ordered linked list
     * @param item integer value of item to be searched for 
     * @return True if there exists the given item inside the ordered linked list, False if there isn't
     */
    public boolean search(int item) {
        Node curr = front.getLink();
        while (curr != end) {
            if (curr.getData() == item) {
                return true;
            } else {
                curr = curr.getLink();
            }
        }
        return false;
    }

    /**
     * Checks if the ordered linked list is empty or not.
     * @return True if the linked list is empty, False if not
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } 
        return false;
    }

    /**
     * Returns the size of the ordered linked list
     * @return int value of size
     */
    public int size() {
        int size = 0;
        Node curr = front.getLink();
        while (curr != end) {
            size ++;
            curr = curr.getLink();
        }
        return size;
    }

    /**
     * Returns the index of the desired item
     */
    
    public int index(int index) {
        Node curr = front;
        int ind = 0;
        while (curr.getData() != index &&  curr != null) {
            curr = curr.getLink();
            ind ++;
        }
        return ind;
    }

    public int pop() {
        Node prevNode = front;
        Node curr = front.getLink();
        while (curr.getLink() != end) {
            prevNode = curr;
            curr = curr.getLink();
        }
        prevNode.setLink(end);
        size--;
        return curr.getData();
    }

    public int pop(int pos) {
        if (size == 0) {
            throw new Error("Index out of range");
        }
        Node curr = front.getLink();
        Node prevNode = front;
        if (pos > size-1) {
            throw new Error("Index out of range");
        }
        for (int i=0; i<pos; i++) {
            prevNode = curr;
            curr = curr.getLink();
        }
        prevNode.setLink(curr.getLink());
        size --;
        return curr.getData();
    }

    public static void main(String[] args) {
        OrderedList numberList = new OrderedList("DESCENDING");
        numberList.add(2239);
        numberList.add(1020);
        numberList.add(1300);
        numberList.add(7239);
        numberList.add(2235);
        numberList.add(1299);
        numberList.add(4350);

        System.out.println("String Form: " + numberList.toString());
        System.out.println(numberList.pop(2));
        System.out.println(numberList.pop(2));
        System.out.println(numberList.pop(2));
        System.out.println(numberList.pop(2));
        System.out.println(numberList.pop(2));
        System.out.println(numberList.pop(2));

        System.out.println("String Form: " + numberList.toString());
    }
}