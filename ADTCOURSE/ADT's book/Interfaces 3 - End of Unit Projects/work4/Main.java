public class Main {
    public static void main(String[] args) {
        FractionInterface frac1 = new Fraction(1, 2);
        FractionInterface frac2 = new Fraction(5, 1);
        FractionInterface answer = frac1.addFraction(frac2);
        System.out.println(answer.toString());
    }
}
