package designguru01;

import java.util.HashSet;

public class RemovingMinimumandMaximumFromArray {
    public static int minMoves(int[] nums) {
        int maxElemIdx = 0, minElemIdx = 0, ops = 0;
        int minIdx = Integer.MAX_VALUE, maxIdx = Integer.MIN_VALUE;

        int leftOps = 0,
                rightOps = 0,
                splitOps = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[minElemIdx] > nums[i]) {
                minElemIdx = i;
            }

            if (nums[maxElemIdx] < nums[i]) {
                maxElemIdx = i;
            }
        }

        if(maxElemIdx > minElemIdx){
            minIdx = minElemIdx;
            maxIdx = maxElemIdx;
        } else {
            minIdx = maxElemIdx;
            maxIdx = minElemIdx;
        }

        leftOps = maxIdx + 1;
        rightOps = nums.length - minIdx;
        splitOps = (minIdx + 1) + nums.length - maxIdx;

        System.out.println("minElemIdx: " + minElemIdx + " maxElemIdx: " + maxElemIdx);
        System.out.println("minIdx: " + minIdx + " maxIdx: " + maxIdx);

        System.out.println("leftOps: " + leftOps);
        System.out.println("rightOps: " + rightOps);
        System.out.println("splitOps: " + splitOps);

        return Math.min(splitOps, Math.min(leftOps, rightOps));
    }

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{
                3, 2, 5, 1, 4
        }));
////
//        System.out.println(minMoves(new int[]{
//                7, 5, 6, 8, 1
//        }));
////
//        System.out.println(minMoves(new int[]{
//                2, 4, 10, 1, 3, 5
//        }));
//
//        System.out.println(minMoves(new int[]{
//                5, 3, 2, 4, 1
//        }));
//
//        System.out.println(minMoves(new int[]{
//                3, 5, 2, 1, 4
//        }));

//        System.out.println(minMoves(new int[]{
//                1
//        }));

        System.out.println(minMoves(new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        }));


    }
}
