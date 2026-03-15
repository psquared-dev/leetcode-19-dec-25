package designguru01;

import java.util.LinkedList;

public class MinimumAddtoMakeParenthesesValid {
    public static int minAddToMakeValid(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        int closing = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else {
                Character polled = stack.poll();

                if (polled == null) {
                    closing++;
                }
            }
        }

        return stack.size() + closing;
    }

    public static void main(String[] args) {
//        System.out.println(minAddToMakeValid("(()"));
//        System.out.println(minAddToMakeValid("))(("));
        System.out.println(minAddToMakeValid("(()())("));
    }
}
