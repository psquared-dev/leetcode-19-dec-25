package practice;

public class MatrixDiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int totalSum = 0;

        for (int i = 0; i < mat.length; i++) {
            totalSum += mat[i][i];
        }

//        System.out.println(totalSum);

        for (int row = 0, col = mat.length - 1; row < mat.length; row++, col--) {
            totalSum += mat[row][col];
        }

        if (mat.length % 2 != 0) {
            totalSum -= mat[mat.length / 2][mat.length / 2];
        }

        return totalSum;
    }

    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));

        System.out.println(diagonalSum(new int[][]{
                {1, 0},
                {0, 1},
        }));

        System.out.println(diagonalSum(new int[][]{
                {5},
        }));
    }
}
