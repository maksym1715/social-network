package project.social_network.exersices;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char value : charArray) {
            if (value == '(' || value == '[' || value == '{') {
                stack.add(value);
            } else {
                if (stack.isEmpty())return false;
                Character pop = stack.pop();
                Character c = map.get(pop);
                if (value != c) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

}
