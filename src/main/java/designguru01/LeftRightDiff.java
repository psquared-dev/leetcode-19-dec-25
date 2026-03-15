package designguru01;

import java.util.Arrays;

public class LeftRightDiff {
    public static int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        // TODO: Write your code here

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            leftSum[i] = sum;
            sum += nums[i];
        }

        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum[i] = sum;
            sum += nums[i];
        }

        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));

        for (int i = 0; i < nums.length; i++) {
            differenceArray[i] = Math.abs(leftSum[i] -rightSum[i]);
        }

        return differenceArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDifferenceArray(new int[]{2, 5, 1, 6, 1})));
    }
}
