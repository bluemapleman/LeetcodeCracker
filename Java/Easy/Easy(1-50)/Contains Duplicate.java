/*
# Contains Duplicate

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

- My Answer
*/
package easy1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月25日
 */
public class ContainsDuplicate
{
    public static void main(String[] args)
    {
        int[] nums= {1,2,5,3,3};
        System.out.println(containsDuplicate(nums));
    }
    
    // Make use of the feature of data structure: Set
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
}