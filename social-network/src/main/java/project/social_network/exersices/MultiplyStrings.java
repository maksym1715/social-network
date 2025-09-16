package project.social_network.exersices;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("498828660196",
                "840477629533"));
    }

    public static String multiply(String num1, String num2) {
        Map<Character, Long> map = new HashMap<>();
        map.put('0', 0l);
        map.put('1', 1l);
        map.put('2', 2l);
        map.put('3', 3l);
        map.put('4', 4l);
        map.put('5', 5l);
        map.put('6', 6l);
        map.put('7', 7l);
        map.put('8', 8l);
        map.put('9', 9l);
        char[] charArray = num1.toCharArray();
        char[] charArray1 = num2.toCharArray();
        long length1 = num1.length();
        long ilevel1 = length1 - 1;
        long mult1 = 1l;
        while (ilevel1 != 0) {
            mult1 = mult1 * 10;
            ilevel1--;
        }
        long mult2 = 1l;
        long length2 = num2.length();
        long ilevel2 = length2 - 1;
        while (ilevel2 != 0) {
            mult2 = mult2 * 10;
            ilevel2--;
        }

        long len = Math.max(length1, length2);
        long firstNumber = 0;
        long firstNumber2 = 0;
        for (int i = 0; i < len; i++) {
            if (i <= length1 - 1) {
                char c = charArray[i];
                long i1 = map.get(c) * mult1;
                firstNumber = firstNumber + i1;
                mult1=mult1/10;
            }
            if (i <= length2 - 1) {
                char c = charArray1[i];
                long i1 = map.get(c) * mult2;
                firstNumber2 = firstNumber2 + i1;
                mult2=mult2/10;
            }
        }
        return String.valueOf(BigInteger.valueOf(firstNumber).multiply(BigInteger.valueOf(firstNumber2)));
    }
}
