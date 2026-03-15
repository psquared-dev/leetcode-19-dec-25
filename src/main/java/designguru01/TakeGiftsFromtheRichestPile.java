package designguru01;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TakeGiftsFromtheRichestPile {
    public static int remainingGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = Arrays.stream(gifts)
                .boxed()
                .collect(Collectors.toCollection(() -> new PriorityQueue<Integer>((o1, o2) -> o2 - o1)));

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            int polled = queue.poll();
            int leave = (int) Math.sqrt(polled);
            queue.add(leave);
        }

        return queue.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        System.out.println(remainingGifts(new int[]{4, 9, 16}, 2));
        System.out.println(remainingGifts(new int[]{1, 2, 3}, 1));
    }
}
