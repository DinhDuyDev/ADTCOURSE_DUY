public class Dog extends Animal {
    private int happiness;
    /** Constructor for Dog class
     * 
     * @param Age
     * @param Happiness
     */
    public Dog(int Age, int Happiness) {
        super(Age, Happiness);
    }
    /** Setting the happiness specifically for the dog object
     * 
     * @param Happiness
     */
    public void setHappinessDog(int Happiness) {
        happiness = Happiness;
    }
    /** Getting the happiness 
     * 
     * @return happiness
     * {@code hello()} is used to print out hello world string
     * {@link java.lang.NullPointerException}
     */

    public int getHappinessDog() {
        return happiness;
    }
    /** Getting the status
     * 
     */
    public void printStatus() {
        super.printStatus();
    }
    /** Petting the animal
     * 
     */
    @Override
    public void pet() {
        System.out.println("Petting the animal!");
    }
    public static void main(String[] args) {
        // Dog dogInstance = new Dog(1, 100);
        // dogInstance.setHappiness(5);
        // dogInstance.setHappinessDog(10);
        // System.out.println(dogInstance.getHappinessDog());
        Animal test = new Dog(5, 10);
        Dog test2 = new Dog(10, 20);

        test.printStatus();
        test2.printStatus();
    }
}
