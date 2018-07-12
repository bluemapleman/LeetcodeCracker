/*
# Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

- My Answer

*/
package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月23日
 */
public class MajorityElement
{
    public static void main(String[] args)
    {
        int nums[]= {1,2,3,4,5,6,1,-1,0,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        System.out.println("len:"+nums.length);
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            int key=nums[i];
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }else {
                map.put(key, 1);
            }
            if(map.get(key)>nums.length/2)
                return key;
        }
        return -1;
    }
}

