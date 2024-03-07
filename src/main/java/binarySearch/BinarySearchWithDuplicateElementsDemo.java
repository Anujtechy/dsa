package binarySearch;

/**
 * Find the  first and last occurrence of an element in sorted array.
 * if target is not present return -1
 */
public class BinarySearchWithDuplicateElementsDemo {
    public static void main(String[] args) {

        int[] arr = new int[] {2, 2, 5, 5, 5, 8, 10, 10, 13};

        System.out.println("[" + getFirstOccurrenceIndexUsingBinarySearch(arr, 2) +
                ", " + getLastOccurrenceIndexUsingBinarySearch(arr, 2) + "]");
        System.out.println("[" + getFirstOccurrenceIndexUsingBinarySearch(arr, 8) +
                ", " + getLastOccurrenceIndexUsingBinarySearch(arr, 8) + "]");
        System.out.println("[" + getFirstOccurrenceIndexUsingBinarySearch(arr, 5) +
                ", " + getLastOccurrenceIndexUsingBinarySearch(arr, 5) + "]");
        System.out.println("[" + getFirstOccurrenceIndexUsingBinarySearch(arr, 10) +
                ", " + getLastOccurrenceIndexUsingBinarySearch(arr, 10) + "]");
        System.out.println("[" + getFirstOccurrenceIndexUsingBinarySearch(arr, 7) +
                ", " + getLastOccurrenceIndexUsingBinarySearch(arr, 7) + "]");

    }

    /**
     * TC C = O(logn)
     * @param arr
     * @param target
     * @return
     */
    public static int getFirstOccurrenceIndexUsingBinarySearch(int[] arr, int target) {
        //Define Search Space
        int low = 0;
        int high = arr.length -1;
        int lowerbound = -1;

        while (low <= high) {
            int mid = low + (high -low)/2;

            if(arr[mid] == target && (mid == 0 || arr[mid] > arr[mid-1])) return mid;
            else if (arr[mid] < target) low = mid +1; // Decide going left or right
            else high = mid -1;
        }
        return -1;
    }

    /**
     * TC = O(logn)
     * @param arr
     * @param target
     * @return
     */
    public static int getLastOccurrenceIndexUsingBinarySearch(int[] arr, int target) {
        //Define Search Space
        int low = 0;
        int high = arr.length -1;
        int lowerbound = -1;

        while (low <= high) {
            int mid = low + (high -low)/2;

            if(arr[mid] == target && (mid == arr.length-1 || arr[mid] < arr[mid+1])) return mid;
            else if (arr[mid] > target) high = mid -1; // Decide going left or right
            else  low = mid +1;
        }
        return -1;
    }
}
