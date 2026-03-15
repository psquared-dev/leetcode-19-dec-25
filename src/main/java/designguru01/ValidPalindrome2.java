package designguru01;

public class ValidPalindrome2 {
    public static boolean isPalindromePossible(String str) {
        int left = 0, right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return isPalindrome(str.substring(left + 1, right + 1)) ||
                        isPalindrome(str.substring(left, right));
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePossible("abeccdeba"));
//        System.out.println(isPalindrome("abccba"));
//        System.out.println(isPalindrome("abcdcba"));
    }
}
