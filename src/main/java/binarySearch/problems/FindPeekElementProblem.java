package binarySearch.problems;

/**
 * Find the peak element in the increasing-decreasing array with unique elements.
 */
public class FindPeekElementProblem {
    public static void main(String[] args) {
        System.out.println(getPeakElement(new int[] {1, 3, 8, 10, 7, 4}));

    }

    /**
     * TC = O(logn)
     * @param arr
     * @return
     */
    public static int getPeakElement(int[] arr) {
        int low = 0;
        int high = arr.length -1;

        while (low <= high) {
            int mid = low + (high -low)/2;
            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == arr.length-1 || arr[mid] > arr[mid+1])) {
                return arr[mid];
            } else if(mid == 0 || arr[mid] > arr[mid-1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
