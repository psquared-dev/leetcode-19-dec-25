package designguru01;

public class MaximumNumberofBalloons {
    public static int maxNumberOfBalloons(String text) {
        String word = "balloon";
        int count = Integer.MAX_VALUE;

        int[] wordCountArr = new int[26];
        int[] textCountArr = new int[26];

        for (int i = 0; i < word.length(); i++) {
            wordCountArr[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < text.length(); i++) {
            textCountArr[text.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (wordCountArr[i] != 0) {
                count = Math.min(count, textCountArr[i] / wordCountArr[i]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("balloonballoon"));
        System.out.println(maxNumberOfBalloons("bbaall"));
        System.out.println(maxNumberOfBalloons("balloonballoooon"));
    }
}
