
/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


*/
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月12日
 */
public class ThreeSumClosest
{
    public static void main(String[] args)
    {
        int[] nums= {-1,0,1,1,55};
        System.out.println(threeSumClosest(nums, 3));
    }
    // This can be seen as variant of 3Sum
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int answer=0;
        for(int i=0;i<nums.length-2;i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                int lo=i+1,hi=nums.length-1,sum=target-nums[i];
                while(hi>lo) {
                    System.out.println("i:"+i+",lo:"+lo+",hi:"+hi);
                    int delta=Math.abs(nums[hi]+nums[lo]-sum);
                    if(delta==0) {
                        return target;
                    }else if(delta<min) {
                        answer=nums[i]+nums[hi]+nums[lo];
                        min=delta;
                    }
                    
                    if(nums[hi]+nums[lo]>sum)
                        hi--;
                    else
                        lo++;
                }
            }
        }
        return answer;
    }
}

