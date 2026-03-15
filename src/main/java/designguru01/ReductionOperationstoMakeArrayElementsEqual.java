package designguru01;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ReductionOperationstoMakeArrayElementsEqual {
    public static int reductionOperations(int[] nums) {
        int ops = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 0; i--) {
            int l = nums[i];
            int sl = nums[i - 1];

            if(l != sl){
                ops += nums.length - i;
            }
        }

        return ops;
    }

    public static void main(String[] args) {
        System.out.println(reductionOperations(new int[]{3, 5, 5, 2}));
        System.out.println(reductionOperations(new int[]{11, 9, 7, 5, 3}));
        System.out.println(reductionOperations(new int[]{8, 8, 8, 8}));
    }
}
