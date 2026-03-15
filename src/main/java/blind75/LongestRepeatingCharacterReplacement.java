package blind75;

import java.util.Arrays;
import java.util.OptionalInt;

public class LongestRepeatingCharacterReplacement {
    public static int findMostFreqChar(int[] counter) {
        OptionalInt max = Arrays.stream(counter).max();
        return max.orElse(0);
    }

    public static int characterReplacement(String str, int k) {
        int left = 0, right = 0;
        int maxReplacement = 0;
        int[] counter = new int[26];

        while (left <= right && right < str.length()) {
            char c = str.charAt(right);
            counter[c - 65]++;
            int wordLen = right - left + 1;
            if (wordLen - findMostFreqChar(counter) > k) {
                counter[str.charAt(left) - 65]--;
                left++;
            }
            maxReplacement = Math.max(maxReplacement, right - left + 1);
            right++;
        }

        return maxReplacement;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
//        System.out.println(characterReplacement("ABAB", 2));
    }
}
