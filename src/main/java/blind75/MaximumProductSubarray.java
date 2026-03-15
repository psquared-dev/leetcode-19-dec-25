package blind75;

public class MaximumProductSubarray {

    /*
    [-2, 3, -4]
        maxP = -2
        minP = -2
        result = -2

        3, 3 * -2, 3 * -2
        3, -6, -6
        maxP = 3
        minP = -6
        result = 3

        -4, -4 * 3, -4 * -6
        -4, -12, 24
        maxP = 24
        minP = -12
        max = 24

     */
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(nums[i] * maxProd, nums[i] * minProd));
            int tempMin = Math.min(nums[i], Math.min(nums[i] * maxProd, nums[i] * minProd));

            maxProd = tempMax;
            minProd = tempMin;

            result = Math.max(maxProd, result);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
}
