package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int replacements = 0;
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if(prev[1] > curr[0]){
                // overlapping
                prev[1] = Math.min(prev[1], curr[1]);
                replacements++;
            } else {
                prev = curr;
            }
        }

        return replacements;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        }));

//        System.out.println(eraseOverlapIntervals(new int[][]{
//                {1, 2}, {2, 3}
//        }));
//
        System.out.println(eraseOverlapIntervals(new int[][]{
                {1, 2}, {1, 2}, {1, 2}
        }));
    }
}


