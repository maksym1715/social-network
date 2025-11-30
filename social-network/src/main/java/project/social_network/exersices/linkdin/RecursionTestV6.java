package project.social_network.exersices.linkdin;

import java.util.ArrayList;
import java.util.List;

public class RecursionTestV6 {


    //    POINT A: Print all subsets of an array (array-only version)
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        printAllSubsetsOfAnArray(new int[]{1, 2, 3}, list, 0);
//        printAllSubsequences("abc", 0, "");
//        printAllSuvsequences(new int[]{1, 2, 3}, 0, list);
//        printAllCombinationss(3,2,list,0);
        printPermutation(new int[]{1, 2, 3}, 0, list);
    }

    public static void printPermutation(int[] a, boolean[] used, List<Integer> list) {
        if (list.size() == a.length) {
            System.out.println(list);
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!used[i]) {
                used[i] = true;
                printPermutation(a, used, list);
                list.add(a[i]);
            }
        }
    }

    public static void printAllCombinationss(int n, int k, List<Integer> current, int index) {
        if (n < index && current.size() == k) {
            System.out.println(current.toString());
            return;
        }
        if (n < index) return;
        current.add(index);
        printAllCombinationss(n, k, current, index + 1);
        current.remove(current.size() - 1);
        printAllCombinationss(n, k, current, index + 1);
    }

    public static void printAllSuvsequences(int[] c, int index, List<Integer> list) {
        if (index == c.length) {
            System.out.println(list.toString());
            return;
        }

        list.add(c[index]);
        printAllSuvsequences(c, index + 1, list);

        list.remove(list.size() - 1);
        printAllSuvsequences(c, index + 1, list);

    }


    public static void printAllSubsetsOfAnArray(int[] arr, List<Integer> list, int index) {
        if (index == arr.length) {
            System.out.println(list.toString());
            return;
        }

        list.add(arr[index]);
        printAllSubsetsOfAnArray(arr, list, index + 1);

        list.remove(list.size() - 1);
        printAllSubsetsOfAnArray(arr, list, index + 1);
    }

    public static void printAllSubsequences(String s, int index, String curentStrin) {
        if (s.length() == index) {
            System.out.println(curentStrin);
            return;
        }


        printAllSubsequences(s, index + 1, curentStrin + s.charAt(index));

        printAllSubsequences(s, index + 1, curentStrin);


    }

}
