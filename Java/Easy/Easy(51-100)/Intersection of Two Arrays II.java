
/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
Note:
- Each element in the result should appear as many times as it shows in both arrays.
- The result can be in any order.

Follow up:
- What if the given array is already sorted? How would you optimize your algorithm?
- What if nums1's size is small compared to nums2's size? Which algorithm is better?
- What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


*/
package easy2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class IntersectionofTwoArraysII
{
    public static void main(String[] args)
    {
        int[] nums1= {2,2,3,3,1,1,1,1,1},nums2={1,2,2,1,3,1,1,1};
        int[] arr=intersect(nums1, nums2);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
                
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1=new HashMap<Integer,Integer>(),map2=new HashMap<Integer,Integer>();
        for(int i=0;i<nums1.length;i++)
            if(map1.containsKey(nums1[i]))
                map1.put(nums1[i],map1.get(nums1[i])+1);
            else
                map1.put(nums1[i], 1);
        for(int i=0;i<nums2.length;i++)
            if(map2.containsKey(nums2[i]))
                map2.put(nums2[i],map2.get(nums2[i])+1);
            else
                map2.put(nums2[i], 1);
        
        Set<Integer> keySet1=map1.keySet(),keySet2=map2.keySet();
        Map<Integer, Integer> commonMap=new HashMap<Integer,Integer>();
        
        int size=0;
        for(Integer num:keySet1) {
                if(keySet2.contains(num)) {
                    int quantity=Math.min(map1.get(num), map2.get(num));
                    commonMap.put(num,quantity);
                    size+=quantity;
                }
        }
        
        int[] answer=new int[size];
        Set<Integer> keySet=commonMap.keySet();
        
        
        int index=0;
        for(Integer key:keySet) {
                int quantity=commonMap.get(key);
                for(int i=0;i<quantity;i++)
                    answer[index++]=key;
        }
        
        return answer;
        
    }
}

