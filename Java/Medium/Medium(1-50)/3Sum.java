
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]


*/
package medium1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月12日
 */
public class ThreeSum
{ 
    // This solution from: The idea is to sort an input array and then run through all indices of a possible first element of a triplet. 
    // For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
    // Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
               }
            }
        }
        return res;
    }
    
    // Exceeds time limit
//  public static List<List<Integer>> threeSum(int[] nums) {
//      Arrays.sort(nums);
//        List<List<Integer>> bigList=new ArrayList<List<Integer>>();
//        for(int i=0;i<nums.length-2;i++) {
//              int left=nums[i];
//
//              int leftRemain=-left;
//              for(int j=i+1;j<nums.length-1;j++) {
//                  int middle=nums[j];
//              
//                  int middleRemain=leftRemain-middle;
//                  for(int x=j+1;x<nums.length;x++) {
//                      int right=nums[x];
//                      
//                      if(right==middleRemain) {
//                          List<Integer> list=new ArrayList<Integer>();
//                          list.add(left);list.add(middle);list.add(right);
//                          boolean containFlag=false;
//                          for(List<Integer> temp:bigList) {
//                              if(list.containsAll(temp) && temp.containsAll(list)) {
//                                  containFlag=true;
//                                  break;
//                              }
//                          }
//                          if(containFlag)
//                              break;
//                          else {
//                              bigList.add(list);
//                          }
//                          
//                      }
//                  }
//              }
//        }
//        return bigList;
//    }
}

