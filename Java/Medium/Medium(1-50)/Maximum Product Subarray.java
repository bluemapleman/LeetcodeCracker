
/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.


*/
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月21日
 */
public class MaximumProductSubarray
{
    // find negative number and zeros and mark out their indices, pay attention to them
    // two negative numbers together can be regarded as a positive number
    public int maxProduct(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
    
        List<Integer> negaNumIndicesList=new ArrayList<>(),zeroIndicesList=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0)
                zeroIndicesList.add(i);
            else if(nums[i]<0)
                negaNumIndicesList.add(i);
        }
        
     // split the whole array by 0, and test each 
        if(zeroIndicesList.isEmpty()) {
            // the subarray that has the maximum product is the whole array
            if(negaNumIndicesList.size()%2==0) {
                return getProductofSubarray(nums, 0, nums.length);
            }else {
                int firstNegaIndex=negaNumIndicesList.get(0),lastNegaIndex=negaNumIndicesList.get(negaNumIndicesList.size()-1);
                int left=getProductofSubarray(nums,0,lastNegaIndex-1),right=getProductofSubarray(nums,firstNegaIndex+1,nums.length-1);
                return left>right?left:right;
            }
        }
        else {
            int firstZeroIndex=zeroIndicesList.get(0);
            int left=maxProduct(Arrays.copyOfRange(nums,0,firstZeroIndex)),right=maxProduct(Arrays.copyOfRange(nums, firstZeroIndex+1,nums.length));
            if(left<0 && right<0)
                return 0;
            else
                return left>right?left:right;
        }
    }
    
    public int getProductofSubarray(int[] nums,int start,int end) {
        if(start>end)
            return 0;
        int res=1;
        for(int i=start;i<=end && i<nums.length;i++) {
            res*=nums[i];
        }
        return res;
    }
}

