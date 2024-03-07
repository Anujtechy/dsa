package binarySearch.problems;

/**
 * Given a sorted integer array where every element appears twice except for one element that
 * appears one time. Find that unique element.
 */
public class FindUniqueElementProblem {
    public static void main(String[] args) {
        System.out.println(findUniqueElementUsingBitManipulation(new int[] {2, 2, 5, 7, 7, 10, 10}));
        System.out.println(findUniqueElementUsingBitManipulation(new int[] {1, 1, 5, 5, 8, 8, 10, 13, 13, 18, 18}));

        System.out.println();
        System.out.println(findUniqueElementUsingBinarySearch_01(new int[] {2, 2, 5, 7, 7, 10, 10}));
        System.out.println(findUniqueElementUsingBinarySearch_01(new int[] {1, 1, 5, 5, 8, 8, 10, 13, 13, 18, 18}));

        System.out.println();
        System.out.println(findUniqueElementUsingBinarySearch_02(new int[] {2, 2, 5, 7, 7, 10, 10}));
        System.out.println(findUniqueElementUsingBinarySearch_02(new int[] {1, 1, 5, 5, 8, 8, 10, 13, 13, 18, 18}));
    }

    /**
     * TC = O(n)
     * Sc = O(n)
     * @param arr
     * @return
     */
    public static int findUniqueElementUsingBitManipulation(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++)
            ans ^= arr[i];
        return ans;
    }

    /**
     * Using Even-odd pair , odd-even funda
     * TC =O(logn)
     * @param arr
     * @return
     */
    public static int findUniqueElementUsingBinarySearch_01(int[] arr) {
        int low =0;
        int high = arr.length-1;

        while (low <= high){
            int mid = low + (high -low)/2;
            if((mid == 0 || arr[mid] != arr[mid-1]) && (mid == arr.length-1 || arr[mid] != arr[mid+1])) {
                return arr[mid];
            } else if(mid == 0 ||  arr[mid] == arr[mid-1]) { // (mid -1), mid
                if(mid%2 == 0) high = mid -1; //odd-even pair
                else low = mid + 1; //even-odd pair
            } else { // mid, (mid+1)
                if(mid%2 == 1) high = mid -1; //odd-even pair
                else low = mid + 1; //even-odd pair
            }
        }

        return -1;
    }

    /**
     * Look for odd element funda
     * TC =O(logn)
     * @param arr
     * @return
     */
    public static int findUniqueElementUsingBinarySearch_02(int[] arr) {
        int low =0;
        int high = arr.length-1;

        while (low <= high){
            int mid = low + (high -low)/2;
            if((mid == 0 || arr[mid] != arr[mid-1]) && (mid == arr.length-1 || arr[mid] != arr[mid+1])) {
                return arr[mid];
            } else if(mid == 0 ||  arr[mid] == arr[mid-1]) { // (mid -1), mid
                if((high - mid)%2 == 0) high = mid-1;  //element count is odd in left
                else low = mid +1;//element count is odd in right
            } else { // mid, (mid+1)
                if((mid -low)%2 == 1) high = mid -1; //element count is odd in left
                else low = mid + 1; //element count is odd in right
            }
        }
        return -1;
    }
}
