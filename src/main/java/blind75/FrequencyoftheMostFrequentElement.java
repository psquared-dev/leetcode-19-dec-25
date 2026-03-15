package blind75;

import java.util.Arrays;

public class FrequencyoftheMostFrequentElement {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        long total = nums[0];
        int left = 0, right = 0, freq = 0;

        while (left <= right && (long) right < nums.length) {
            int windowLen = right - left + 1;
            if ( (long) nums[right] * windowLen <= total + k) {
                freq = Math.max(windowLen, freq);
//                System.out.println(freq);
                right++;
                if(right == nums.length){
                    break;
                }
                total += nums[right];
            } else {
                total -= nums[left];
                left++;
            }
        }

        return freq;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1,1,1,2,2,4}, 2));
//        System.out.println(maxFrequency(new int[]{1, 4, 4}, 2));
//        System.out.println(maxFrequency(new int[]{1, 1, 1, 2, 2, 4}, 2));
//        System.out.println(maxFrequency(new int[]{1, 1, 1, 2, 2, 4}, 2));
//        System.out.println(maxFrequency(new int[]{1, 2, 3}, 3));
//        System.out.println(maxFrequency(new int[]{1, 3, 3}, 3));
//        System.out.println(maxFrequency(new int[]{4, 4, 4, 1}, 2));
//        System.out.println(maxFrequency(new int[]{10, 9, 9, 4, 8}, 5));
//        System.out.println(maxFrequency(new int[]{7, 7, 7, 8, 8, 9}, 4));
    }
}
