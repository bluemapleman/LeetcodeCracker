
/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:

You may assume that you have an infinite number of each kind of coin.


*/
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月6日
 */
public class CoinChange
{
    // One of most typical DP problem
    // Define state: for m amount, we need at least arr[m] coins.
    // transition: arr[m+1]=min{arr[m+1-ki]+1} (ki means all possible coins of different face value)
    // initial state: arr[0]=0,...,arr[kimin]=1
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int miniCoin=coins[0];
        
        if(amount==0)
            return 0;
        if(amount<miniCoin)
            return -1;
        
        int[] arr=new int[amount+1];        
        Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i=0;i<miniCoin;i++)
            arr[i]=-1;
        arr[0]=0;
        arr[miniCoin]=1;
        
        for(int i=miniCoin+1;i<arr.length;i++) {
            for(Integer coin:coins) {
                if(i-coin>=0) {
                    if(arr[i-coin]!=-1)
                        arr[i]=Math.min(arr[i], arr[i-coin]+1);
                }
            }
            // no solution for amount
            if(arr[i]==Integer.MAX_VALUE)
                arr[i]=-1;
        }
        for(Integer ans:arr)
            System.out.print(ans+" ");
        System.out.println();
            
        return arr[amount];
    }
}

