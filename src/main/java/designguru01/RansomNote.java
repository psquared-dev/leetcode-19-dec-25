package designguru01;

import java.util.Arrays;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] noteArr = new int[26];
        int[] megazineArr = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            noteArr[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            megazineArr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int remainingChar = megazineArr[i] - noteArr[i];
            if(remainingChar < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("hello", "hellworld"));
        System.out.println(canConstruct("notes", "stoned"));
        System.out.println(canConstruct("apple", "pale"));
    }
}
