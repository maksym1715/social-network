package project.social_network.exersices;

public class MaximumProductSubbarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }


    public static int maxProduct(int[] nums) {
        int maxHere = nums[0];
        int minHere = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            // Negative flips roles
            if (x < 0) {
                int tmp = maxHere;
                maxHere = minHere;
                minHere = tmp;
            }

            // Extend or restart at x
            maxHere = Math.max(x, x * maxHere);
            minHere = Math.min(x, x * minHere);

            globalMax = Math.max(globalMax, maxHere);
        }
        return globalMax;
    }


}


//
//Input: nums = [2,3,-2,4,4,5,6,9,-1]
//Output: 6
//Explanation: [2,3] has the largest product 6.