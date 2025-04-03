package Pair_Example;
public class UsePair {
    public static void main(String[] args) {
        Pairable<Integer> integerPair = new OrderedPair<>(1, 10);
        integerPair.changeOrder();
        System.out.println(integerPair.getFirst());

        integerPair.changeOrder();
        System.out.println(integerPair.toString());
        integerPair.changeOrder();
        System.out.println(integerPair.toString());
    }
}
