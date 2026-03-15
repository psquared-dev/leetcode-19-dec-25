package practice;

import java.util.Arrays;

public class RowWithMaximumOnes {
    public static int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;

        for (int i = 0; i < mat.length; i++) {
            int currOnesCount = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    currOnesCount++;
                }
            }

            if (currOnesCount > maxOnesCount) {
                maxOnesCount = currOnesCount;
                maxOnesIdx = i;
            }
        }

        return new int[]{maxOnesIdx, maxOnesCount};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxOnesRow(new int[][]{
                {0, 1, 1},
                {0, 1, 1},
                {1, 1, 1}
        })));

        System.out.println(Arrays.toString(findMaxOnesRow(new int[][]{
                {1, 0},
                {1, 1},
                {0, 1}
        })));
    }
}
