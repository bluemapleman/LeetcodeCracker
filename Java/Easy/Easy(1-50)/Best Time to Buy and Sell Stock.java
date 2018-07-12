/*
# Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
```
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
```

Example 2:
```
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
```

- My Answer
*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月20日
 */
public class BestTimetoBuyandSellStock
{

    public static void main(String[] args)
    {
        int[] prices= {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    
    public static int maxProfit(int[] prices) {
        // First, jump over region showing descending trend
        int start=0;
        for(int i=0;i<prices.length-1;i++) {
            if(prices[i]<prices[i+1]) {
                start=i;
                break;
            }
            start++;
        }
        
        int max=Integer.MIN_VALUE;
        for(int i=start;i<prices.length-1;i++) {
            int buy=prices[i];
            for(int j=i+1;j<prices.length;j++) {
                int sell=prices[j];
                if(buy<sell) {
                    int delta=sell-buy;
                    if(delta>max)
                        max=delta;
                }
            }
        }
        if(max==Integer.MIN_VALUE)
            max=0;
        return max;
    }
}