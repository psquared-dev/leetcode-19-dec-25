package org.example.strings;

// https://leetcode.com/problems/longest-palindromic-substring/?envType=problem-list-v2&envId=string
// Sol: https://www.youtube.com/watch?v=XYQecbcd6_c

public class LongestPalindromicStr_06 {
    public static String find1(String str) {
        String result = "";
        int left;
        int right;
        for (int i = 0; i < str.length(); i++) {
            left = i;
            right = i;

            while (left >= 0 && right < str.length()) {
                if (str.charAt(left) != str.charAt(right)) {
                    break;
                }

                if (result.length() < str.substring(left, right + 1).length()) {
                    result = str.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < str.length()) {
                if (str.charAt(left) != str.charAt(right)) {
                    break;
                }

                if (result.length() < str.substring(left, right + 1).length()) {
                    result = str.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(find1("babad"));
        System.out.println(find1("racecar"));
        System.out.println(find1("abcde"));
        System.out.println(find1("bananas"));
        System.out.println(find1("cddc"));
        System.out.println(find1("abbcccba"));
    }
}
