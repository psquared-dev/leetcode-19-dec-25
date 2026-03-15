package blind75;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String str, String target) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> sourceMap = new HashMap<>();
        int matchCount = 0;
        int desiredMatchCount;
        int left = 0, right = 0;
        boolean acquire = true;
        String result = "";

        // create map
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            targetMap.merge(c, 1, (oldCount, newCount) -> oldCount + 1);
        }

        desiredMatchCount = targetMap.values().stream().mapToInt(Integer::intValue).sum();

        while (right < str.length()) {
            while (right < str.length()) {
                // acquire
                char rightChar = str.charAt(right);
                if (targetMap.containsKey(rightChar)) {
                    int rightCount = sourceMap.merge(rightChar, 1, (oldCount, newCount) -> oldCount + 1);

                    if (targetMap.get(rightChar) >= rightCount) {
                        matchCount++;
                    }
                }

                if (matchCount == desiredMatchCount) {
                    acquire = false;
                    break;
                }

                right++;
            }

            if (matchCount == desiredMatchCount) {
                if (result.isEmpty() || result.length() > right - left + 1) {
                    result = str.substring(left, right + 1);
                }
            }

            while (!acquire) {
                // release
                char leftChar = str.charAt(left);

                if (sourceMap.containsKey(leftChar)) {
                    int leftCount = sourceMap.get(leftChar) - 1;

                    if (leftCount == 0) {
                        sourceMap.remove(leftChar);
                    } else {
                        sourceMap.put(leftChar, leftCount);
                    }

                    if (targetMap.get(leftChar) > leftCount) {
                        matchCount--;
                    }
                }
                left++;

                if (matchCount != desiredMatchCount) {
                    right++;
                    acquire = true;
                    break;
                }

                if (result.isEmpty() || result.length() > right - left + 1) {
                    result = str.substring(left, right + 1);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
