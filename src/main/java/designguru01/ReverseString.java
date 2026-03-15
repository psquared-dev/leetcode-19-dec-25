package designguru01;

import java.util.LinkedList;

public class ReverseString {

    public static String reverseString(String s) {
        // ToDo: Write Your Code Here.

        StringBuilder result = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()){
            result.append(stack.poll());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcd"));
    }
}
