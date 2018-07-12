
/*
Given two arrays, write a function to compute their intersection.

Example:

Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
- Each element in the result must be unique.
- The result can be in any order.


*/

package easy2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class IntersectionofTwoArrays
{
    public static void main(String[] args)
    {
        int[] nums1= {1,2},nums2= {2,1};
        int[] arr=intersection(nums1, nums2);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<Integer>(),set2=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++)
            set1.add(nums1[i]);
        for(int i=0;i<nums2.length;i++)
            set2.add(nums2[i]);
        
        set1.retainAll(set2);
        
        int[] arr=new int[set1.size()];
        int i=0;
        for(Integer ele:set1) {
            arr[i++]=ele;
        }
        return arr;
    }
}

