package designguru01;

public class SearchA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int rowToSearch = -1,
                left = 0,
                right = ROWS - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][COLS - 1]) {
                rowToSearch = mid;
                break;
            }

            if (matrix[mid][COLS - 1] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (rowToSearch == -1) {
            return false;
        }

        System.out.println(rowToSearch);

        left = 0;
        right = COLS - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[rowToSearch][mid] == target) {
                return true;
            }

            if (matrix[rowToSearch][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 5));
    }
}
