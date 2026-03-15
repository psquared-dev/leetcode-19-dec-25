package designguru01;

import java.util.LinkedList;
import java.util.Map;

public class BalancedParentheses {
    public static boolean isValid(String s) {
        // ToDo: Write Your Code Here.

        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                // ch is opening
                stack.push(ch);
            } else {
                // ch is closing
                Character polledOpeningChar = stack.poll();

                if(!map.get(ch).equals(polledOpeningChar)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
        System.out.println(isValid("{"));
    }
}
