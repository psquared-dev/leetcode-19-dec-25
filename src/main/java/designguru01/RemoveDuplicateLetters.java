package designguru01;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String str) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        HashSet<Character> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            freqMap.merge(str.charAt(i), 1, (oldCount, newCount) -> oldCount + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!visited.contains(ch)) {
                while (!stack.isEmpty() &&
                        stack.peek() >= ch &&
                        freqMap.get(stack.peek()) > 0
                ) {
                    char popped = stack.pop();
                    visited.remove(popped);
                }
                stack.push(ch);
                visited.add(ch);
            }
            freqMap.computeIfPresent(ch, (c, count) -> count - 1);
        }

        Collections.reverse(stack);

        while (!stack.isEmpty()) {
            result.append(stack.poll());
        }

        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(removeDuplicateLetters("zabccde"));
//        System.out.println(removeDuplicateLetters("babac"));
//        System.out.println(removeDuplicateLetters("mnopmn"));
        System.out.println(removeDuplicateLetters("bbcaac"));

    }
}
