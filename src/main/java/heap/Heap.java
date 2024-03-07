package heap;

import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> minheap;
    public Heap() {
        minheap = new ArrayList<>();
    }

    /**
     * TC = O(logn)
     * @param data
     */
    public void insert(int data) {
        minheap.add(data);

        //Heapify --> Bottom Up Movements
        int index = minheap.size();
        while (index > 0) {
            int parent = (index -1) /2;
            if(minheap.get(parent) > minheap.get(index)) {
                swap(parent, index);
                index = parent;
            }
            else {
                break;
            }
        }
    }

    /**
     * TC = O(logn)
     * @return
     */
    public int getMin() {

        //get root value
        int minVal = minheap.get(0);

        //Set last index value to root
        minheap.set(0, minheap.get(minheap.size()-1));

        // remove last element
        minheap.remove(minheap.size()-1);

        //Heapify --> Top Down Movements
        int index = 0;
        int size = minheap.size();
        while (index < size) {
            int left = (2*index) + 1;
            int right = (2*index) + 2; // left+1

            //Both left and right child exist
            if(right < size) {
                if(minheap.get(left) <= minheap.get(index)
                        && minheap.get(left) <= minheap.get(right)) {
                    swap(left, index);
                    index = left;
                } else if (minheap.get(right) <= minheap.get(index)
                        && minheap.get(right) <= minheap.get(left)) {
                    swap(right, index);
                    index = right;
                } else {
                    break;
                }
            } else if (left < size) { // Only left exist
                if(minheap.get(left) <= minheap.get(index)) {
                    swap(left, index);
                    index = left;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return minVal;
    }

    /**
     * TC = O(n)
     * SC = O(1)
     * Number of leaves nodes in complete binary tree = (n+1)/2
     * means half nodes of complete binary tree is leaf nodes.
     * @param arr
     */
    public void buildHeap(int[] arr) {
        int n = arr.length;
        int leaves = (n+1)/2;
        for (int i = n-leaves; i > 0 ; i--) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            if(arr[i] > arr[left] || arr[i] > arr[right]) {
                if(arr[left] < arr[right]) {
                    swap(left, i);
                } else {
                    swap(right, i);
                }
            }
        }
    }

    private void swap(int parent, int child) {
        int temp = minheap.get(child);
        minheap.set(child, minheap.get(parent));
        minheap.set(parent, temp);
    }
}
