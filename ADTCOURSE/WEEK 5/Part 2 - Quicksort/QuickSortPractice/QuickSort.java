import java.util.Arrays;

public class QuickSort {
    public int medianOfThree(int[] arr, int first, int last) {
        int mid = first + (last - first) / 2;
        if (arr[mid] < arr[first]) {
            swap(arr, first, mid);
        } else if(arr[last] < arr[mid]) {
            swap(arr, last, mid);
        } else if (arr[first] > arr[last]) {
            swap(arr, first, last);
        }
        return mid;
    }
    private int partition(int arr[], int first, int last) {
        this.medianOfThree(arr, first, last);
        int indexFromLeft = first+1;
        int indexFromRight = last-2;
        int mid = first + (last - first) / 2;
        this.swap(arr, mid, last-1);
        int pivotIndex = last-1;
        int pivotValue = arr[pivotIndex];

        boolean done = false;

        while (!done) {
            while (arr[indexFromLeft] < pivotValue) {
                indexFromLeft ++;
            } 

            while (arr[indexFromRight] > pivotValue) {
                indexFromRight --;
            }

            if (indexFromLeft < indexFromRight) {
                swap(arr, indexFromLeft, indexFromRight);
                indexFromLeft ++;
                indexFromRight --;
            } else {
                done = true;
            }
        }
        swap(arr, indexFromLeft, pivotIndex);
        pivotIndex = indexFromLeft;
        return pivotIndex;
    }
    public void quicksort(int arr[], int first, int last) {
        if (last - first + 1 < 4) {
            InsertionSort.insertionSort(arr);
        } else {
            int mid = partition(arr, first, last);
            quicksort(arr, first, mid-1);
            quicksort(arr, mid+1, last);
        }
    }
    private void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] unsortedNumbers = {3, 6, 10, 2, 4, 1, 7, 5, 9, 8};
        sorter.quicksort(unsortedNumbers, 0, 9);
        System.out.println(Arrays.toString(unsortedNumbers));
    }
}