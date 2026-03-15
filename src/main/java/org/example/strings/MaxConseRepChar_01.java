package org.example.strings;

// https://www.geeksforgeeks.org/dsa/maximum-consecutive-repeating-character-string/
// Solution: https://www.youtube.com/watch?v=qRNB8CV3_LU

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MaxConseRepChar_01 {

    // approach 1

    public static Map.Entry<Character, Integer> find1(String str) {
        int i = -1;
        int j = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (j < str.length()) {
            if (i == -1 || (str.charAt(i) != str.charAt(j))) {
                map.put(str.charAt(j), 1);
            } else {
                map.computeIfPresent(str.charAt(j), (character, oldCount) -> oldCount + 1);
            }
            i++;
            j++;
        }

        Optional<Map.Entry<Character, Integer>> first = map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .findFirst();

        return first.orElse(null);
    }

    // approach 2

    public static Map<Character, Integer> find2(String str) {
        if (str.isEmpty()) {
            throw new RuntimeException("string empty");
        }

        Character prevChar = null;
        int maxCount = 0;
        Character maxChar = null;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (prevChar != null && prevChar == currChar) {
                count++;
            } else {
                count = 1;
            }
            prevChar = currChar;
            if (maxCount < count) {
                maxCount = count;
                maxChar = currChar;
            }
        }

        return Map.of(maxChar, maxCount);
    }

    public static void main(String[] args) {
        System.out.println(find2("aaaabbcbbb"));
        System.out.println(find2("geeekkeeeee"));
        System.out.println(find2("avvvv"));
    }
}
