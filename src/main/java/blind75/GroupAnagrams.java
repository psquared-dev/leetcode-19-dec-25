package blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String charFreq = findCharFreq(str);
            map.computeIfAbsent(charFreq, k -> new ArrayList<>()).add(str);
        }

        return map.values().stream().toList();
    }

    public static String findCharFreq(String str) {
        int[] letters = new int[26];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            letters[c - 97]++;
        }

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 0) {
                continue;
            }
            result.append((char) (i + 97))
                    .append(letters[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
