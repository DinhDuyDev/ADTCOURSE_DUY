public interface PiggyBankInterface {
    /** Adding a coin object to the piggy bank
     * 
     * @param aCoin a new coin entry into the piggy bank.
     * @return whether the addition is successful or not
     */
    public boolean add(Coin aCoin);
    /** Removing a random coin from the piggy bank
     * 
     * @return the coin object that is removed
     */
    public Coin remove();
}
 