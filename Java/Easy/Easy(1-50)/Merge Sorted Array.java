/*
# Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

- My Answer
*/


/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月13日
 */
public class MergeSortedArray
{

    public static void main(String[] args)
    {
        //-5 2 3 100 1000
        int m=2,n=3;
        int[] nums1=new int[m+n];
        nums1[0]=3;nums1[1]=100;
        int[] nums2=new int[n];
        nums2[0]=-5;nums2[1]=2;nums2[2]=1000;
        merge(nums1, m, nums2, n);
        for(int i=0;i<nums1.length;i++)
            System.out.println(nums1[i]+" ");
        
    }
    
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=0,index2=0;
        int[] tempArr=new int[m+n];
            while(index1<m && index2<n) {
                if(nums2[index2]>=nums1[index1]) {
                    tempArr[index1+index2]=nums1[index1];
                    index1++;
                }else {
                    tempArr[index1+index2]=nums2[index2];
                    index2++;
                }
            }
            
            if(index1<m) {
                for(;index1<m;index1++)
                    tempArr[index1+index2]=nums1[index1];
            }
            else {
                for(;index2<n;index2++)
                    tempArr[index1+index2]=nums2[index2];
            }
            
            for(int i=0;i<tempArr.length;i++)
                nums1[i]=tempArr[i];
    }

}

