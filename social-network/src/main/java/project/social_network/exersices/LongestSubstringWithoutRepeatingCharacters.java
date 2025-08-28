package project.social_network.exersices;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Character> map = new LinkedHashMap();

        int count = 0;
        for (int i = 0, c = i + 1; i < charArray.length; ) {
            if (!map.containsKey(charArray[i])) {
                map.put(charArray[i], charArray[i]);
                count = Math.max(map.size(), count);
                i++;
            } else {
                count = Math.max(map.size(), count);
                Map.Entry<Character, Character> next = map.entrySet().iterator().next();
                map.remove(next.getKey());
            }
        }
        return count;
    }

}
