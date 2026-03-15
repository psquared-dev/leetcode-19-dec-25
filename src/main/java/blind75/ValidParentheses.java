package blind75;

import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static boolean isValid(String str) {
        LinkedList<Character> stack = new LinkedList<>();

        Map<Character, Character> characterMap = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!characterMap.containsKey(c)) {
                // push
                stack.push(c);
            } else {
                // poll
                Character polled = stack.poll();
                if (polled == null || !polled.equals(characterMap.get(c))) {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({})"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("["));
    }
}
