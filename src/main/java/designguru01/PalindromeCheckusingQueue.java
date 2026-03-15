package designguru01;

import java.util.ArrayDeque;

import static java.util.stream.Collectors.joining;

public class PalindromeCheckusingQueue {
    public static boolean checkPalindrome(String s) {
        // ToDo: Write Your Code Here.
        ArrayDeque<Character> queue = new ArrayDeque<>();

        String cleanStr = s.chars()
                .filter(x -> !Character.isWhitespace(x))
                .map(Character::toLowerCase)
                .mapToObj(x -> String.valueOf((char) x))
                .map(x -> x.replaceAll("[.,]", ""))
                .collect(joining());

        for (int i = 0; i < cleanStr.length(); i++) {
            queue.addLast(cleanStr.charAt(i));
        }

        while (!queue.isEmpty()) {
            Character first = queue.pollFirst();

            Character last = null;
            if (!queue.isEmpty()) {
                last = queue.pollLast();
            }

            if (last == null) {
                return true;
            }

            if (!first.equals(last)) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("madam"));
        System.out.println(checkPalindrome("openai"));
        System.out.println(checkPalindrome("A., man a plan a canal Panama"));
    }
}
