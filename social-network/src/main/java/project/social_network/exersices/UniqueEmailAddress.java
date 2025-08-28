package project.social_network.exersices;

import lombok.val;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        var  c = new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(numUniqueEmails(c));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            boolean ignore = false;
            String a = emails[i];
            char[] charArray = a.toCharArray();
            for (int i1 = 0; i1 < charArray.length; i1++) {
                if (charArray[i1] == '@') {
                    stringBuilder.append(a, i1, a.length());
                    break;
                }
                if (charArray[i1] == '+') {
                    ignore = true;
                } else if (charArray[i1] != '+' && charArray[i1] != '.' && !ignore) {
                    stringBuilder.append(charArray[i1]);
                }
            }
            stringSet.add(stringBuilder.toString());
        }
        return stringSet.size();
    }

}
