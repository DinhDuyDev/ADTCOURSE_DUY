public interface MixedNumberInterface extends FractionInterface {
    /** returns the real part of the mixed number
     * 
     * @return real part of the mixed number
     */
    public int returnReal();
    /**
     * 
     * @return fraction version of the instance
     */
    public FractionInterface ConvertToFraction();

    public MixedNumberInterface ConvertToMixedNumber();
}
