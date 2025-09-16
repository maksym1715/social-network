package project.social_network.exersices;

import java.util.*;

public class FindReplaceString {

    public static void main(String[] args) {
        System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}));
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> opAt = new HashMap<>(); // startIndex -> op index

        for (int i = 0; i < indices.length; i++) {
            int start = indices[i];
            String src = sources[i];
            if (start >= 0 && start + src.length() <= s.length()
                    && s.startsWith(src, start)) {
                opAt.put(start, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int pos = 0; pos < s.length(); ) {
            Integer j = opAt.get(pos);
            if (j != null) {
                sb.append(targets[j]);           // replace
                pos += sources[j].length();      // skip exactly this source’s length
            } else {
                sb.append(s.charAt(pos));
                pos++;
            }
        }
        return sb.toString();
    }
}
