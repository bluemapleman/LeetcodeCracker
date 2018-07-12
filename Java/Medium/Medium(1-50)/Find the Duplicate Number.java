
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:

- You must not modify the array (assume the array is read only).
- You must use only constant, O(1) extra space.
- Your runtime complexity should be less than O(n2).
- There is only one duplicate number in the array, but it could be repeated more than once.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class FindtheDuplicateNumber
{
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i]==nums[j])
                    return nums[i];
            }
        }
        return -1;
    }
    
}

