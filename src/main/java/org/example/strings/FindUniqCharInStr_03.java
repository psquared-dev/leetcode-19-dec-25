package org.example.strings;

// https://leetcode.com/problems/first-unique-character-in-a-string/description/

import java.util.HashMap;

public class FindUniqCharInStr_03 {
    public static int find(String str){
        HashMap<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            counter.merge(ch, 1, Integer::sum);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(counter.get(ch) == 1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find("leetcode"));
        System.out.println(find("loveleetcode"));
        System.out.println(find("aabb"));
    }
}
