package project.social_network.exersices.linkdin;

public class RecursionTestV2 {
    public static void main(String[] args) {
//        printCharactersOfStringInRevers("cat", "cat".length() - 1);
//        System.out.println(sumIntegers(555));
//        System.out.println(countCharacterInString("banana", 'b', 0));
//        System.out.println(checkForSortingArray(new int[]{0},0));
//        System.out.println(reverseString("abcd", "abcd".length() - 1));
//        System.out.println(computeFactorial(3));
//        printArrayForward(new int[]{1, 2, 3}, 0);
//        printArrayBackwards(new int[]{1, 2, 3}, new int[]{1, 2, 3}.length - 1);
        int[] ints = {9, 1, 2, 20000, 3, 999,};
//        System.out.println(findMaxElement(ints, 0, ints[0]));
//        printAllSubsertsOfString("abc", 0);

//        System.out.println(replaceChar("banana"));
//        System.out.println(powerfunction(2, 3));
//        System.out.println(palidnromeCheck("aqweewqac", 0, "aqweewqac".length() - 1));
//        System.out.println(reverseString("abcd"));
//        printBinaryHelper(3, "");
//        printSubsetsHelper("abc",0,"");
//        System.out.println(replaceChar("banana",'a','x'));
        printSubsequencesHelper("abc",0,"");
    }

    public static String replaceChar(String s, char from, char to) {
        if (s.isEmpty()) {
            return s;
        }

        char first = s.charAt(0);
        if (first == from) {
            first = to;
        }
        // process rest of string
        return first + replaceChar(s.substring(1), from, to);
    }

    private static void printSubsequencesHelper(String s, int index, String current) {
        if (index == s.length()) {
            System.out.println(current);
            return;
        }
        // skip char
        printSubsequencesHelper(s, index + 1, current);
        // take char
        printSubsequencesHelper(s, index + 1, current + s.charAt(index));
    }

    private static void printSubsetsHelper(String s, int index, String current) {
        if (index == s.length()) {
            System.out.println(current);
            return;
        }
        // 1) skip s.charAt(index)
        printSubsetsHelper(s, index + 1, current);
        // 2) take s.charAt(index)
        printSubsetsHelper(s, index + 1, current + s.charAt(index));
    }

    private static void printAllSubsertsOfString(String c, int x) {
        if (x == c.length() || x < 0) return;
//        System.out.println(c.substring(x));
        System.out.println(c.substring(0, x));
        printAllSubsertsOfString(c, x + 1);
        System.out.println(c.substring(0, x));
        printAllSubsertsOfString(c, 0);
    }

    private static boolean palidnromeCheck(String a, int indexStart, int indexEnd) {
        if (indexStart >= indexEnd) return true;
        if (a.charAt(indexStart) != a.charAt(indexEnd)) return false;
        else {
            return palidnromeCheck(a, indexStart + 1, indexEnd - 1);
        }
    }

    private static int powerfunction(int a, int c) {
        if (c == 1) {
            return a;
        }
        return powerfunction(a, c - 1) * a;
    }

    private static int findMaxElement(int[] a, int c, int anInt) {
        if (c == a.length) {
            return anInt;
        }
        if (a[c] > anInt) {
            anInt = a[c];
        }
        return findMaxElement(a, c + 1, anInt);
    }

    private static void printArrayBackwards(int[] ints, int i) {
        if (i < 0) {
            return;
        }
        System.out.println(ints[i]);
        printArrayBackwards(ints, i - 1);
    }

    public static void printArrayForward(int[] a, int length) {
        if (length == a.length) {
            return;
        }
        System.out.println(a[length]);
        printArrayForward(a, length + 1);
    }

    public static int computeFactorial(int c) {
        if (c == 0) return 1;
        return computeFactorial(c - 1) * c;
    }

    private static void printBinaryHelper(int n, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
            return;
        }
        // put '0' at this position
        printBinaryHelper(n - 1, prefix + "0");
        // put '1' at this position
        printBinaryHelper(n - 1, prefix + "1");
    }

    public static String reverseString(String c) {
//        reverse("abcd") → "dcba"
        if (c.length() <= 1) {
            return c;
        }
        String s = reverseString(c.substring(1));
        System.out.println("SSSS " + s);
        return s + c.charAt(0);
    }

    public static boolean checkForSortingArray(int[] c, int x) {
        if (x == c.length - 1) return true;
        if (c[x] > c[x + 1]) {
            return false;
        } else return checkForSortingArray(c, x + 1);
    }


    public static void printCharactersOfString(String c, int x) {
        if (x == c.length()) {
            return;
        }
        System.out.println(c.charAt(x));
        printCharactersOfString(c, x + 1);
    }

    public static int countCharacterInString(String c, Character d, int a) {
        if (a == c.length()) {
            return 0;
        }
        if (c.charAt(a) == d) {
            return countCharacterInString(c, d, a + 1) + 1;
        } else {
            return countCharacterInString(c, d, a + 1);
        }
    }

    public static void printCharactersOfStringInRevers(String c, int x) {
        if (x < 0) {
            return;
        }
        System.out.println(c.charAt(x));
        printCharactersOfStringInRevers(c, x - 1);
    }

    public static int sumIntegers(int c) {
        if (c == 0) return 0;
        return sumIntegers(c / 10) + (c % 10);
    }
}
