package project.social_network.exersices;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] c = new int[2];
        if (nums.length <= 0) return new int[]{-1, -1};
        int len = nums.length / 2;
        int start = 0;
        int end = nums.length;
        while (start!=end) {
            len = (start + end) / 2;
            if (nums[len] == target) {
                c[0] = len;
                if (nums[len - 1] == target) {
                    c[1] = len - 1;
                    return c;
                }
                if (nums[len + 1] == target) {
                    c[1] = len + 1;
                    return c;
                }
            } else if (len == 0) {
                return new int[]{-1, -1};
            }
            if (nums[len] > target) {
                end = len;
            } else if (nums[len] < target) {
                start = len;
            }
        }
        return null;
    }
}
//Given an array of integers nums sorted in non-decreasing order, find the starting and
//ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
//
//
//Example 1:
//
//Input: nums = [5,6,7,8,9,9,9,10,11,12,13], target = 8
//Output: [3,4]