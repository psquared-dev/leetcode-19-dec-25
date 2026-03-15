package designguru01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueNumberofOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            map.merge(arr[i], 1, (oldCount, newCount) -> oldCount + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            boolean added = set.add(entry.getValue());
            if (!added) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{4, 5, 4, 6, 6, 6}));
        System.out.println(uniqueOccurrences(new int[]{7, 8, 8, 9, 9, 9, 10, 10}));
    }
}
