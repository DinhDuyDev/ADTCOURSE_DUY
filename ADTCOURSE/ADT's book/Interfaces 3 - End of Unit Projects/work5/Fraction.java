public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;

    private int gcd(int int1, int int2) {
        int result=1;
        int startingpoint;
        if (int1 > int2) startingpoint = int1; else startingpoint = int2;
        for (int i=startingpoint; i>0; i--) {
            if ((int1 % i == 0) && (int2 % i == 0)) {
                result = i;
                break;
            }
        }
        return result;
    }
    public MixedNumberInterface ConvertToMixedNumber() {
        int realp = (int) (numerator / denominator);
        if (realp == 0) {
            throw new Error("The numerator is smaller than a denominator");
        }
        int num = (int) (numerator % denominator);
        return new MixedNumber(realp, num, denominator, MathFunctions.sign(realp));
    }

    public Fraction(int num, int den) {
        if (den == 0) {
            throw new Error("Error: Denominator cannot be zero");
        } else {
            numerator = num / gcd(num, den);
            denominator = den / gcd(num, den);
            if (numerator < 0 && denominator < 0) {
                numerator = Math.abs(numerator);
                denominator = Math.abs(denominator);
            }
        }
    }

    public int returnNumerator() {
        return numerator;
    }
    public int returnDenominator() {
        return denominator;
    }
    public FractionInterface add(FractionInterface otherFrac) {
        int num = otherFrac.returnNumerator();
        int dem = otherFrac.returnDenominator();
        int answernum = numerator * dem + denominator * num;
        int answerdem = dem * denominator;
        return new Fraction(answernum, answerdem);
    }
    public FractionInterface subtract(FractionInterface otherFrac) {
        int num = otherFrac.returnNumerator();
        int dem = otherFrac.returnDenominator();
        int answernum = numerator * dem - denominator * num;
        int answerdem = dem * denominator;
        return new Fraction(answernum, answerdem);
    }
    public FractionInterface multiply(FractionInterface otherFrac) {
        int num = otherFrac.returnNumerator();
        int dem = otherFrac.returnDenominator();
        int answernum = numerator * num;
        int answerdem = denominator * dem;
        return new Fraction(answernum, answerdem);
    }

    public FractionInterface divide(FractionInterface otherFrac) {
        int num = otherFrac.returnNumerator();
        int dem = otherFrac.returnDenominator();
        int answernum = numerator * dem;
        int answerdem = denominator * num;
        return new Fraction(answernum, answerdem);
    }
    public Fraction findReciprocal() {
        return new Fraction(denominator, numerator);
    }
    public boolean greater(FractionInterface otherFrac) {
        int num = otherFrac.returnNumerator();
        int dem = otherFrac.returnDenominator();
        int thisNum = numerator * dem;
        int otherNum = denominator * num;
        return thisNum > otherNum;
    }
    public boolean smaller(FractionInterface otherFrac) {
        int num = otherFrac.returnNumerator();
        int dem = otherFrac.returnDenominator();
        int thisNum = numerator * dem;
        int otherNum = denominator * num;
        return thisNum < otherNum;
    }
    public boolean equal(FractionInterface otherFrac) {
        int num = otherFrac.returnNumerator();
        int dem = otherFrac.returnDenominator();
        return num == numerator && dem == denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
