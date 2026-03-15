package blind75;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(intervals));
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prev = result.get(result.size() - 1);
            int[] curr = intervals[i];
            // start of curr is less than
            // the end of prev, means interval overl4apping
            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                result.add(curr);
            }
        }

//        System.out.println(Arrays.deepToString(result.toArray()));
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3}, {8, 10}, {15, 18}, {2, 6}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 4}, {4, 5}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {4, 7}, {1, 4}
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3}
        })));
    }
}
