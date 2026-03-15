package designguru01;

import java.util.Arrays;

public class RowWithMaximumOnes {
    public static int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;
        // ToDo: Write Your Code Here.

        int onesCount = 0;

        for (int row = 0; row < mat.length; row++) {
            onesCount = 0;
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 1) {
                    onesCount++;
                }
            }

            if (maxOnesCount < onesCount) {
                maxOnesCount = onesCount;
                maxOnesIdx = row;
            }
        }

        return new int[]{maxOnesIdx, maxOnesCount};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxOnesRow(new int[][]{
                {1, 0},
                {1, 1},
                {0, 1}
        })));

        System.out.println(Arrays.toString(findMaxOnesRow(new int[][]{
                {1, 0, 1},
                {0, 0, 1},
                {1, 1, 0}
        })));
    }
}
