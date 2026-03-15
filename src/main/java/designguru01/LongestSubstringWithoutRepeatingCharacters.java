package designguru01;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int left = 0, right = 0;

        while (right < str.length()) {
            while (hashSet.contains(str.charAt(right))) {
                hashSet.remove(str.charAt(left));
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            hashSet.add(str.charAt(right));
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
