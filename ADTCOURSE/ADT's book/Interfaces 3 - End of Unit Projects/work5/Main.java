public class Main {
    public static void main(String[] args) {
        MixedNumberInterface mn1 = new MixedNumber(10, 6, 8, 1); //(3, 1, 0, "-");
        MixedNumberInterface mn2 = new MixedNumber(10, 1, 10, 1); //(3, 1, 0, "-");
        MixedNumberInterface mn3 = mn1.add(mn2);
        System.out.println(mn1.toString());
    }
}
