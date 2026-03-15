package designguru01;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static String frequencySort(String str) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i), 1, (oldCount, newCount) -> oldCount + 1);
        }

        List<Map.Entry<Character, Integer>> entries = map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .toList();

        for (Map.Entry<Character, Integer> entry : entries) {
            String s = String.valueOf(entry.getKey()).repeat(entry.getValue());
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("trersesess"));
    }
}
