package blind75;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String str) {
        int left = 0, right = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int maxLen = 0;

        while (left <= right && right < str.length()) {
            char c = str.charAt(right);

            while (hashSet.contains(c)) {
                hashSet.remove(str.charAt(left));
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
            hashSet.add(c);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew4"));
    }
}
