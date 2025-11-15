package project.social_network.exersices.linkdin;

import java.util.*;

public class MinimumWindowString {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || t.length() == 0 || s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int missing = t.length();

        int left = 0, right = 0;
        int bestLen = Integer.MAX_VALUE, bestStart = 0;

        while (right < s.length()) {
            char cr = s.charAt(right);
            if (need.getOrDefault(cr, 0) > 0) {
                missing--;
            }
            need.put(cr, need.getOrDefault(cr, 0) - 1);
            right++;

            while (missing == 0) {
                if (right - left < bestLen) {
                    bestLen = right - left;
                    bestStart = left;
                }
                char cl = s.charAt(left);
                need.put(cl, need.getOrDefault(cl, 0) + 1);
                if (need.get(cl) > 0) {
                    missing++;
                }
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
