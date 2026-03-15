package designguru02;

public class BestTimetoBuyandSell {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0,
                left = 0,
                right = 1;

        while (left <= right && right < prices.length) {
            int currProfit = prices[right] - prices[left];

            if (currProfit < 0) {
                left = right;
            }

            maxProfit = Math.max(currProfit, maxProfit);

            right++;
        }


        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(maxProfit(new int[]{8, 6, 5, 2, 1}));
        System.out.println(maxProfit(new int[]{1, 2}));
    }
}
