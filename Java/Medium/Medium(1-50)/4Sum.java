
/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]


*/
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月13日
 */
public class FourSum
{   
    // In this way, you can review solutions for problem 2Sum and 3Sum at the same time!:-)! 
    public List<List<Integer>> fourSum(int[] nums, int target){
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        
        int len=nums.length;
        // boundary case
        if(nums==null || len<4 || nums[0]*4>target || nums[len-1]*4<target)
            return res;
        
        for(int i=0;i<len-3;i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
                List<List<Integer>> tempList=threeSum(nums,i+1,target-nums[i]);
                for(List<Integer> list:tempList) {
                    List<Integer> tempTemplist=new ArrayList<Integer>();
                    tempTemplist.add(nums[i]);
                    for(Integer temp:list) {
                        tempTemplist.add(temp);
                    }
                    res.add(tempTemplist);
                }
            }

        }
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] nums,int start,int target){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int size=nums.length-start;
        if(size<3 || nums[start]*3>target || nums[nums.length-1]*3<target) {
            return res;
        }
        
        for(int i=start;i<nums.length-2;i++) {
            if(i==start || (i>start && nums[i]!=nums[i-1])) {
                List<List<Integer>> tempList=twoSum(nums,i+1,target-nums[i]);
                for(List<Integer> list:tempList) {
                    List<Integer> tempTemplist=new ArrayList<Integer>();
                    tempTemplist.add(nums[i]);
                    for(Integer temp:list) {
                        tempTemplist.add(temp);
                    }
                    res.add(tempTemplist);
                }
            }
        }
        return res;
    }
    
    public List<List<Integer>> twoSum(int[] nums,int start,int target){
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int size=nums.length-start;
        if(size<2 || nums[start]*2>target || nums[nums.length-1]*2<target) {
            return res;
        }

        int i=start;
        if(i==start || (i>start && nums[i]!=nums[i-1])) {
            int lo=i,hi=nums.length-1;
            // -2 -1 0 0 1 2
            while(hi>lo) {
                if(nums[lo]+nums[hi]==target) {
                    res.add(Arrays.asList(nums[lo],nums[hi]));
                    while(hi>lo && nums[hi]==nums[hi-1]) hi--;
                    while(hi>lo && nums[lo]==nums[lo+1]) lo++;
                    lo++;hi--;
                }else if(nums[lo]+nums[hi]>target) hi--;
                else lo++;
            }
        }
        return res;
    }
}

