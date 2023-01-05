package easy;

public class buy_sell_stocks {
    public static void main(String[] args) {
        int[] case1 = {7, 1, 5, 3, 6, 4};
        int t1 = 5;

        int[] case2 = {7, 6, 4, 3, 1};
        int t2 = 0;

        System.out.println("Case 1\nTarget: " + t1);
        System.out.println("Result: " + maxProfit(case1) + "\n");
        System.out.println("Case 2\nTarget: " + t2);
        System.out.println("Result: " + maxProfit(case2));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < prices.length; i++) {
            // change min if current day is less
			if(prices[i] < min)
				min = prices[i];
            // compare if new min is better than previous
			else {
				max = Math.max(max, prices[i] - min);
			}
		}
		
		return max;
    }
}
