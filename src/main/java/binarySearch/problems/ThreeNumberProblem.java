package binarySearch.problems;

/**
 * Given 3 integers N,X and Y.
 * Find nth number which is divisible by X or Y or Both.
 *
 * Examples:
 *  N = 4, X = 2 and Y = 3 --> (2,3,4,6) Ans = 6
 *  N = 8, X = 4 and Y = 3 --> (3,4,6,8,9,12,15,16) Ans = 16
 *  N = 5, X = 4 and Y = 8 --> (4,8,12,16,20) Ans = 20
 */
public class ThreeNumberProblem {
    public static void main(String[] args) {
        System.out.println(findNthNumber_01(4,2,3));
        System.out.println(findNthNumber_01(8,4,3));
        System.out.println(findNthNumber_01(5,4,8));

        System.out.println();
    }

    /**
     * TC = O(n)
     * SC = O(1)
     * @param n
     * @param x
     * @param y
     * @return
     */
    public static int findNthNumber_01(int n, int x, int y) {

        int a = 0, b = 0, last = 0;
        for (int i = 0; i < n; i++) {
            if((a+x) < (b+y)) {
                a += x;
                last = a;
            } else if((a+x) > (b+y)) {
                b += y;
                last = b;
            } else {
                a += x;
                b += y;
                last = a;
            }
        }
        return last;
    }

    public static int findNthNumber_02(int n, int x, int y) {
        return 1;
    }
}
