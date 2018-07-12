/*
# Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:

Could you do it in-place with O(1) extra space?

Related problem: Reverse Words in a String II

- My Answer
*/
package easy;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月24日
 */
public class RotateArray
{
    public static void main(String[] args)
    {
        int[] nums= {1,2,3,4,5,6,7,8};
        rotate(nums, 11);
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]+" ");
    }
    
    public static void rotate(int[] nums, int k) {
        if(k<nums.length) {
                int[] rotatePart=Arrays.copyOfRange(nums, nums.length-k, nums.length);
                for(int i=0;i<nums.length-k;i++) 
                    nums[nums.length-i-1]=nums[nums.length-k-i-1];
                for(int i=0;i<rotatePart.length;i++)
                    nums[i]=rotatePart[i];
        }else {
                k=k%nums.length;
                rotate(nums,k);
        }
    }
}
