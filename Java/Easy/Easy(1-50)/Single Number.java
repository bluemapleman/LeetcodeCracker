/*
# Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

- My Answer

*/
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
                
        Set<Integer> keys=map.keySet();
        for(Integer key:keys)
            if(map.get(key)==1)
                return key;
        
        return -1;
    }
}
