import java.util.Arrays;

public class QuickSort {
    public static int MIN_SIZE = 4;
    public void medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[high] < arr[low]) {
            swap(arr, high, low);
        }
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[high] < arr[mid]) {
            swap(arr, high, mid);
        }
    }
    private void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public int partition(int[] arr, int first, int last) {
        boolean done = false;
        this.medianOfThree(arr, first, last);
        int indexFromLeft = first+1;
        int indexFromRight = last-2;
        int mid = first + (last-first) / 2;
        this.swap(arr, mid, last-1);
        int pivotIndex = last-1;
        int pivotValue = arr[pivotIndex];

        // Moving from left
        while (!done) {
            while (arr[indexFromLeft] < pivotValue) {
                indexFromLeft ++;
            }
            while (arr[indexFromRight] > pivotValue) {
                indexFromRight --;
            }
            if (indexFromLeft < indexFromRight) {
                this.swap(arr, indexFromLeft, indexFromRight);
                indexFromLeft ++;
                indexFromRight --;
            } else {
                done = true;
            }
        }
        this.swap(arr, pivotIndex, indexFromLeft);
        pivotIndex = indexFromLeft;
        return pivotIndex;
    }

    public void quickSort(int[] arr, int first, int last) {
        if (last - first + 1 < MIN_SIZE) {
            InsertionSort.insertionSort(arr);
        } else {
            int pivotIndex = partition(arr, first, last);
            quickSort(arr, first, pivotIndex-1);
            quickSort(arr, pivotIndex+1, last);
        }  
    }
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] newArr = {5, 8, 6, 4, 9, 3, 7, 1, 2};
        sort.quickSort(newArr, 0, 8);
        System.out.println(Arrays.toString(newArr));
    }
}