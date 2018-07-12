
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:

1.You may assume that the array does not change.

2.There are many calls to sumRange function.


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月31日
 */
class RangeSumQueryImmutable {
    
    int[] sums;
    
    public RangeSumQueryImmutable(int[] nums) {
        this.sums=nums;
        
        for(int i=1;i<sums.length;i++) {
                sums[i]=sums[i-1]+sums[i];
        }
        
    }
    
    public int sumRange(int i, int j) {
            if(i==0)
                return sums[j];
            else
                return sums[j]-sums[i-1];
    }
    
    public static void main(String[] args)
    {
            int nums[]= {-2,0,3,-5,2,-1};
        RangeSumQueryImmutable obj=new RangeSumQueryImmutable(nums);
        System.out.println(obj.sumRange(0, 5));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

