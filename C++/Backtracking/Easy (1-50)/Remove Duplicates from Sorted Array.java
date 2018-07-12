/*
# Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example:

```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the new length.
```

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月10日
 */
public class RemoveDuplicatesFromSortedArray
{

    public static void main(String[] args)
    {
        int[] nums= {1,1,2,2,3,4,4};
        System.out.println(removeDuplicates(nums));
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }
    }
    
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        
        int count=1;
        
        int beforeEle=nums[0];
        
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i+1]!=beforeEle) {
                count++;
                beforeEle=nums[i+1];
                nums[count-1]=beforeEle;
            }
            else{
                continue;
            }
        }
        
        return count;
    }
}


