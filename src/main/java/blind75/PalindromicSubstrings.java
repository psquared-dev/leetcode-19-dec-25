package blind75;

public class PalindromicSubstrings {
    public static int countSubstrings(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int left, right;

            left = i;
            right = i;
            while (left >= 0 && right < str.length()) {
                if(str.charAt(left) != str.charAt(right)){
                    break;
                }
                count++;
                left--;
                right++;
            }


            left = i;
            right = i + 1;
            while (left >= 0 && right < str.length()) {
                if(str.charAt(left) != str.charAt(right)){
                    break;
                }
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("fdsklf"));
    }
}
