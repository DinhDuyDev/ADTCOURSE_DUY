package New_Version;

public class Node<T> {
    private T       element; // data element
    private Node<T> link; // link to the next node

    public Node() {this.element = null;} // end default constructor
    public Node(T elementAdd) {this.element = elementAdd;} // end parametrized constructor 

    /**
     * Sets the link to the next node
     * @param linkNode Node<T> of the next link
     */
    public void setLink(Node<T> linkNode) {this.link = linkNode;} 

    /**
     * Get the link to the next node
     * @return the next node
     */
    public Node<T> getLink() {return link;}

    /**
     * Get the element inside the node
     * @return generic type T of the element
     */
    public T getElement() {return element;}
} // end Node<T>
