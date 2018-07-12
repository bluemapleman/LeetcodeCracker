
/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:

Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)


*/
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月4日
 */
public class ProductofArrayExceptSelf
{
     public int[] productExceptSelf(int[] nums) {
         int len=nums.length;
         
         int[] res=new int[len];
         
         if(len==1) {
             nums[0]=1;
             return nums;
         }
         else if(len==2) {
             int temp=nums[0];
             nums[0]=nums[1];
             nums[1]=temp;
             return nums;
         }else{
             int[] arr1=Arrays.copyOfRange(nums, 0,len/2),arr2=Arrays.copyOfRange(nums, len/2,len);
             
             arr1=productExceptSelf(arr1);
             arr2=productExceptSelf(arr2);
             int leftProduct=nums[0]*arr1[0];
             int rightProduct=nums[len/2]*arr2[0];
             System.out.println("left:"+leftProduct+",right:"+rightProduct);
             
             
             
             //multiply each element in one side by the product of the other side
             for(int i=0;i<arr1.length;i++) {
                 arr1[i]*=rightProduct;
                 res[i]=arr1[i];
             }
             for(int i=0;i<arr2.length;i++) {
                 arr2[i]*=leftProduct;
                 res[arr1.length+i]=arr2[i];
             }
         }
         
         return res;
         
     }
}

