
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1
Input: [3,0,1]
Output: 2
Example 2
Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:

Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class MissingNumber
{
    public static void main(String[] args)
    {
        int[] nums= {0,1,3,4,6,7,8,5,9,10};
        System.out.println(missingNumber(nums));
    }
    
    
    //  The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
    //  In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
    public static int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        System.out.println(xor+"-"+i);

        return xor ^ i;
    }
}




