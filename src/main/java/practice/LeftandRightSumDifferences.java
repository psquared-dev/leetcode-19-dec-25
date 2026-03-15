package practice;

import java.util.Arrays;

public class LeftandRightSumDifferences {

    /**
     * [2,  5, 1, 6, 1  ]
     * [0,  2, 7, 8, 14 ]
     * [13, 8, 7, 1, 0  ]
     */

    public static int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            differenceArray[i] = sum;
            sum += nums[i];
        }

//        System.out.println(Arrays.toString(differenceArray));

        sum = 0;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            differenceArray[i] = Math.abs(differenceArray[i] - sum);
            sum += nums[i];
        }

//        System.out.println(Arrays.toString(differenceArray));

        return differenceArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDifferenceArray(new int[]{
                2, 5, 1, 6, 1
        })));

        System.out.println(Arrays.toString(findDifferenceArray(new int[]{
                3, 3, 3
        })));

        System.out.println(Arrays.toString(findDifferenceArray(new int[]{
                1, 2, 3, 4, 5
        })));
    }
}
