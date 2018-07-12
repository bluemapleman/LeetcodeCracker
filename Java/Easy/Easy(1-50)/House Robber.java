/*
# House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

- My Answer

*/
package easy1;

import java.util.Arrays;

import com.mysql.fabric.xmlrpc.base.Array;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月24日
 */
public class HouseRobber
{
    public static void main(String[] args)
    {
        int[] nums= {1,2,3,4,5,6};
        System.out.println(rob(nums));
    }
    
    // When adding n+1 house(number) to street(array) with #(n) houses(numbers), we only need to consider two cases:
    // 1: combine all possible houses' money with new house's money;
    // 2: combine all possible houses' money without new house;
    
    // Forward Iteration instead of Rcursion can effectively reduce time cose. (Dynamic Programming v.s. Recursive Method)
    public static int rob(int[] nums) {
        int len=nums.length;
        int[] solutions=new int[len];
        switch(len) {
            case 0:return 0;
            case 1:return nums[0];
            case 2:return Math.max(nums[0], nums[1]);
            case 3:return Math.max(nums[1],nums[0]+nums[2]);
            default:solutions[0]=nums[0];solutions[1]=Math.max(nums[0], nums[1]);solutions[2]=Math.max(nums[1],nums[0]+nums[2]);
        }
        for(int i=3;i<len;i++) {
            solutions[i]=Math.max(solutions[i-1], solutions[i-2]+nums[i]);
        }
        return solutions[len-1];
    }
}
