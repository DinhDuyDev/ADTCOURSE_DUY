import java.util.Arrays;
public class Recursion {
    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 1;
        } else {
            return bunnyEars(bunnies-1) + 2;
        }
    }

    public static int recursive(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            return a * recursive(a, b-1);
        }
    }

    public static void merge(int[] array, int[] temp, int first, int mid, int last) {
        int beginHalf1 = first;
        int endHalf1 = mid;
        int beginHalf2 = mid +1;
        int endHalf2 = last;

        int index = first; // Next available location in tempArray
        // While both subarrays are not empty, compare an entry in one subarray with
        // an entry in the other; then copy the smaller item into the temporary array
        while((beginHalf1 <= endHalf1) && (beginHalf2<=endHalf2)) {
            if (array[beginHalf1] <= array[beginHalf2]) {
                //Place the smaller item in the temp array
                temp[index] = array[beginHalf1];
                beginHalf1++;
            } else {
                temp[index] = array[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        System.out.println("Temp: " + Arrays.toString(temp));
        System.out.println("Array: " + Arrays.toString(array));

        System.out.println("Begin Half 1: " + beginHalf1);
        System.out.println("End Half 1: " + endHalf1);
        //One of the subarrays is now empty, so the rest of the items in the
        // other subarray should go into temp

        int restOfBegin;
        int restOfEnd;
        if(beginHalf1 > endHalf1) {
            restOfBegin = beginHalf2;
            restOfEnd = endHalf2;
        } else {
            restOfBegin = beginHalf1;
            restOfEnd = endHalf1;
        }
       
        //Place the rest of the items from the non-empty subarray into temp    
        while(restOfBegin<=restOfEnd) {
            System.out.println(restOfEnd);
            temp[index] = array[restOfBegin];
            restOfBegin++;
            index++;
        }

        //Copy everything from temp back into array a
        for(int i=first; i<=last; i++){
            array[i] = temp[i];
        }   
    }
    public static void mergesort(int[] array, int[] temp, int start, int end) {
        if (start < end) {
            int middle = start + (end - start)/2;
            mergesort(array, temp, start, middle);
            mergesort(array, temp, middle+1, end);

            merge(array, temp, start, middle, end);
        }
    }
    public static void main(String[] args) {
        System.out.println(Recursion.bunnyEars(2));
        System.out.println(recursive(23, 6));
        int[] arr1 = {1, 7, 9, 8, 10, 5};
        int[] temp = {0, 0, 0, 0, 0, 0};
        Recursion.mergesort(arr1, temp, 0, 5);
        System.out.println("Result: " + Arrays.toString(arr1));
    }
}