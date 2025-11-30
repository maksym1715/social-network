package project.social_network.exersices.linkdin;

public class RecursionTestv4 {
    public static void main(String[] args) {
//        printChars("abc", 0);
//        System.out.println(reverseString("cat"));
//        System.out.println(isPalindrome("hello", 0, "hello".length()-1));
//        printBinary(3);
//        printSubsets("abc");
        System.out.println(countWays(4));
    }

    public static int countWays(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        return countWays(n - 1) + countWays(n - 2);
    }

    public static void printSubsets(String s) {
        helper(s, 0, "");
    }

    private static void helper(String s, int index, String current) {
        if (s.length() == index) {
            System.out.println(current);
            return;
        }
        helper(s, index + 1, current);
        helper(s, index + 1, current + s.charAt(index));
    }


    public static void printBinary(int n) {
        helper(n, "");
    }

    private static void helper(int n, String prefix) {
        if (prefix.length() == n) {
            System.out.println(prefix);
            return;
        }
        helper(n, prefix + "1");
        helper(n, prefix + "0");
    }


    public static void printChars(String s, int index) {
        if (index == s.length()) return;
        System.out.println(s.charAt(index));
        printChars(s, index + 1);
    }

    public static String reverseString(String c) {
        if (c.isEmpty()) return c;
        return reverseString(c.substring(1)) + c.charAt(0);
    }

    public static boolean isPalindrome(String c, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (c.charAt(left) != c.charAt(right)) return false;
        return isPalindrome(c, left + 1, right - 1);
    }
}
