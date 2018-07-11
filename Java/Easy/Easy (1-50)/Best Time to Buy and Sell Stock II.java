/*
# Best Time to Buy and Sell Stock II

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

- My Answer

*/
package easy;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月20日
 */
public class BestTimetoBuyandSellStockII
{
    public static void main(String[] args)
    {
        int[] prices= {5,2,3,2,6,6,2,9,1,0,7,4,5,0};//{3,2,6,5,0,3};//{3,3,5,0,0,3,1,4};//{9,8,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8};
        System.out.println(maxProfit(prices));
    }
    
    public static int maxProfit(int[] prices) {
        int start=getAscendingStart(prices, 0);
        int max=Integer.MIN_VALUE;
        int sumProfit=0;
        int heapIndex=0;
        heapIndex=getHeapIndex(prices, start);
        while((heapIndex=getHeapIndex(prices, start))<prices.length) {
            sumProfit+=prices[heapIndex]-prices[start];
            start=getAscendingStart(prices, heapIndex+1);
        }
        
        if(sumProfit>max)
            max=sumProfit;
        
        return max;
         
    }
    
    
    public static int getAscendingStart(int[] prices,int start) {
        int ascendingStart=start;
        
        for(;ascendingStart<prices.length-1;ascendingStart++) {
            if(prices[ascendingStart]<prices[ascendingStart+1])
                break;
        }
        
        return ascendingStart;
    }
    
    public static int getHeapIndex(int prices[],int start) {
        for(;start<prices.length-2;start++) {
            if(prices[start]<=prices[start+1] && prices[start+1]>prices[start+2]) {
                break;
            }
        }
        return start+1;
    }
}

