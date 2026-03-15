package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxofAllSubarraysofSizek {
    public static List<Integer> printMax(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[queue.peekLast()] < arr[i]) {
                queue.removeLast();
            }

            int left = i + 1 - k;

            while (!queue.isEmpty() && queue.peekFirst() < left) {
                queue.removeFirst();
            }

            queue.addLast(i);

            if (left >= 0) {
                result.add(arr[queue.peekFirst()]);
            }

        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(printMax(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
//        System.out.println(printMax(new int[]{1}, 1));
//        System.out.println(printMax(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
//        System.out.println(printMax(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4));
//        System.out.println(printMax(new int[]{12, 1, 78, 90, 57}, 3));
//        System.out.println(printMax(new int[]{11, 10, 9, 8, 7}, 3));
        System.out.println(printMax(new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8}, 4));
    }
}
