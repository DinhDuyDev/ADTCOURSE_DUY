import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CountryDisplayer {
    //instance variables up here!
    ArrayList<Country> countries;
     
    /**
     * Read the country file and load the countries into this instance of CountryDisplayer.
     * @param fileName
     */
    public CountryDisplayer(String fileName) {
        countries = new ArrayList<>();
        File inputFile = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch(FileNotFoundException e) {
            System.err.println(e);
            System.exit(1);
        }
        String header = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String nextString = scanner.nextLine();
            Country newCountry = new Country(nextString, header);
            countries.add(newCountry);
        }
        scanner.close();
    }
 

    /**
     * Returns the country with the name matching the argument
     * @param name Name of the country
     */
    public Country getCountryByName(String name) {
        for (Country country : countries) {
            if (country.getName().equals(name)) {
                return country;
            }
        }
        return null;
    }

     /**
     * Insert documentation here!
     */
    public Country getCountryMaxIndicator(String indicator) {
        Country max = countries.get(0);
        for (Country country : countries) {
            Double currStat = Double.parseDouble(max.stats.get(indicator));
            Double countryStat = Double.parseDouble(country.stats.get(indicator));
            if (currStat < countryStat) {
                max = country;
            }
        }
        return max;
    }
     
    public static void main(String[] args) {
        // If there's no command-line argument, print a usage statement 
        // and exit. Otherwise, use args[0] as the input file path.
        if (args.length == 0) {
           System.out.println("Program exit");
           System.exit(1);
        }

        //Construct a CountryDisplayer and call the methods you defined 
        //above to load, process, and display the countries
        CountryDisplayer countryStats = new CountryDisplayer(args[0]);
        Scanner scanner = new Scanner(System.in);
        String input;
        if (args[1].equals("name")) {
            System.out.println("Name of the country?");
            input = scanner.nextLine();
            Country getCountry = countryStats.getCountryByName(input);
            System.out.println("What specific statistic do you want to get?");
            input = scanner.nextLine();
            Double statistic = getCountry.getStat(input);
            System.out.println(getCountry.getName() + "'s " + input + " is: " + statistic);
        } else if (args[1].equals("max")) {
            System.out.println("What indicator would you like to have the information for?");
            input = scanner.nextLine();
            Country geCountry = countryStats.getCountryMaxIndicator(input);
            System.out.println(geCountry.getName());
        }
        scanner.close();
    }
}