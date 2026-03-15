package designguru01;

import java.util.Arrays;

public class LargestPalindromicNumber {
    public static String largestPalindromic(String num) {
        final int ARR_SIZE = 10;
        int[] freq = new int[ARR_SIZE];
        StringBuilder left = new StringBuilder();
        StringBuilder right;
        String center = "";

        for (int i = 0; i < num.length(); i++) {
            freq[num.charAt(i) - '0']++;
        }

        System.out.println(Arrays.toString(freq));

        for (int i = ARR_SIZE - 1; i >= 0; i--) {
            int pair = freq[i] / 2;
            freq[i] -= pair * 2;

            if (i == 0 && left.isEmpty()) {
                continue;
            }

            if (pair > 0) {
                left.append(String.valueOf(i).repeat(pair));
            }
        }

        for (int i = ARR_SIZE - 1; i >= 0; i--) {
            if (freq[i] == 1) {
                center = String.valueOf(i);
                break;
            }
        }

        System.out.println(Arrays.toString(freq));

        if (left.isEmpty() && center.isEmpty()) {
            center = "0";
        }

        right = new StringBuilder(left).reverse();

        System.out.println(left);
        System.out.println(right);

        return left.append(center).append(right).toString();
    }

    public static void main(String[] args) {
        System.out.println(largestPalindromic("0000"));
//        System.out.println(largestPalindromic("00011"));
//        System.out.println(largestPalindromic("00009"));
//        System.out.println(largestPalindromic("323211444"));
//        System.out.println(largestPalindromic("998877"));
//        System.out.println(largestPalindromic("54321"));
//        System.out.println(largestPalindromic("7775553332219"));
//        System.out.println(largestPalindromic("3135518799"));
    }
}
