package project.social_network.exersices.linkdin;

import java.util.HashMap;
import java.util.Map;

public class NumberToWords {


    private static final Map<Integer, String> belowTwenty = new HashMap<>();
    private static final Map<Integer, String> tens = new HashMap<>();
    private static final Map<Integer, String> thousands = new HashMap<>();

    static {
        belowTwenty.put(1, "One");
        belowTwenty.put(2, "Two");
        belowTwenty.put(3, "Three");
        belowTwenty.put(4, "Four");
        belowTwenty.put(5, "Five");
        belowTwenty.put(6, "Six");
        belowTwenty.put(7, "Seven");
        belowTwenty.put(8, "Eight");
        belowTwenty.put(9, "Nine");
        belowTwenty.put(10, "Ten");
        belowTwenty.put(11, "Eleven");
        belowTwenty.put(12, "Twelve");
        belowTwenty.put(13, "Thirteen");
        belowTwenty.put(14, "Fourteen");
        belowTwenty.put(15, "Fifteen");
        belowTwenty.put(16, "Sixteen");
        belowTwenty.put(17, "Seventeen");
        belowTwenty.put(18, "Eighteen");
        belowTwenty.put(19, "Nineteen");

        tens.put(20, "Twenty");
        tens.put(30, "Thirty");
        tens.put(40, "Forty");
        tens.put(50, "Fifty");
        tens.put(60, "Sixty");
        tens.put(70, "Seventy");
        tens.put(80, "Eighty");
        tens.put(90, "Ninety");

        thousands.put(1, "");           // for hundreds group
        thousands.put(1000, "Thousand");
        thousands.put(1_000_000, "Million");
        thousands.put(1_000_000_000, "Billion");
    }


    public static void main(String[] args) {
        System.out.println(numberToWords(1_000_234_567));
    }


    public static String numberToWords(int num) {
        String word = "";
        int size = 0;
        while (true) {
            if (num / 1000 > 0) {
                word = helper(num % 1000, word, size) + " " + word;
                if (size > 0) {
                    size = 1000 * (num % 1000) + size;
                } else size = (num % 1000) + size;
                num = num / 1000;
            } else if (num / 100 > 0) {
                word = helper(num, word, size) + " " + word;
                if (size > 0) {
                    size = 100 * (num % 100) + size;
                } else size = (num % 100) + size;
                num = num / 100;
                if (num == 1) break;
            } else {
                word = helper(num, word, size) + " " + word;
                break;
            }

        }
        return word;
    }

    public static String helper(int num, String word, int size) {
        if (num == 0) return word;
        word = String.valueOf(size);
        String result = "";
        if (num / 100 > 0) {
            int num100 = num / 100;
            int num10 = num % 100;
            String s = belowTwenty.get(num100);
            String s1 = "";
            String s3 = "";
            if (num10 > 0) {
                int num1 = num10 % 10;
                s1 = tens.get((num10 / 10) * 10);
                s3 = "";
                if (num1 > 0) {
                    s3 = belowTwenty.get(num1);
                }
            }
            String add = "";
            if (word.length() >= 3 && word.length() < 6) {
                add = "Thousand";
            } else if (word.length() >= 6 && word.length() <= 9) {
                add = "Million";
            } else if (word.length() >= 9 ) {
                add = "Billion";
            }
            result = s + " hundread " + (s1 == null ? " " : s1) + " " + s3 + " " + add;
        } else if (num / 100 <= 0 && num / 10 > 0) {
            int num10 = num / 10;
            int num1 = 0;
            if (num > 10) {
                num1 = num % 10;

            }
            int i = (num / 10) * 10;
            String s = "";
            if (i > 20) {
                s = tens.get(i);
            } else {
                s = belowTwenty.get(num);
            }
            String s1 = "";
            if (i > 20 && num1 > 0) {
                s1 = belowTwenty.get(num1);
            }
            String add = "";
            if (word.length() >= 3 && word.length() < 6) {
                add = "Thousand";
            } else if (word.length() >= 6 && word.length() <= 9) {
                add = "Million";
            } else if (word.length() >= 9) {
                add = "Billion";
            }
            result = s + " " + s1 + " " + add;
        } else {
            String s = belowTwenty.get(num);
            String add = "";
            if (word.length() >= 3 && word.length() < 6) {
                add = "Thousand";
            } else if (word.length() >= 6 && word.length() <= 9) {
                add = "Million";
            } else if (word.length() >= 9) {
                add = "Billion";
            }
            result = s + " " + " " + add;
        }
        return result;
    }
}
