package project.social_network.exersices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }


    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        List<Integer> results = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            int i1 = Collections.binarySearch(list, nums[i]);
            if (i1 < 0) {
                list.add(0, nums[i]);
                i1 = 0;
            }
            list.add(i1, nums[i]);
            results.add(i, i1);
        }
        return results;
    }

}

//
//Sorted list + binary search
//
//ArrayList + Collections.binarySearch to find position, then add(pos, x).
//
//Easy but insertion is O(n), so overall O(n²) on worst case.


//
//Input: nums = [5,2,6,1]
//Output: [2,1,1,0]
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.