
/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
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
 * @date 2018年3月29日
 */
public class CombinationSum
{
    // backtrack problem
    // This answer from: https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    
    //[2,3,6,7] 7
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        // start recursion
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        // in recursion process, the list has been filled with correct answers
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        // end condition: if target is negative (namely, target less than minimum in nums, then no need to futher explore)
        if(remain < 0) return;
        // end condition: if target is zero, it means tempList has become a list of combination of target sum, so we add it to the answer list 
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        // recursion part:
        // iterate over each element: we know that the any resolutions in answer list must start with certain element in nums
        //                            so we just iterate over each element
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                // key code!!!: tempList remains unchanged, but target changes with the iteration element.
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                // for iteration starting from next element
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

