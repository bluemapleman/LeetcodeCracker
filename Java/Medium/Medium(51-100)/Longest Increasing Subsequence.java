
/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,

Given [10, 9, 2, 5, 3, 7, 101, 18],The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?


*/
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class LongestIncreasingSubsequence
{
    // This answer from:https://leetcode.com/problems/longest-increasing-subsequence/discuss/127926/java
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        //新建一个数组T，用来标识nums元素前面有多少个连续小于他的，从1开始加
        //比如nums=[10,15,20,11,9,101] 
        //15前面10比他小，所以为2,20前面有10和15都比他小，所以为3，最后101前面有10,15,20这三个比他小，所以为4
        //那么T=[1,2,3,2,1,4]
        int[] T = new int[nums.length];
        Arrays.fill(T,1);
        
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    T[i] = Math.max(T[i],1+T[j]);
                }
            }
        }
        
        int res = 0;
        for(int i=0;i<T.length;i++){
            res = Math.max(res,T[i]);
        }
        return res;
    }
}

