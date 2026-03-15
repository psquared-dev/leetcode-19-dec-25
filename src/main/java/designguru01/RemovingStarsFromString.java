package designguru01;

import java.util.Collections;
import java.util.LinkedList;

public class RemovingStarsFromString {
    public static String removeStars(String str) {
        // ToDo: Write Your Code Here.
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '*') {
                stack.poll();
            } else {
                stack.push(ch);
            }
        }

        Collections.reverse(stack);

        while (!stack.isEmpty()){
            result.append(stack.poll());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeStars("abc*de*f"));
    }
}
