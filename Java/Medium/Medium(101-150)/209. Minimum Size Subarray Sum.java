
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans[]=new int[nums.length];
        for(int i=0;i<ans.length;i++) {
            int temp=0;
            for(int j=i;j>=0;j--) {
                temp+=nums[j];
                if(temp>=s) {
                    ans[i]=i-j+1;
                    break;
                }
            }
        }
        
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<ans.length;i++)
            if(ans[i]!=0 && ans[i]<minLen)
                minLen=ans[i];
        
        if(minLen==Integer.MAX_VALUE)
            minLen=0;
        
        return minLen;
    }
}