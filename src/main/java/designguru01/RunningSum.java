package designguru01;

import java.util.Arrays;

public class RunningSum {

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{2, 3, 5, 1, 6})));
    }
}
