package designguru01;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int length = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        boolean hasOdd = false;

        for (int i = 0; i < s.length(); i++) {
            freqMap.merge(s.charAt(i), 1, (oldCount, newCount) -> oldCount + 1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                length += entry.getValue();
            } else {
                length += entry.getValue() - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) {
            length += 1;
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("applepie"));
        System.out.println(longestPalindrome("aabbcc"));
        System.out.println(longestPalindrome("bananas"));
        System.out.println(longestPalindrome("aaabbb"));
    }
}
