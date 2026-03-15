package designguru01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxofAllSubarraysofSizeK {
    public static List<Integer> printMax(int[] arr, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int right = 0; right < arr.length; right++) {
            int left = right - k + 1;

            if (left >= 0 && !queue.isEmpty() && queue.peekFirst() < left) {
                // if left out of bound, remove
                queue.pollFirst();
            }

            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[right]) {
                // if curr is greater than the rear of the queue
                queue.pollLast();
            }

            queue.addLast(right);

            if (left >= 0) {
                result.add(arr[queue.peekFirst()]);
            }

        }

        return result;
    }
//    public static List<Integer> printMax(int[] arr, int k) {
//        List<Integer> result = new ArrayList<>();
//
//        for (int i = 0; i <= arr.length - k; i++) {
//            int currMax = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                currMax = Math.max(currMax, arr[j]);
//            }
//
//            result.add(currMax);
//        }
//
//        result.stream().mapToInt(Integer::intValue).toArray();
//
//        return result;
//    }

    public static void main(String[] args) {
        System.out.println(printMax(new int[]{
                1, 2, 3, 1, 4, 5, 2, 3, 6
        }, 3));

//        System.out.println(printMax(new int[]{
//                8, 5, 10, 7, 9, 4, 15, 12, 90, 13
//        }, 4));
//
//        System.out.println(printMax(new int[]{
//                12, 1, 78, 90, 57
//        }, 3));
    }
}
