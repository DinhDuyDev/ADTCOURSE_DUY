public class PiggyBank<T> {
    private BagInterface<T> coinEntries;
    public PiggyBank() {
        this.coinEntries = new Bag<>();
    }
    public boolean add(Coin aCoin) {
        return coinEntries.add(aCoin);
    } // end add

    public Coin remove() {
        return coinEntries.remove();
    } // end remove

    public boolean isEmpty() {
        return coinEntries.isEmpty();
    } // end isEmpty
} // end PiggyBank