import java.util.HashMap;

public class Country {
    HashMap<String, String> stats = new HashMap<String, String>();

    public Country(String in) {
        String[] splitline = in.split(",");
        stats.put("Name", splitline[0]);
        stats.put("Population Total", splitline[1]);
        stats.put("CO2 Emissions", splitline[2]);
        stats.put("Access To Electricity", splitline[3]);
        stats.put("Renewable Energy", splitline[4]);
        stats.put("Protected Areas", splitline[5]);
        stats.put("Population Growth", splitline[6]);
        stats.put("Urban Population Growth", splitline[7]);
    }

    public double getStat(String indicator) {
        return Double.parseDouble(stats.get(indicator));
    }

    public String getName() {
        return stats.get("Name");
    }

}
