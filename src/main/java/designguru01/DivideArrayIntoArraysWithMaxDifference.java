package designguru01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {
    public static List<List<Integer>> divideArray(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 3) {

            if (nums[i + 2] - nums[i] > k) {
                return List.of();
            }

            result.add(List.of(nums[i], nums[i + 1], nums[i + 2]));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{
                2, 6, 4, 9, 3, 7, 3, 4, 1
        }, 3));

        System.out.println(divideArray(new int[]{
                10, 12, 15, 20, 25, 30
        }, 10));

        System.out.println(divideArray(new int[]{
                1, 2, 4, 5, 9, 10
        }, 1));

        System.out.println(divideArray(new int[]{
                2, 4, 2, 2, 5, 2
        }, 2));

    }
}
