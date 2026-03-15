package designguru01;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;  // Initialize maxWealth to 0
        // ToDo: Write Your Code Here.

        int sum;
        for (int i = 0; i < accounts.length; i++) {
            sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
               sum += accounts[i][j];
            }

            maxWealth =  Math.max(maxWealth, sum);
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
