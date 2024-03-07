package binarySearch;

/**
 * Find floor(sqrt(n)) without using internal functions
 * Examples:
 *  N = 10 --> Ans = 3
 *  N = 50 --> Ans = 7
 *  N = 25 --> Ans = 5
 *
 *  Range  1 <= sqrt(n) <= n
 */
public class FindFloorSqrtOfElementDemo {
    public static void main(String[] args) {
        System.out.println(findFloorSqrtOfElement(10));
        System.out.println(findFloorSqrtOfElement(50));
        System.out.println(findFloorSqrtOfElement(25));
    }

    public static int findFloorSqrtOfElement (int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if((n >= (mid*mid)) && (((mid+1)*(mid+1)) > n)) return mid;
            else if(mid*mid > n) high = mid - 1;
            else low = mid + 1;
        }
        return 1;
    }
}
