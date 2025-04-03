public class Link<T> {
    private T data;
    private Link<T> nextLink;

    public Link(T addedData) 
    {
        data = addedData;
    }
    /**
     * Returning the data of the 
     * @return
     */
    public T element() 
    {
        return data;
    }

    /**
     * Setting the next node
     * @param next
     */
    public void setNext(Link<T> next) {
        nextLink = next;
    }

    public T getNext() 
    {
        return nextLink;
    }
}
