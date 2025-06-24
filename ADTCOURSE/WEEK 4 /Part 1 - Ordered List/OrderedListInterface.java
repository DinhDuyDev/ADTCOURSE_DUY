public interface OrderedListInterface {

    /**
     * Adds an element of type T to the end of the list
     * @param item
     */
    public void add(int item);

    /**
     * Removes an element in the list, assuming the element is present inside the list
     * @param item Element to be removed
     * @return True if a value is removed, False if a value is not removed
     */
    public boolean remove(int item);

    /**
     * See if the element is present inside the list
     * @param item element T to be removed
     * @return True if the element is present in the list, False if not
     */
    public boolean search(int item);

    /**
     * See if the list is empty
     * @return True if the list is empty, False if otherwise
     */
    public boolean isEmpty();

    /**
     * Return the size of the list
     * @return size of the list 
     */
    public int size();

    /**
     * Returns the index of the specified element
     * @param item Element to get index for 
     * @return integer value of size
     */
    public int index(int index);

    /**
     * Removes the tail element of the list
     * @return the tail element
     */
    public int pop();

    /**
     * Removes the element at a specified location of the list
     * @param pos position of the element in the list 
     * @return the element
     */
    public int pop(int pos);
}