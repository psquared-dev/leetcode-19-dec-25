package blind75;

public class MaxProfit {

    // approach 2
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = left + 1;

        while (right < prices.length){
            int currProfit = prices[right] - prices[left];
            if(currProfit < 0){
                left = right;
            }
            right++;
            maxProfit = Math.max(currProfit, maxProfit);
        }

        return maxProfit;
    }

    // approach 1
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int currProfit = prices[j] - prices[i];
                maxProfit = Math.max(currProfit, maxProfit);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
//        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{2,1,2,1,0,1,2}));
    }
}
