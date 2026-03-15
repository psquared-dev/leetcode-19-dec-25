package designguru01;

public class Searcha2DMatrixII {
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int row = 0,
                col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[0][0] <= target && target <= matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int ROWS = matrix.length - 1;
        int COLS = matrix[0].length - 1;

        for (int row = 0; row <= ROWS; row++) {
            int left = 0,
                    right = COLS;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (matrix[row][mid] == target) {
                    return true;
                }

                if (matrix[row][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(searchMatrix2(new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        }, 5));

//        System.out.println(searchMatrix1(new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        }, 20));
//
//        System.out.println(searchMatrix1(new int[][]{
//                {-5},
//        }, -5));
//
        System.out.println(searchMatrix2(new int[][]{
        }, 1));
    }
}
