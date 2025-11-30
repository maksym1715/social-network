package project.social_network.exersices.linkdin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursiontestv5 {
    public static void main(String[] args) {
//        printAllArray(new int[]{1, 2, 3}, 0, new int[]{});
        printAllStairPaths(3, new ArrayList<>(), 3);
    }
//
//    printAllSubsetsOfArray (same subset pattern, but with int[])
//
//    printAllStairPaths (like countWays, but printing paths – real backtracking)


    public static void printAllSubsetsOfArray(int[] c) {
        int index = 0;
        List<Object> list = Arrays.asList();
        printAllArray(c, index, new int[]{});
    }

    private static void printAllArray(int[] c, int index, int[] d) {
        if (index == c.length) {
            return;
        }
        printAllArray(c, index + 1, Arrays.copyOfRange(c, index, c.length));
        printAllArray(c, index + 1, Arrays.copyOfRange(c, index + 1, c.length));
        System.out.println(Arrays.toString(d));
    }

    private static void printAllStairPaths(int c, List<Integer> list, int index) {
        if (index == 0) {
            System.out.println(list.toString());
            return;
        }
        if (index < 0) {
            return;
        }
        list.add(1);
        printAllStairPaths(c, list, index - 1);
        list.remove(list.size() - 1);

        list.add(2);
        printAllStairPaths(c, list, index - 2);
        list.remove(list.size() - 1);
    }

}
