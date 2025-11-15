package project.social_network.exersices;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat","car"));
    }


    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] charArray = t.toCharArray();
        for (char c : charArray) {
            Integer i = map.get(c);
            if (i == null) return false;
            if (i == 0) return false;
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (int value : map.values()) {
            if (value != 0) return false;
        }

        return true;
    }


}
