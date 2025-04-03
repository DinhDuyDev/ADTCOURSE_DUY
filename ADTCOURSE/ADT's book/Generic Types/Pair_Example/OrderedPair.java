package Pair_Example;
public class OrderedPair<T> implements Pairable<T> {
    private T first, second;
    public OrderedPair(T firstVal, T secondVal) {
        first = firstVal;
        second = secondVal;
    } // end parametrized constructor 

    /* Returns the first element of the pair */
    public T getFirst() {
        return first;
    } // end getFirst

    /* Returns the second element of the pair */
    public T getSecond() {
        return second;
    } // end getSecond

    /* Changes the order of the pair */
    public void changeOrder() {
        T temp = first;
        first = second;
        second = temp;
    } // end changeOrder

    /* Returns the string representation of this pair */
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
