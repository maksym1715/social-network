package project.social_network.exersices;

public class CanJump {

    public static void main(String[] args) {
        System.out.println(canJump(new int []{0,2,3}));
    }
    public static boolean canJump(int[] nums) {

        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            if (maxReach >= nums.length - 1) return true;
            int c = i + nums[i];
            if (c > maxReach) {
                maxReach = c;
            }
        }
        return false;
    }
}
