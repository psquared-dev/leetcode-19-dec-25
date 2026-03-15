package practice;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }

            maxWealth = Math.max(sum, maxWealth);
        }

        return maxWealth;
    }

    public static void main(String[] args) {
        System.out.println(maximumWealth(new int[][]{
                {5, 2, 3},
                {0, 6, 7}
        }));

        System.out.println(maximumWealth(new int[][]{
                {1, 2},
                {3, 4},
                {5, 6},
        }));
    }
}
