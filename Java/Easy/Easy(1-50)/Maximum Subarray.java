/*
# Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月12日
 */
public class MaximumSubarray
{
  public static void main(String[] args)
  {
     int nums[]={-2,1,-3,4,-1,2,1,-5,4};
     System.out.println(maxSubArray(nums));
  }
  
  /**
   *  for any sum tempSum over several items, the criteria that it bases on to decide whether or not to add next item c is that:
   *    if tempSum<0, then adding c will only makes sum fewer, so we replace tempSum's value with c;
   *    else, then add c and see whether tempSum>sum:
   *        if tempSum>sum, replace sum with tempSum;
   *        else, do nothing;
   * @param nums
   * @return
   */
  
  public static int maxSubArray(int[] nums) {
      if(nums.length==0)
          return 0;
      int tempSum=nums[0];
      int sum=tempSum;
      for(int i=1;i<nums.length;i++) {
          if(tempSum<0) {
              tempSum=nums[i];
          }
          else {
              tempSum+=nums[i];
          }
          
          if(tempSum>sum)
              sum=tempSum;
          
      }
      return sum;
  }
}

