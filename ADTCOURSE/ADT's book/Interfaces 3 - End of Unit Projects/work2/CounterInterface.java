package work2;
public interface CounterInterface {
    /** Sets the initial count number - void
     * @param int num 
     * @return void
     */
    public void SetInitialCountNum(int num); // cannot define static methods inside an interface because static methods are for classes
    /** Increases the current count number by one 
     * @return CountNum+1
     */
    public void Increment();
    /** Decreases the current count number by one 
     * @return CountNum-1
     */
    public void Decrement();
    /** Returns the current count number
     * 
     * @return countnum
     */
    public int ReturnCountNum();
    /**
     *
     * @return String count num
     */
    public String ReturnCountNumString();

    /** Tests if count num is zero
     * @return boolean
     */
    public boolean IsCountZero();
}