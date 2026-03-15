package org.example.strings;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRep_04 {
    // abcabcbb
    // bacabcbb

    // approach 2
    public static int find2(String str) {
        int absMaxLen = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> hashSet = new HashSet<>();

        while (right < str.length()){
            char ch = str.charAt(right);
            while (hashSet.contains(ch)){
                hashSet.remove(str.charAt(left));
                left++;
            }
            absMaxLen = Math.max(absMaxLen, right - left + 1);
            right++;
            hashSet.add(ch);
        }

        return absMaxLen;
    }

    // approach 1
    public static int find1(String str) {
        if (str.length() == 1) {
            return 1;
        }

        int absMaxLen = 0, currMaxLen;
        int left = 0, right = 0;

        while (right < str.length()) {
            right = left;
            currMaxLen = 0;
            Set<Character> hashSet = new HashSet<>();
            while (right < str.length()) {
                char ch = str.charAt(right++);
                boolean added = hashSet.add(ch);
                if (!added) {
                    break;
                }
                currMaxLen++;
            }
            absMaxLen = Math.max(absMaxLen, currMaxLen);
            left++;
        }

        return absMaxLen;
    }

    public static void main(String[] args) {
        System.out.println(find2("abcabcbb"));
        System.out.println(find2("bbbbb"));
        System.out.println(find2("pwwkew"));
        System.out.println(find2(" "));
        System.out.println(find2("au"));
        System.out.println(find2("bacabcbb"));
    }
}
