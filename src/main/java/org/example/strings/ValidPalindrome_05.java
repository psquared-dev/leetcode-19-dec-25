package org.example.strings;

// https://leetcode.com/problems/valid-palindrome/description/

import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ValidPalindrome_05 {
    // approach 4
    public static boolean find4(String str) {
        String input = str.chars()
                .mapToObj(i -> (char) i)
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .map(String::valueOf)
                .collect(Collectors.joining());

        int left = 0;
        int right = input.length() - 1;

        // radar
        while (left <= right){
            char ch1 = input.charAt(left);
            char ch2 = input.charAt(right);

            if(ch1 != ch2){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // approach 3
    public static boolean find3(String str) {
        String input = str.chars()
                .mapToObj(i -> (char) i)
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .map(String::valueOf)
                .collect(Collectors.joining());

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            deque.offer(c);
        }

        System.out.println(deque);

        while (!deque.isEmpty()){
            Character first = deque.pollFirst();
            if(first == null){
                return true;
            }

            Character last = deque.pollLast();
            if(last == null){
                return true;
            }

            if(first != last){
                return false;
            }
        }

        return true;
    }

    // approach 2
    public static boolean find2(String str) {
        String input = str.chars()
                .mapToObj(i -> (char) i)
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .map(String::valueOf)
                .collect(Collectors.joining());

        String reversed = new StringBuilder(input).reverse().toString();

        return input.equals(reversed);
    }

    // approach 1
    public static boolean find1(String str) {
        String input = str.chars()
                .mapToObj(i -> (char) i)
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .map(String::valueOf)
                .collect(Collectors.joining());

        String reversed = Stream.iterate(input.length() - 1, i -> i >= 0, i -> i - 1)
                .map(input::charAt)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return input.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println(find4("aba"));
        System.out.println(find4("A man, a plan, a canal: Panama"));
        System.out.println(find4("race a car"));
        System.out.println(find4(" "));
        System.out.println(find4("0P"));
    }
}
