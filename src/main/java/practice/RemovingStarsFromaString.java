package practice;

import java.util.Collections;
import java.util.LinkedList;

public class RemovingStarsFromaString {
    public static String removeStars(String str) {
        StringBuilder result = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '*') {
                stack.poll();
            } else {
                stack.push(ch);
            }

        }

        System.out.println(stack);
        Collections.reverse(stack);

        while (!stack.isEmpty()) {
            result.append(stack.poll());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("abc*de*f"));
    }
}
