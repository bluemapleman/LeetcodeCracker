
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


*/
package medium1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月2日
 */
public class Subsets
{
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> bigList=new ArrayList<List<Integer>>();
        int len=nums.length;
        if(len==0) {
            bigList.add(new ArrayList<>());
            return bigList;
        }else if(len==1){
            bigList.add(new ArrayList<>());
            bigList.add(Arrays.asList(nums[0]));
        }else {
            List<List<Integer>> subsetAnswer=subsets(Arrays.copyOfRange(nums,1,len));
            for(List<Integer> list:subsetAnswer){
                List<Integer> temp1=new ArrayList<Integer>(Arrays.asList(new Integer[list.size()])),temp2=new ArrayList<Integer>(Arrays.asList(new Integer[list.size()]));
                Collections.copy(temp1,list);
                bigList.add(temp1);
                
                Collections.copy(temp2,temp1);
                temp2.add(nums[0]);
                bigList.add(temp2);
            }
        }
        
        return bigList;
    }
}

