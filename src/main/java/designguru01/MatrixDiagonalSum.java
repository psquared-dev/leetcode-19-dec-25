package designguru01;

public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int totalSum = 0;  // Initialize the total sum
        // ToDo: Write Your Code Here.

        for (int i = 0; i < mat.length; i++) {
            totalSum  += mat[i][i];
        }

        for (int row = mat.length - 1, col = 0 ; row >= 0; row--, col++) {
            totalSum  += mat[row][col];
        }

        if(mat.length % 2 != 0){
            totalSum -= mat[mat.length / 2][mat.length / 2];
        }

        System.out.println(totalSum);

        return totalSum;  // Return the calculated total sum
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
