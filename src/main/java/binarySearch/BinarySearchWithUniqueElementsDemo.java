package binarySearch;

public class BinarySearchWithUniqueElementsDemo {
    public static void main(String[] args) {

        int[] arr = new int[] {1, 3, 5, 7, 9, 10, 11, 13, 15, 17, 19, 30, 35,40};
        System.out.println(getIndexUsingBinarySearch(arr, 17));
        System.out.println(getIndexUsingBinarySearch(arr,3));
        System.out.println(getIndexUsingBinarySearch(arr, 21));
    }

    /**
     * TC C = O(logn)
     * @param arr
     * @param target
     * @return
     */
    public static int getIndexUsingBinarySearch(int[] arr, int target) {
        //Define Search Space
        int low = 0;
        int high = arr.length -1;

        while (low <= high) {
            int mid = low + (high -low)/2;

            if(arr[mid] == target) return mid; //Check middle is answer
            else if (arr[mid] < target) low = mid +1; // Decide going left or right
            else high = mid -1;
        }
        return -1;
    }
}
