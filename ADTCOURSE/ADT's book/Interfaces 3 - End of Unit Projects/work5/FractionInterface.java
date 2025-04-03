public interface FractionInterface {
    /**
     * 
     * @return a mixed number version (if numerator > denominator)
     */
    public MixedNumberInterface ConvertToMixedNumber();
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
    public FractionInterface add(FractionInterface otherFrac);
    /** subtracting a fraction
     * 
     * @param fraction1
     * @param fraction2
     * @return FractionInterface
     */
    public FractionInterface subtract(FractionInterface otherFrac);
    /** multiplying a fraction
     * 
     * @param fraction1
     * @param fraction2
     * @return FractionInterface
     */
    public FractionInterface multiply(FractionInterface otherFrac);
    /** dividing a fraction
     * 
     * @param fraction1
     * @param fraction2
     * @return FractionInterface 
     */
    public FractionInterface divide(FractionInterface otherFrac);

    public Fraction findReciprocal();

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