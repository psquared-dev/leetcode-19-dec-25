package designguru01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestNiceSubstring {

// approach 1

//    public static boolean isNice(String str) {
//        Set<Character> hashSet = str.chars()
//                .mapToObj(ch -> (char) ch)
//                .collect(Collectors.toSet());
//
//        for (Character c : hashSet) {
//            if (!(hashSet.contains((char) (c - 32)) || hashSet.contains((char) (c + 32)))) {
//                return false;
//            }
//        }
//
//        return true;
//    }

//    public static String findLongestNiceSubstring(String str) {
//        String result = "";
//
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i + 1; j < str.length(); j++) {
//                String substr = str.substring(i, j + 1);
//                if (isNice(substr) && result.length() < substr.length() ) {
//                    result = substr;
//                }
//            }
//        }
//        return result;
//    }

    public static String findLongestNiceSubstring(String str) {
        return checkNice(str);
    }

    private static String checkNice(String str) {
        if (str.length() < 2) {
            return "";
        }

        Set<Character> hashSet = str.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.toSet());

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(hashSet.contains(Character.toLowerCase(ch)) &&
                    hashSet.contains(Character.toUpperCase(ch)))) {
                String left = checkNice(str.substring(0, i));
                String right = checkNice(str.substring(i + 1));

                return left.length() >= right.length() ? left : right;
            }
        }

        return str;
    }

    public static void main(String[] args) {
//        System.out.println(findLongestNiceSubstring("BbCcXxY"));
//        System.out.println(findLongestNiceSubstring("aZAbcD"));
        System.out.println(findLongestNiceSubstring("YazaAay"));
    }
}
