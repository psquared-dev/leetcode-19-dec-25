package blind75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    // approach 2
    public static int[] productExceptSelf2(int[] nums) {
        // 1    2    3   4
        // 1    1    2   6
        // 24   12   4   1
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = i == 0 ? 1 : result[i - 1] * nums[i - 1];
        }

        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp = i == nums.length - 1 ? 1 : tmp * nums[i + 1];
            result[i] *= tmp;
        }

        return result;
    }

    // approach 1
    public static int[] productExceptSelf1(int[] nums) {
        // 1    2    3   4
        // 1    1    2   6
        // 24   12   4   1

        int[] preProd = new int[nums.length];
        int[] postProd = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            preProd[i] = i == 0 ? 1 : preProd[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            postProd[i] = i == nums.length - 1 ? 1 : postProd[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = preProd[i] * postProd[i];
        }

        System.out.println(Arrays.toString(preProd));
        System.out.println(Arrays.toString(postProd));

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(productExceptSelf1(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf2(new int[]{1, 2, 3, 4})));
    }
}
