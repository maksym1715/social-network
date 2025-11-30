package project.social_network.exersices.linkdin;

import java.util.Arrays;
import java.util.List;

public class RecursionTest {


    public static void main(String[] args) {
//        permutation(new int[]{0, 1, 2}, new int[]{0, 1, 2});
//        countDown(5);
//        printStringBackwards("abcd".length(), "abcd");
//        System.out.println(sumDigits(676));
//        System.out.println(isSorted(new int[]{-1, 2, 3, 5}, 0));
//        printCharsReverse("abcd", 0);
//        System.out.println(countAppearances("avavv", 0, 'v'));
    }

    public static int countAppearances(String s, int index, char target) {
        if (index == s.length()) {
            return 0; // no characters left
        }

        int add = (s.charAt(index) == target) ? 1 : 0;

        return add + countAppearances(s, index + 1, target);
    }

    public static void printCharsReverse(String s, int index) {
        if (index == s.length()) return;           // base case: end of string

        // first go deeper
        printCharsReverse(s, index + 1);

        // then print on the way back
        System.out.println(s.charAt(index));
    }

//    public static int calculate(List<Integer> list, int c) {
//
//    }
//
//    public static void print(String c) {
//
//    }

    public static boolean isSorted(int[] arr, int index) {
        if (index == arr.length - 1) return true;
        if (arr[index] > arr[index + 1]) {
            return false;
        } else return isSorted(arr, index + 1);
    }

    //    public int countAppearances(String word){
//        if (word.contains("a")){
//            return countAppearances(word.substring())
//        }
//    }
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return sumDigits(n / 10) + n % 10;
    }


//    public static void printStringBackwards(int x , String s) {
//
//        System.out.println(s);
//        if (s.length()<1){
//            return;
//        }
//        printStringBackwards(x-1,s.charAt(x));
//
//    }

    public static void printChars(String s, int index) {
        if (index == s.length()) return;
        System.out.println(s.charAt(index));
        printChars(s, index + 1);
    }

    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static String reverse(String na, String c, int index) {
        if (index == c.length()) {
            return na;
        }

        return reverse(na + c.charAt(c.length() - 1 - index), c, index + 1);
    }

    public static void countDown(int a) {
        if (a == 0) return;
        System.out.println(a);
        countDown(a - 1);
    }

    public static void priontNumber(int a) {
        if (a == 0) return;
        priontNumber(a - 1);
        System.out.println(a);
    }

    public static int factorial(int c) {
        if (c == 0) return 1;

        return factorial(c - 1) * c;
    }

    public static void permutation(int[] a, int[] c) {

        if (a.length == 0) return;

        for (int i = 0; i < c.length - 1; i++) {
            permutation(Arrays.copyOfRange(c, i, i + 1), c);
        }
        System.out.println(Arrays.toString(a));
    }

}
