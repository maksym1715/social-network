package project.social_network.exersices;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelfV1 {

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        // idx keeps the order of ORIGINAL INDICES we are sorting.
        // We never reorder nums itself; we reorder indices according to nums[idx[*]].
        int[] idx = new int[n];

        // tmpIdx is a temporary buffer used while merging (like the temp array in normal merge sort).
        int[] tmpIdx = new int[n];

        // counts[i] = how many elements to the RIGHT of original position i are STRICTLY smaller than nums[i].
        int[] counts = new int[n];

        // Initialize idx = [0,1,2,..,n-1]
        for (int i = 0; i < n; i++) idx[i] = i;

        // Standard merge sort on the "idx" array, comparing by nums[idx[*]].
        mergeSort(nums, idx, tmpIdx, counts, 0, n - 1);

        // Convert int[] to List<Integer> as required by the problem signature.
        List<Integer> res = new ArrayList<>(n);
        for (int c : counts) res.add(c);
        return res;
    }

    // Sort the subarray idx[l..r] by the VALUES nums[idx[*]] (not by the indices themselves).
    private static void mergeSort(int[] nums, int[] idx, int[] tmpIdx, int[] counts, int l, int r) {
        if (l >= r) return;                 // one element segment -> already sorted
        int m = (l + r) >>> 1;              // midpoint

        // Sort left half and right half
        mergeSort(nums, idx, tmpIdx, counts, l, m);
        mergeSort(nums, idx, tmpIdx, counts, m + 1, r);

        // Merge two sorted halves and update counts
        merge(nums, idx, tmpIdx, counts, l, m, r);
    }

    // Merge idx[l..m] and idx[m+1..r], both already sorted by nums[idx[*]].
    // While merging, compute for each LEFT element how many RIGHT elements are smaller and
    // have been placed before it (these are "smaller to the right" in the original array).
    private static void merge(int[] nums, int[] idx, int[] tmpIdx, int[] counts, int l, int m, int r) {
        int i = l;         // pointer into LEFT half (idx[i] refers to some original position)
        int j = m + 1;     // pointer into RIGHT half
        int k = l;         // write pointer into tmpIdx
        int rightSmaller = 0; // how many RIGHT-half elements we've already placed because they were smaller

        // Merge like normal merge sort, but track when right elements jump ahead of left elements.
        while (i <= m && j <= r) {
            // Compare values: nums at the indexed positions
            if (nums[idx[j]] < nums[idx[i]]) {
                // RIGHT value is smaller than LEFT value
                // → it will move ahead of the current LEFT (and all remaining LEFTS) in the merged order.
                // That means every (not-yet-placed) LEFT element just found one more "smaller on the right".
                rightSmaller++;
                tmpIdx[k++] = idx[j++];     // place this right index into the merged buffer
            } else {
                // LEFT value <= RIGHT value
                // For this LEFT element, exactly 'rightSmaller' right elements have already moved ahead.
                // Those are the smaller-right elements for THIS left element.
                counts[idx[i]] += rightSmaller;
                tmpIdx[k++] = idx[i++];     // place this left index
            }
        }

        // If LEFT still has elements, each of them also gets all the 'rightSmaller' seen so far.
        while (i <= m) {
            counts[idx[i]] += rightSmaller;
            tmpIdx[k++] = idx[i++];
        }

        // If RIGHT still has elements, they don't contribute to any LEFT counts now (no LEFT left).
        while (j <= r) {
            tmpIdx[k++] = idx[j++];
        }

        // Copy merged order (of indices) back into idx[l..r]
        for (int t = l; t <= r; t++) {
            idx[t] = tmpIdx[t];
        }
    }

    // quick demo
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums)); // [2, 1, 1, 0]
    }
}




