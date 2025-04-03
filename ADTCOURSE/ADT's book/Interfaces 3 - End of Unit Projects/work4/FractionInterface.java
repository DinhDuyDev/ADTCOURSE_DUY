public interface FractionInterface {

    /** returning the numerator
     * 
     * @return integer value of numerator
     */
    public int returnNumerator();

    /** returning the denominator
     * 
     * @return integer value of denominator
     */
    public int returnDenominator();

    /** adding a fraction
     * 
     * @param fraction1
     * @param fraction2
     * @return FractionInterface
     */
    public FractionInterface addFraction(FractionInterface otherFrac);
    /** subtracting a fraction
     * 
     * @param fraction1
     * @param fraction2
     * @return FractionInterface
     */
    public FractionInterface subtractFraction(FractionInterface otherFrac);
    /** multiplying a fraction
     * 
     * @param fraction1
     * @param fraction2
     * @return FractionInterface
     */
    public FractionInterface multiplyFraction(FractionInterface otherFrac);
    /** dividing a fraction
     * 
     * @param fraction1
     * @param fraction2
     * @return FractionInterface 
     */
    public FractionInterface divideFraction(FractionInterface otherFrac);

    public FractionInterface findReciprocal();

    /** Comparison functions
     * 
     * @param fraction1
     * @param fraction2
     * @return boolean
     */
    public boolean greater(FractionInterface otherFrac);
    public boolean smaller(FractionInterface otherFrac);
    public boolean equal(FractionInterface otherFrac);

    /** returning a string of a fraction
     * 
     * @return string of self fraction
     */
    public String toString();
}