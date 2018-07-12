
/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

You must do this in-place without making a copy of the array.

Minimize the total number of operations.


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class MoveZeroes
{
    public static void main(String[] args)
    {
        int nums[]= {0,1,0,3,12};
        moveZeroes(nums);
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]+" ");
    }
    
    public static void moveZeroes(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++) {
                if(nums[i]!=0) {
                    nums[index]=nums[i];
                    index++;
                }
        }
        while(index<nums.length) {
                nums[index]=0;
                index++;
        }
    }
}

