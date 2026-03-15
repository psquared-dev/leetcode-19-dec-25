package designguru01;

import java.util.Arrays;

public class MaximumLengthofPairChain {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(pairs));

        int[] curr = pairs[pairs.length - 1];
        int count = 0;

        for (int i = pairs.length - 1; i >= 0; i--) {
            if (pairs[i][1] < curr[0]) {
                count++;
                curr = pairs[i];
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{
                {1, 2}, {3, 4}, {2, 3}
        }));
//
        System.out.println(findLongestChain(new int[][]{
                {5, 6}, {1, 2}, {8, 9}, {2, 3}
        }));

        System.out.println(findLongestChain(new int[][]{
                {7, 8}, {5, 6}, {1, 2}, {3, 5}, {4, 5}, {2, 3}
        }));

        System.out.println(findLongestChain(new int[][]{
                {10, 20}, {1, 10}, {2, 9}, {3, 8}, {4, 7}, {5, 6}
        }));


    }
}
