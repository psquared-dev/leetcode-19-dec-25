package designguru01;

import java.util.Arrays;
import java.util.HashMap;

public class SortArraybyIncreasingFrequency {
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] numsCopy = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, (oldCount, newCount) -> oldCount + 1);
        }

        Arrays.sort(numsCopy, (a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                // if freq matches
                return b - a;
            } else {
                return map.get(a) - map.get(b);
            }
        });

        return Arrays.stream(numsCopy).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{4, 4, 6, 2, 2, 2})));
        System.out.println(Arrays.toString(frequencySort(new int[]{4, 4, 1, 2, 2})));
    }
}
