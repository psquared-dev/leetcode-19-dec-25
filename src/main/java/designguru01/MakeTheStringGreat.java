package designguru01;

import java.util.Collections;
import java.util.LinkedList;

public class MakeTheStringGreat {
    public static String makeGood(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.poll();
            } else {
                stack.push(ch);
            }
        }

        Collections.reverse(stack);

        while (!stack.isEmpty()) {
            result.append(stack.poll());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeGood("AaBCcdEeff"));
        System.out.println(makeGood("abBA"));
        System.out.println(makeGood("zzZZaAaAzZzZ"));
    }
}
