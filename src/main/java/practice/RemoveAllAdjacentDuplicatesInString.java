package practice;

import java.util.Collections;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!stack.isEmpty() && stack.peek().equals(ch)) {
                stack.poll();
            } else {
                stack.push(ch);
            }
        }

//        System.out.println(stack);
        Collections.reverse(stack);

        while (!stack.isEmpty()){
            result.append(stack.poll());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
