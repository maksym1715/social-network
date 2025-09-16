package project.social_network.exersices;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }


    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k); // min-heap
        for (int x : nums) {
            minHeap.offer(x);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
//
//    Stack = LIFO = last in, first out (like a stack of dishes).
//
//    Queue = FIFO = first in, first out (like people waiting in line).

}
