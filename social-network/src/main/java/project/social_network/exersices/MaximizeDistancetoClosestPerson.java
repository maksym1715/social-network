package project.social_network.exersices;

public class MaximizeDistancetoClosestPerson {
    public static void main(String[] args) {

    }

    public static int maxDistToClosest(int[] seats) {
        int left = -1;
        int best = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (left == -1) {
                    // leading zeros from 0..i-1
                    best = Math.max(best, i);
                } else {
                    best = Math.max(best, (i - left) / 2);
                }
                left = i;
            }
        }
        best = Math.max(best, seats.length - 1 - left);

        return best;
    }
}
