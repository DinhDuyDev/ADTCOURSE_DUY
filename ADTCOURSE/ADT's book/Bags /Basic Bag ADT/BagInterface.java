public interface BagInterface <T> {
    /** Checks the number of objects inside the bag
     * No parameter
     * @return integer number of the number of objects currently inside the bag
     */
    public int getCurrentSize();
    /** Checks whether the bag is empty or not
     * No parameter
     * @return whether the bag has any objects or not (in the form of a boolean value)
     */
    public boolean isEmpty();
    /** Used to add a new element / item to the bag.
     * 
     * @param newEntry - this entry MUST be in datatype T
     * @return a boolean to indicate whether the addition succeeds. If the boolean is false, then the bag is already full and no more elements could be added
     */
    public boolean add(T newEntry);
    /** Remove a random element from the bag
     * No paremeter
     * @return the object of datatype T which belonged in the bag.
     */
    public T remove();
    /** Remove a specific element from the bag
     * 
     * @param anEntry - a specific object that would need to be removed from the bag, must be in datatype T
     * @return the object that is to be removed from the bag.
     */
    public boolean remove(T anEntry);
    // Clear the entire bag off elements.
    public void clear();
    /** Getting the number of times an object appears inside a bag (because bags allow for duplicates)
     * 
     * @param anEntry - this object must be a specific object with type T
     * @return the number of times the item is duplicated inside the bag
     */
    public int getFrequencyOf(T anEntry);
    /** Seeing if the bag contains a specific object
     * 
     * @param anEntry
     * @return True if specific item in bag, False if not
     */
    public boolean contains (T anEntry);
    /** Returns full list of items in bag. If the bag is empty, then return an empty array.
     * 
     * @return return array of items in bag
     */
    public String toArray();
    /** Returns a union of an object with another 
     * 
     * @param anEntry
     * @return a Bag object that is the union of another object with the object receiving the method
     */
    public BagInterface<T> union(BagInterface<T> anEntry);
    /** Finds the overlapping elements inside a bag
     * 
     * @param anEntry - the bag that the caller of the method wants to find the intersection with
     * @return a BagInterface type value containing the intersection between the two objects
     */
    public BagInterface<T> intersection(BagInterface<T> anEntry);

} // end BagInterface