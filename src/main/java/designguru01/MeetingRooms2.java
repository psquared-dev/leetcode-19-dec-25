package designguru01;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(intervals));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (!queue.isEmpty() && curr[0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(curr[1]);
        }

        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{
                {30, 35}, {10, 15}, {20, 25}
        }));

        System.out.println(minMeetingRooms(new int[][]{
                {10, 20}, {15, 25}, {24, 30}, {5, 14}, {22, 28}, {1, 4}, {27, 35}
        }));

        System.out.println(minMeetingRooms(new int[][]{
                {0, 5}, {5, 10}, {10, 15}
        }));

        System.out.println(minMeetingRooms(new int[][]{}));


    }
}
