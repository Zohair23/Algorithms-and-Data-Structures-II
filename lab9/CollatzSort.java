import java.util.Scanner;

public class CollatzSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        recQuickSort(numbers, 0, n - 1);

        System.out.println("Number in the nth place in the ordering sorted by Collatz length: " + numbers[n - 1]);
    }

    // Function to calculate the Collatz length of a number
    public static long calculateCollatzLength(int num) {
        long length = 1;
        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = 3 * num + 1;
            }
            length++;
        }
        return length;
    }

    // Quicksort implementation with median of three pivot selection and cutoff for insertion sort
    public static void recQuickSort(int[] arr, int left, int right) {
        int size = right - left + 1;
        if (size < 10) { // Insertion sort if small
            insertionSort(arr, left, right);
        } else { // Quicksort if large
            int pivotIndex = medianOf3(arr, left, right);
            int partitionIndex = partition(arr, left, right, pivotIndex);
            recQuickSort(arr, left, partitionIndex - 1);
            recQuickSort(arr, partitionIndex + 1, right);
        }
    }

    // Median of three pivot selection
    public static int medianOf3(int[] arr, int left, int right) {
        int center = (left + right) / 2;

        if (arr[left] > arr[center])
            swap(arr, left, center);
        if (arr[left] > arr[right])
            swap(arr, left, right);
        if (arr[center] > arr[right])
            swap(arr, center, right);

        swap(arr, center, right - 1); // put pivot on right
        return right - 1; // return median value index
    }

    // Partition function for Quicksort
    public static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivot = arr[pivotIndex];
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while (calculateCollatzLength(arr[++leftPtr]) < calculateCollatzLength(pivot)) {} // Scan right
            while (rightPtr > 0 && calculateCollatzLength(arr[--rightPtr]) > calculateCollatzLength(pivot)) {} // Scan left

            if (leftPtr >= rightPtr) { // If pointers cross
                break;
            } else {
                swap(arr, leftPtr, rightPtr); // Swap elements
            }
        }

        swap(arr, leftPtr, right); // Swap pivot into correct place
        return leftPtr; // Return pivot location
    }

    // Insertion sort implementation
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && calculateCollatzLength(arr[j]) > calculateCollatzLength(key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Swap function
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
