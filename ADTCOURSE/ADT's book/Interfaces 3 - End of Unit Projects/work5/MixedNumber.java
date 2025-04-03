public class MixedNumber implements MixedNumberInterface {
    private int realPart;
    private int numerator;
    private int denominator;

    public FractionInterface ConvertToFraction() {
        int num = realPart * denominator + numerator;
        return new Fraction(num, denominator);
    }

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
    
    public MixedNumber(int realp, int num, int den, int sn) {
        /*
         * Only allowing the real part to have a sign
         */

        realPart = realp * sn;

        /*
         * Making everything absolute to help with converting to fractions
         */
        num = Math.abs(num);
        den = Math.abs(den);

        /*
         * Making sure that the fraction numbers are reduced
         */
        numerator = num / gcd(num, den);
        denominator = den / gcd(num, den);
    } // end parametrized constructor

    public int returnReal() {
        return realPart;
    }

    public String toString() {
        return Integer.toString(realPart) + "[" + Integer.toString(numerator) + "/" + Integer.toString(denominator) + "]";
    }
    public MixedNumberInterface add(MixedNumberInterface otherMixedNumber) {
        FractionInterface fractionVer = ConvertToFraction();
        FractionInterface otherFraction = otherMixedNumber.ConvertToFraction();

        FractionInterface resultantFraction = fractionVer.add(otherFraction);
        MixedNumberInterface resultMixed = resultantFraction.ConvertToMixedNumber();
        return resultMixed;
    }

    public MixedNumberInterface subtract(MixedNumberInterface otherMixedNumber) {
        FractionInterface fractionVer = ConvertToFraction();
        FractionInterface otherFraction = otherMixedNumber.ConvertToFraction();

        FractionInterface resultantFraction = fractionVer.subtract(otherFraction);
        MixedNumberInterface resultMixed = resultantFraction.ConvertToMixedNumber();
        return resultMixed;
    }
}
