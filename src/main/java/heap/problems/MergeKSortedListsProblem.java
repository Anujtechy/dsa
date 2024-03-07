package heap.problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class MergeKSortedListsProblem {
    public static void main(String[] args) {

    }
    public static ListNode mergeKLists(ArrayList<ListNode> sortedListPointers){
        PriorityQueue<ListNode> pq =  new PriorityQueue<>((a,b) -> a.val - b.val);

        sortedListPointers.forEach(x -> pq.add(x));

        ListNode head = null;
        ListNode current = null;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if(head == null) {
                head = temp;
                current = temp;
            } else {
                current.next = temp;
                current = current.next;
            }
            if(current.next != null) {
                pq.add(current.next);
            }
        }
        return head;
    }
}
