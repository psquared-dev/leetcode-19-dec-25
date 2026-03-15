package practice;

import java.util.LinkedList;
import java.util.Map;

public class BalancedParentheses {
    public static boolean isValid(String str) {
        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else {
                // polled is opening char
                Character polled = stack.poll();

                if (!map.get(ch).equals(polled)) {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(isValid("{()}"));
//        System.out.println(isValid("{("));
        System.out.println(isValid(")}"));
    }
}
