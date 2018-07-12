
/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].


*/
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月20日
 */
public class SearchforaRange
{
    public static void main(String[] args)
    {
        int nums[]= {1,2,3,6,8,45};
        System.out.println(binarySearch(nums, 0, nums.length-1, 3));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res= {-1,-1};
        int len=nums.length;
        if(len==0) {
            return res;
        }
        
        int firstIndex=binarySearch(nums, 0,len-1,target);
        if(firstIndex==-1) {
            return res;
        }
        res[0]=firstIndex;res[1]=firstIndex;
        if(firstIndex==0) {
            int temp=-1;
            while((temp=binarySearch(nums, temp+1, len-1, target))!=-1) {
                res[1]=temp;
            }
        }else if(firstIndex==len-1) {
            int temp=len;
            while((temp=binarySearch(nums, 0, temp-1, target))!=-1) {
                res[0]=temp;
            }
        }else {
            int temp1=len;
            while((temp1=binarySearch(nums, 0, temp1-1, target))!=-1) {
                res[0]=temp1;
            }
            int temp2=-1;
            while((temp2=binarySearch(nums, temp2+1, len-1, target))!=-1) {
                res[1]=temp2;
            }
        }
        return res;
    }
    
    public static int binarySearch(int nums[],int start,int end,int target) {
        int middle;
        int index=-1;
        while(end>=start) {
            middle=(start+end)/2;
            if(nums[middle]>target) {
                end=middle-1;
            }else if(nums[middle]<target){
                start=middle+1;
            }else {
                index=middle;
                break;
            }
        }
        return index;
    }
}


