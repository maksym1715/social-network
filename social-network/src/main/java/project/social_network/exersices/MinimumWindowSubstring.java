package project.social_network.exersices;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    //need to finish it
    public String minWindow(String s, String t) {
        char[] charArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String ex = t;
        int size = 0;
        int beseLen = 0;
        int bestStart = 0;
        for (int i = 0, e = i + 1; e < charArray.length; i++) {
            window.put(charArray[e], window.getOrDefault(charArray[e], 0) + 1);
            if (map.containsKey(charArray[e]) && window.get(charArray[e]).intValue() == map.get(charArray[e]).intValue()) {
                size++;
            }
            while (size == map.size()) {
                if (e - i + 1 < beseLen) {
                    size = e - i + 1;
                    bestStart = i;
                }
                Character c = s.charAt(i);
                window.put(c, window.get(c) - 1);
                if (map.containsKey(c) && window.get(c) < map.get(c)) {
                    size--;
                }
            }
        }
        return "";
    }


//        private static boolean isPrimeHelper(int n) {
//            // base case: if divisor reached sqrt(n), no divisor found → prime
//            if (n==0)return false;
//            // if divisible → not prime
//            // recursive step: check next divisor
//            return isPrimeHelper(n) % isPrimeHelper(n-1) == 0;
//        }
    }






