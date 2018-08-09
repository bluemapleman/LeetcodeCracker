
/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set=new HashSet<>();
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        if(nums.length==0)
            return ans;
        
        int ele=nums[0];
        for(List<Integer> tempList:subsetsWithDup(Arrays.copyOfRange(nums, 1, nums.length))){
            ans.add(tempList);
            
            List<Integer> withEleList=new ArrayList<>();
            for(Integer tempEle:tempList) {
                withEleList.add(tempEle);
            }
            withEleList.add(ele);
            ans.add(withEleList);
        }
        
        for(List<Integer> tempList:ans) {
            Collections.sort(tempList);
            set.add(tempList);
        }
        
        ans.clear();
        
        for(List<Integer> tempList:set)
            ans.add(tempList);
        
        return ans;
    }
}