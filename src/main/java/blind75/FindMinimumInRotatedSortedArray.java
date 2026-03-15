package blind75;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        System.out.println(Arrays.toString(nums));

        int left = 0,
                right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right){
            int mid = (left + right) / 2;
            int currMin;

            if(nums[left] <= nums[mid]){
                // left is sorted
                currMin = nums[left];
                left = mid + 1;
            } else {
                // right is sorted
                currMin = nums[mid];
                right = mid - 1;
            }

            min = Math.min(currMin, min);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 1, 2, 3}));
    }
}

