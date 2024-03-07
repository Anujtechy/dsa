package heap.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: Given N ropes with their length. Cost of connecting 2 ropes = sum od length of both ropes.
 * find the minimum cost to connect all ropes.
 */
public class RopeProblem {
    public static void main(String[] args) {
        /**
         * Observation: Connect smaller length ropes first
         */
        System.out.println(minCost(new int[] {2,2,6,5,3}));
    }

    /**
     * TC = O(nlogn)
     * SC = O(n)
     * @param arr
     * @return
     */
    private static int minCost(int[] arr) {

        if(arr == null || arr.length == 0) return -1;
        if(arr.length == 1) return arr[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(arr).forEach(x -> pq.add(x));

        int minCost  = 0;
        while (!pq.isEmpty() && pq.size() > 1){
            int f = pq.poll();
            int s = pq.poll();
            minCost += (f+s);
            pq.add(f+s);
        }
        return minCost;
    }
}
