
/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
- The length of the array is in range [1, 20,000].
- The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月15日
 */
public class SubarraySumEqualsK
{
    // recurrence
    public int subarraySum(int[] nums, int k) {
        if(nums.length==0)
            return 0;
        int ans[]=new int[nums.length];
        for(int i=0;i<ans.length;i++) {
            int sum=0;
            for(int x=0;i-x>=0;x++) {
                sum+=nums[i-x];
                if(sum==k)
                    ans[i]+=1;
            }
            if(i>=1)
                ans[i]+=ans[i-1];
        }
    
        return ans[ans.length-1];
    }
}

