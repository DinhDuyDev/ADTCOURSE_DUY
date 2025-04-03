/**
 * Garden is a simulation of an actual garden that instantiates plants, waters them,
 * and displays them. (Add details if you change things about the class)
 * Look at the lab description for details about what to do with the Garden class.
 */
import java.util.ArrayList;

public class Garden {
    public static void main(String[] args) {
        ArrayList<Plant> Plants = new ArrayList<>();
        Plants.add(new Carrot());
        Plants.add(new Spinach());
        for (int i=0; i<25; i++) {
            for (int j=0; j<Plants.size(); j++) {
                Plants.get(j).elapseDay();
                System.out.println(Plants.get(j).getStatus());
                System.out.println(Plants.get(j).getWaterLevel());
            }
        }
    }
}
