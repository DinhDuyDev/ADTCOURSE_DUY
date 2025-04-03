import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Die.java
 * Jeff Ondich, Carleton College, 2014-01-05
 * Modified: Anna Rafferty
 *
 * A simple class representing an n-sided die (as used in various board games).
 * 
 * After running this class, make a variable that represents a 9-sided die, and
 * then print out the result of rolling it. Which lines in the file represent the 
 * constructor for the die object?
 *
 * This is the Java half of a pair of parallel examples in Python and Java.
 * See die.py.
 */
public class NewDie {
    // These are the instance variables (like the "self.*" stuff in Python)
    private int numberOfSides;
    private int value;
    private Random randomNumberGenerator;

    public NewDie(int n) {
        numberOfSides = n;
        value = 1;
        randomNumberGenerator = new Random();
    }

    public void roll() {
        value = randomNumberGenerator.nextInt(numberOfSides) + 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }

    // This main program is run only when Die is executed as a program
    // in its own right ("java Die"). If a different .java file imports
    // Die for its own purposes, then main won't get executed.
    public static void main(String[] args) {
        // Let's play Yahtzee
        List<NewDie> dice = new ArrayList<NewDie>();
        Scanner INPUT = new Scanner(System.in);
        Integer newInt = INPUT.nextInt();
				
        int total_index = 0;

        dice.add(new NewDie(6));
        dice.add(new NewDie(6));
        dice.add(new NewDie(6));
        dice.add(new NewDie(6));
        dice.add(new NewDie(6));

        int total = 0;
        while (total_index < 5) {
		    newInt = INPUT.nextInt();
            for (int i=0; i<newInt; i++) {
                System.out.format("%d ", dice.get(total_index).getValue());
                total += dice.get(total_index).getValue();
                total_index++;
		    }
        }
        System.out.format("\nTotal: %d\n", total);

        if(dice.get(0).getValue() == dice.get(1).getValue() &&
           dice.get(1).getValue() == dice.get(2).getValue() &&
           dice.get(2).getValue() == dice.get(3).getValue() &&
           dice.get(3).getValue() == dice.get(4).getValue()) {
            System.out.println("Yahtzee!");
        }
        INPUT.close();
    }
}
