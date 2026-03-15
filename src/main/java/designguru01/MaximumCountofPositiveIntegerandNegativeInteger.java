package designguru01;

public class MaximumCountofPositiveIntegerandNegativeInteger {
    public static int maximumCount(int[] nums) {
        int negativeCount = 0, positiveCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeCount++;
            } else if (nums[i] > 0) {
                positiveCount++;
            }
        }

        System.out.println(negativeCount);
        System.out.println(positiveCount);

        return Math.max(positiveCount, negativeCount);
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{
                -4, -3, -1, 0, 1, 3, 5, 7
        }));
    }
}
