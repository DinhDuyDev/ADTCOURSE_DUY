package Generic_Function;

public class Search {
    /** Returns the index of a searched element
     * 
     * @param <T>
     * @param arr
     * @param target
     * @return index number if found, -1 if not found
     */
    public static <T> int search(T[] arr, T target) {
        int index = 0;
        for (int i=0; i<arr.length; i++) {
            index++;
            if (target == arr[i]) {
                break;
            }
        }
        return (index != arr.length) ? index : -1;
    }
    
    public static void main(String[] args) {
        Integer[] arrInt = {2, 8, 1, 2, 3, 5, 6, 9, 1, 2, 2}; // Integer is the input into the type parameter 
        String[] arrString = {"Hello", "mEWO", "nICE TO meet you", "Wh'atsUppp"};
        System.out.println("The number 9 is found at index " + search(arrInt, 9));
        System.out.println("The string 'meow' is found at index " + search(arrString, "meow"));
    }
}
