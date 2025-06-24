import java.util.Comparator;

//import java.lang.Math;
public class CountryComparator implements Comparator<Country> {
    private String indicator;

    public CountryComparator(String ind) {
        this.indicator = ind;
    }

    public int compare(Country a, Country b) {
        double aStat = a.getStat(indicator);
        double bStat = b.getStat(indicator);
        return (int) (Math.signum(aStat - bStat));
    }
}