
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:

You are not suppose to use the library's sort function for this problem.

Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?



*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class SortColors
{
    //  this answer from: https://leetcode.com/problems/sort-colors/discuss/26472/Share-my-at-most-two-pass-constant-space-10-line-solution
    
    // thought: use low to represent the index of element after end 0, high to represent the index of element before start 2
    public void sortColors(int[] nums) {
       if(nums==null || nums.length<2) return;
       int low = 0; 
       int high = nums.length-1;
       for(int i = low; i<=high;) {
           if(nums[i]==0) {
              // swap nums[i] and nums[low] and i,low both ++
              int temp = nums[i];
              nums[i] = nums[low];
              nums[low]=temp;
              i++;low++;
           }else if(nums[i]==2) {
               //swap nums[i] and nums[high] and high--;
              int temp = nums[i];
              nums[i] = nums[high];
              nums[high]=temp;
              high--;
           }else {
               i++;
           }
       }
    }
}

