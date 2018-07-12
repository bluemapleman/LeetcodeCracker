
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.


*/
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月20日
 */
public class SearchinRotatedSortedArray
{
    public static void main(String[] args)
    {
        
    }
    
    public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        else if(nums.length==1)
            return nums[0]==target?0:-1;
        int ans=-1;
        int boudnaryIndex=findBoundary(nums);
        int min,max;
        if(boudnaryIndex==-1) {
            boudnaryIndex=nums.length-1;
            min=nums[0];max=nums[boudnaryIndex];
        }else {
            min=nums[boudnaryIndex+1];max=nums[boudnaryIndex];
        }
        
        if(target>=min && target<=max) {
            int leftMin=nums[0],rightMax=nums[nums.length-1];
            if(target>=leftMin) {
                ans=binarySearch(nums, target, 0, boudnaryIndex);
            }else if(target<=rightMax){
                ans=binarySearch(nums, target, boudnaryIndex+1, nums.length-1);
            }
        }
        return ans;
    }
    
    public static int findBoundary(int[] nums) {
        int index=-1;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]>nums[i+1]) {
                index=i;
                break;
            }
        }
        
        return index;
    }
    
    public static int binarySearch(int[] nums,int target,int start,int end) {
        int middle=(start+end)/2;
        int index=-1;
        while(start<=end) {
            middle=(start+end)/2;
            if(nums[middle]>target) {
                end=middle-1;
            }else if(nums[middle]<target) {
                start=middle+1;
            }else {
                return middle;
            }
        }
        return index;
    }
}

