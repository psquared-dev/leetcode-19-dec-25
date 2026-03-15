package designguru01;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CountingElements {
    public static int countElements(int[] arr) {
        int count = 0;
        Set<Integer> hashSet = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int i = 0; i < arr.length; i++) {
            if (hashSet.contains(arr[i] + 1)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countElements(new int[]{4, 3, 1, 5, 6}));
    }
}
