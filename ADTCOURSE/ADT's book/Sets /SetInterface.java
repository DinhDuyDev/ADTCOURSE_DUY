/** An interface that describes the operation of a set of objects */
public interface SetInterface<T> {
    /** Gives the current number of objects that are inside the Set
     * 
     * @return returns integer value of the number of objects inside a set
     */
    public int getCurrentSize();
    /** Gives whether the set is empty or not 
     * 
     * @return returns whether the set is empty or not
     */
    public boolean isEmpty();
    /** Adds a new entry to the set, if possible
     * 
     * @param newEntry - The object to added as the new entry
     * @return True if addition is successful / False if addition is unsuccessful (encounter an object that is the same as that object)
     */
    public boolean add(T newEntry);
    public T remove();
    public void clear();
    public boolean contains(T anEntry);
    public T[] toArray();
} // end SetInterface