package binarySearch.problems;

/**
 * Find any one local minima in an array of distinct integers
 * Local Minima means arr[i-1] > arr[i]  < arr[i+1]
 */
public class FindLocalMinimaProblem {
    public static void main(String[] args) {
        System.out.println(getLocalMinima(new int[] {9, 8, 1, 3, 5, 7, 2, 6})); //local minima 1 and 2 in this array
        System.out.println(getLocalMinima(new int[] {9, 8, 5, 1}));
    }

    public static int getLocalMinima(int[] arr) {
        int low = 0;
        int high = arr.length -1;

        while (low <= high) {
            int mid = low + (high -low)/2;
            if((mid == 0 || arr[mid] < arr[mid-1]) &&
                    (mid == arr.length-1 || arr[mid] < arr[mid+1])) {
                return arr[mid];
            } else if (mid > 0 && arr[mid-1] < arr[mid]) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }
}
