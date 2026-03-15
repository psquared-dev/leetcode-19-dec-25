package org.example.strings;

// https://www.geeksforgeeks.org/dsa/print-characters-frequencies-order-occurrence/

import java.util.LinkedHashMap;
import java.util.Map;

public class CharFreqInOrderOfOccur_02 {
    public static String find(String str) {
        Map<Character, Integer> counter = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            counter.merge(ch, 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(find("geeksforgeeks"));
        System.out.println(find("elephant"));
    }
}
