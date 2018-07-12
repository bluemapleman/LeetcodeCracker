
/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
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
 * @date 2018年2月20日
 */
public class Permutations
{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums.length==0)
            return res;
        else if(nums.length==1) {
            res.add(Arrays.asList(nums[0]));
        }
        else if(nums.length==2) {
            res.add(Arrays.asList(nums[0],nums[1]));
            res.add(Arrays.asList(nums[1],nums[0]));
        }else {
            for(List<Integer> list:permute(Arrays.copyOfRange(nums,0,nums.length-1))) {
                for(int i=0;i<=list.size();i++) {
                    List<Integer> temp=new ArrayList<Integer>();
                    temp.addAll(list);
                    temp.add(i,nums[nums.length-1]);
                    res.add(temp);
                }
            }
        }
             
            
        
        return res;
    }
}

