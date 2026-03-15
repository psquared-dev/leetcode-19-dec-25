package designguru02;

import java.util.Map;

public class RomantoInteger {
    public static int romanToInt(String str) {
        int result = 0;
        Map<Character, Integer> map = Map.<Character, Integer>of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int i = 0;
        while (i < str.length()) {
            char currChar = str.charAt(i);
            char nextChar = '\0';

            if (i + 1 < str.length()) {
                nextChar = str.charAt(i + 1);
            }

            if (currChar == 'I' && (nextChar == 'V' || nextChar == 'X') ||
                    currChar == 'X' && (nextChar == 'L' || nextChar == 'C') ||
                    currChar == 'C' && (nextChar == 'D' || nextChar == 'M')) {
                result += map.get(nextChar) - map.get(currChar);
                i = i + 2;
            } else {
                result += map.get(currChar);
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(romanToInt("LVIII"));
//        System.out.println(romanToInt("III"));
//        System.out.println(romanToInt("XLII"));
        System.out.println(romanToInt("CXCIV"));
    }
}
