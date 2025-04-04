import java.util.HashMap;

public class Country {
    HashMap<String, String> stats = new HashMap<String, String>();

    /**
     * @param String the line with data about the country
     */
    public Country(String line_in, String headings){
        String[] split_data = line_in.split(",");
        String[] split_header = headings.split(",");

        for (int i=0; i<split_header.length; i++) {
            stats.put(split_header[i], split_data[i]);
        }
    }

    /**
     * @param String the indicator to get the data for
     * @return Double the data for the associated indicator
     */
    public Double getStat(String indicator) {
        for (String key : stats.keySet()) {
            if (key.equals(indicator)) {
                String desiredStat = stats.get(key);
                return Double.parseDouble(desiredStat);
            }
        }
        return null;
    }

    /**
     * @return String the name of the Country
     */
    public String getName() {
        return stats.get("Country Name");
    }

}