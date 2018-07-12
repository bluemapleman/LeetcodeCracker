
/*
[LC581](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/)

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:

1.Then length of the input array is in range [1, 10,000].

2.The input array may contain duplicates, so ascending order here means <=.


*/
package easy3;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class ShortestUnsortedContinuousSubarray
{
    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return 0;
        
        int[] copyNums=Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyNums);
        
        
        
        int start=0,end=nums.length-1;
        boolean startFlag=false,endFlag=false;
        for(int i=0;i<nums.length;i++) {
             if(nums[i]!=copyNums[i]) {
                 startFlag=true;
                 start=i;
                 break;
             }
        }
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i]!=copyNums[i]) {
                 endFlag=true;
                 end=i;
                 break;
             }
        }
        
        // The array is already sorted
        if(!startFlag && !endFlag)
            return 0;
        else
            return end-start+1;
    }
    
    public static void main(String[] args)
    {
        System.out.println(findUnsortedSubarray(new int[] {1,2,3,4}));
    }
}
