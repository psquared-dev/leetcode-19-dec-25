package designguru01;

import java.util.*;

public class TopKFrequentNumbers {
    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, (oldCount, newCount) -> oldCount + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });

        queue.addAll(map.entrySet());

        System.out.println(queue);
//        System.out.println(queue.poll());

        for (int i = 0; i < k; i++) {
            topNumbers.add(queue.poll().getKey());
        }

        return topNumbers;
    }

    public static void main(String[] args) {
//        System.out.println(findTopKFrequentNumbers(new int[]{1, 3, 5, 12, 11, 12, 11}, 2));
//        System.out.println(findTopKFrequentNumbers(new int[]{5, 12, 11, 3, 11}, 2));
        System.out.println(findTopKFrequentNumbers(new int[]{1, 3, 5, 12, 12, 11, 12, 11}, 2));

    }
}
