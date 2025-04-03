public class Animal {
    private int happiness;
    private int age;

    /** Constructor for class animal
     * 
     * @param Age
     * @param Happiness
     */

    public Animal (int Age, int Happiness) {
        happiness = Happiness;
        age = Age;
    } // end parametrized constructor 

    /** Setting the age for the animal
     * 
     * @param Age // age > 0
     */
    public void setAge(int Age) {
        age = Age;
    }
    /** Setting the happiness for the animal
     * 
     * @param Happiness
     */
    public void setHappiness(int Happiness) {
        happiness = Happiness;
    }
    /** Getting the age 
     * 
     * @return age > 0
     */
    public int getAge() {
        return age;
    }
    /** Getting the happiness
     * 
     * @return getting the happiness
     */
    public int getHappiness() {
        return happiness;
    }
    /**
     * Printing the status
     */
    public void printStatus() {
        System.out.println("Status: Still an animal.");
    }
    /**
     * Petting the animal
     */
    public void pet() {
        System.out.println("Petting the general animal!");
    }
}