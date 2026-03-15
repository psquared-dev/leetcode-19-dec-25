package practice;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class PalindromeCheckusingQueue {
    public static boolean checkPalindrome(String s) {
        LinkedList<Character> queue = s.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(queue);

        while (!queue.isEmpty()) {
            Character first = queue.pollFirst();
            Character last = queue.pollLast();

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
//        System.out.println(checkPalindrome("madam"));
//        System.out.println(checkPalindrome("openai"));
        System.out.println(checkPalindrome("A man a plan a canal Panama"));
    }
}
