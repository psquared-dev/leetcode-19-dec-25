package designguru01;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinimumCosttoConnectSticks {
    public static int connectSticks(int[] sticks) {
            int cost = 0;
            PriorityQueue<Integer> queue = Arrays.stream(sticks)
                    .boxed()
                    .collect(Collectors.toCollection(PriorityQueue::new));


            while (!queue.isEmpty()){
                int first = queue.poll();

                if(!queue.isEmpty()){
                    int second = queue.poll();
                    cost += first + second;
                    queue.add(first + second);
                }
            }

            return cost;
    }

    public static void main(String[] args) {
//        System.out.println(connectSticks(new int[]{2, 4, 3}));
        System.out.println(connectSticks(new int[]{1, 8, 2, 5}));
//        System.out.println(connectSticks(new int[]{5, 5, 5, 5}));
    }
}
