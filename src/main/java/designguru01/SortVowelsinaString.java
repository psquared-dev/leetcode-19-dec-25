package designguru01;

import java.util.*;

public class SortVowelsinaString {
    public static String countingSortVowels(String s) {
        ArrayList<Character> vowelsList = new ArrayList<>();
        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowelsSet.contains(Character.toLowerCase(ch))) {
                vowelsList.add(ch);
            }
        }

        List<Character> sortedVowels = vowelsList.stream()
                .sorted((o1, o2) -> (int) o1 - (int) o2)
                .toList();

        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (vowelsSet.contains(ch)) {
                result.append(sortedVowels.get(index));
                index++;
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countingSortVowels("gamE"));
        System.out.println(countingSortVowels("aEiOu"));
        System.out.println(countingSortVowels("DesIgnGurUs"));
        System.out.println(countingSortVowels("lEetcOde"));

    }
}
