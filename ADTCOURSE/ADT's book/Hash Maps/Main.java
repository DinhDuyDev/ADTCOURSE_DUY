import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<>();

        // adding entries to this object
        capitalCities.put("United Kingdom", "London");
        capitalCities.put("Vietnam", "Hanoi");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Russia", "Moscow");
        capitalCities.put("USA", "Washington DC");
        capitalCities.put("Norway", "Oslo");
        System.out.println(capitalCities);
        
        System.out.println(capitalCities.get("United Kingdom"));

        for (String i : capitalCities.values()) {
            System.out.println(i);
        }
    }
}