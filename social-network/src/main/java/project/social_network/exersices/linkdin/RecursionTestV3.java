package project.social_network.exersices.linkdin;

import java.util.Arrays;

public class RecursionTestV3 {
    public static void main(String[] args) {
//        printAllCharacters("abc",0);
//        printCharactersBackwards("abc","abc".length()-1);
//        System.out.println(sumOfDigits(19));
//        System.out.println(countOccurences("banana", 'b', 0));
//        System.out.println(isArraySorted(new int[]{9,1, 2, 5},0));
//        System.out.println(reverseString("abcd"));
//        System.out.println(factorial(4));
//         printArrayForwards(new int[]{1, 2, 3},0);
//        printArrayBackwards(new int[]{1, 2, 3}, 2);
//        System.out.println(findMaxInArray(new int[]{1, 999, 2, 3}, 0, 0));
//        System.out.println(countDigitsInarray(123456));
//        System.out.println(powerFunction(2, 5));
//        System.out.println(fibonachi(5, 5));
//        System.out.println(checkIfStringPalindrome("cabbac", 0, "cabbac".length() - 1));
//        System.out.println(sumOfArray(new int[]{1,  2, 3},0));
//        printAllBinary(3,"");
        printAllSubsetsOfString("abc", 0, "");
//        System.out.println(replaceS("axcx", 'x', 'w'));
//        printAllSubsetsOfArray(new int[]{1, 2, 4}, 0, new int[]{});
    }


    public static void printAllSubsetsOfArray(int[] c, int index, int[] subbaray) {
        if (index == c.length) {
//            System.out.println(Arrays.toString(subbaray));
            return;
        }

        printAllSubsetsOfArray(c, index + 1, Arrays.copyOfRange(c, index, c.length));


        printAllSubsetsOfArray(c, index + 1, Arrays.copyOfRange(c, index + 1, c.length));
        System.out.println(Arrays.toString(subbaray));


    }

    public static void printAllSubsetsOfString(String s, int index, String current) {
        if (index == s.length()) {
            System.out.println(current);
            return;
        }
        // skip char
        printAllSubsetsOfString(s, index + 1, current);
        // take char
        printAllSubsetsOfString(s, index + 1, current + s.charAt(index));
    }

    public static String replaceS(String s, Character from, Character to) {
        if (s.isEmpty()) {
            return s;
        }

        char first = s.charAt(0);
        if (first == from) {
            first = to;
        }
        // process rest of string
        return first + replaceS(s.substring(1), from, to);
    }


//    public static int countNumbers(int n, int index) {
//        if (index == n) {
//            return 1;
//        }
//        return countNumbers()
//    }

    public static void printAllSubsetsOfString(String c, int index) {
        if (c.isEmpty()) return;
        System.out.println(c.charAt(0) + " " + c.charAt(index));
        printAllSubsetsOfString(c.substring(index + 1), index);
        System.out.println(c.charAt(0));
    }

    public static void printAllBinary(int n, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }
        // put '0' at this position
        printAllBinary(n - 1, prefix + "0");
        // put '1' at this position
        printAllBinary(n - 1, prefix + "1");
    }

    public static int sumOfArray(int[] c, int index) {
        if (index == c.length) {
            return 0;
        }
        return sumOfArray(c, index + 1) + c[index];
    }

    public static boolean checkIfStringPalindrome(String c, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (c.charAt(left) != c.charAt(right)) {
            return false;
        } else {
            return checkIfStringPalindrome(c, left + 1, right - 1);
        }
    }

    public static int fibonachi(int a, int x) {
        if (x == 0) {
            return a;
        }
        return fibonachi(a, x - 1) + fibonachi(a, x - 2);
    }

    public static int powerFunction(int a, int c) {
        if (c == 0) {
            return 1;
        }
        return powerFunction(a, c - 1) * a;
    }

    public static int countDigitsInarray(int a) {
        if (a == 0) return 0;
        return countDigitsInarray((a / 10)) + 1;
    }

    public static int findMaxInArray(int[] c, int index, int max) {
        if (index == c.length - 1) {
            return max;
        }
        if (max > c[index]) {
            max = max;
        } else {
            max = c[index];
        }
        return findMaxInArray(c, index + 1, max);
    }

    public static void printArrayBackwards(int c[], int index) {
        if (index < 0) return;
        System.out.println(c[index]);
        printArrayBackwards(c, index - 1);
    }

    public static void printArrayForwards(int[] c, int index) {
        if (index == c.length) return;
        System.out.println(c[index]);
        printArrayForwards(c, index + 1);
    }

    public static int factorial(int c) {
        if (c == 1) {
            return 1;
        }
        return factorial(c - 1) * c;
    }

    public static String reverseString(String c) {
        if (c.length() <= 1) {
            return c;
        }
        return reverseString(c.substring(1)) + c.charAt(0);
    }

    public static boolean isArraySorted(int[] c, int index) {
        if (index == c.length - 1) {
            return true;
        }
        if (c[index] > c[index + 1]) return false;
        else return isArraySorted(c, index + 1);
    }

    public static void printAllCharacters(String c, int x) {
        if (x == c.length()) return;
        System.out.println(c.charAt(x));
        printAllCharacters(c, x + 1);
    }

    public static void printCharactersBackwards(String c, int x) {
        if (x < 0) return;
        System.out.println(c.charAt(x));
        printCharactersBackwards(c, x - 1);
    }

    public static int sumOfDigits(int c) {
        if (c == 0) return 0;
        return sumOfDigits(c / 10) + c % 10;
    }

    public static int countOccurences(String c, Character d, int index) {
        if (index == c.length()) return 0;
        if (c.charAt(index) == d) {
            return countOccurences(c, d, index + 1) + 1;
        } else {
            return countOccurences(c, d, index + 1);
        }
    }


}
