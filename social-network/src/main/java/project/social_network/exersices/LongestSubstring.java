package project.social_network.exersices;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] charArray = s.toCharArray();

        int bestLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        map.put(charArray[0], 1);
        for (int i = 0, c = i + 1; c < charArray.length; ) {
            while (c < charArray.length &&map.size() < 3) {
                if ( map.containsKey(charArray[c])) {
                    map.compute(charArray[c], (k, i1) -> i1 + 1);
                } else {
                    map.put(charArray[c], 1);
                }
                bestLength++;
                c++;
            }
            if (map.size() == 3) {
                count = Math.max(count, bestLength);
                if (map.containsKey(charArray[i])) {
                    map.put(charArray[i], map.get(charArray[i]) - 1);
                    if (map.get(charArray[i]) == 0) {
                        map.remove(charArray[i]);
                    }
                } else map.remove(charArray[i]);
                i++;
                bestLength--;
            }
        }

        return Math.max(bestLength, count);
    }
}
