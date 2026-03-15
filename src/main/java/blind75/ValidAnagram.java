package blind75;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] letters1 = convertToArray(s);
        int[] letters2 = convertToArray(t);

        return Arrays.equals(letters1, letters2);
    }

    public static int[] convertToArray(String str){
        int[] letters = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            letters[c - 97]++;
        }

        return letters;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "anagram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
