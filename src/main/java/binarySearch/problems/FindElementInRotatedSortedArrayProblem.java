package binarySearch.problems;

/**
 * Find the index of the element X in the rotated sorted array with distinct elements.
 * if element is not present return -1.
 *
 * Rotated Sorted Array
 *  1. Combination of 2 sorted arrays
 *  2. Elements in first part is always greater than elements in second part
 *
 * How to check if array is not rotated?
 *    --> if(A[0] < A[n-1]) ==> sorted bit not rotated
 *    --> if(A[0] > A[n-1]) ==> rotated sorted array
 */
public class FindElementInRotatedSortedArrayProblem {
    public static void main(String[] args) {
        System.out.println(findIndexOfElementInRotatedSortedArray(new int[] {50,60,100,3,4,10,25,30,35}, 25));
        System.out.println(findIndexOfElementInRotatedSortedArray(new int[] {50,60,100,3,4,10,25,30,35}, 27));
        System.out.println(findIndexOfElementInRotatedSortedArray(new int[]{5,7,10,12,1,3}, 3));
    }

    /**
     * TC = O(logn)
     * @param arr
     * @param target
     * @return
     */
    public static int findIndexOfElementInRotatedSortedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low <= high) {
            int mid = low + (high -low)/2;
            if(arr[mid] == target) {
                return mid;
            } else if (target >= arr[0]) { //target lies in first part
                if(arr[mid] < arr[0]) high = mid-1;
                else {
                    if(target > arr[mid]) low = mid + 1;
                    else high = mid -1;
                }
            } else { // target lies in second part
                if(arr[mid] >= arr[0]) low = mid + 1;
                else {
                    if(target > arr[mid]) low = mid + 1;
                    else high = mid -1;
                }
            }
        }
        return -1;
    }
}
