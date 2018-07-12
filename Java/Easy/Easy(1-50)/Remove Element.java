/*
# Remove Element

Given an array and a value, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
```
Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.
```

- My Answer

**很奇怪，这个答案没通过，但是输出结果确实是对的，可能是我哪里还理解错了，还是把我的答案留在这儿。**
*/
package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月10日
 */
public class RemoveElement
{
    public static void main(String[] args)
    {
        int[] nums= {3,2,2,3};
        System.out.println(removeElement(nums,3));
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }

    }
    
    public static int removeElement(int[] nums, int val) {
        
        if(nums.length==0)
            return 0;
        
        Arrays.sort(nums);
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==val) {
                start=i;
                break;
            }
        }
        
        end=start;
        for(int i=start+1;i<nums.length;i++) {
            if(nums[i]==val)
                end++;
            else
                break;
        }
        int count=0;
        
        if(count==0){
            return nums.length;
        }
        
        count=end-start+1;
        
        for(int i=end+1;i<nums.length;i++) {
            nums[i-count]=nums[i];
        }
        
        return nums.length-count;
        
    }
    
    // This answer exceeds time limit
//  public int removeElement(int[] nums, int val) {
//        int count=0;
//      for(int i=0;i<nums.length;i++)
//          if(nums[i]==val)
//              count++;
//      for(int i=0;i<nums.length;i++) {
//          if(nums[i]==val) {
//              for(int j=i;j<nums.length-1;j++) {
//                  nums[j]=nums[j+1];
//              }
//              i--;
//          }
//      }
//        return nums.length-count;
//    }
    
}

