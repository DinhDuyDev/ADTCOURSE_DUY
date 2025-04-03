import java.util.ArrayList;
import java.util.List;
public class Temporary {
    public static void main(String[] args) {

        BagInterface<String> groceryBag = new Bag<>();
        groceryBag.add("soup");
        groceryBag.add("grapes");
        groceryBag.add("rice");
        groceryBag.add("soup");
        groceryBag.add("soup");
        groceryBag.add("cat food");
        groceryBag.add("grapes");
        groceryBag.add("soup");
        groceryBag.add("soup");
        groceryBag.add("cat food");

        // int numberOfSoup = 0;
        // while (groceryBag.contains("soup")) {
        //     groceryBag.remove("soup");
        //     numberOfSoup ++;
        // }
        // System.out.println(groceryBag.toArray());
        // System.out.println(numberOfSoup);
        
        List<String> getArray = new ArrayList<String>();
        List<String> distinctArray = new ArrayList<String>();
        while (!groceryBag.isEmpty()) {
            String removedEntry = groceryBag.remove();
            getArray.add(removedEntry);
        }
        for (int i=0; i<getArray.size(); i++) {
            if (!distinctArray.contains(getArray.get(i))) {
                distinctArray.add(getArray.get(i));
            }
            groceryBag.add(getArray.get(i));
        }
        // System.out.println(distinctArray);
        // System.out.println(groceryBag.toArray());
    }
}