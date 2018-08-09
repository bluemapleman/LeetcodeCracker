/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/
class Solution {
    // union find
     public int longestConsecutive(int[] nums) {
         int[] ansArr=new int[nums.length];
         
         Map<Integer,Integer> map=new HashMap<>();
         Set<Integer> set=new HashSet<>();
         // O(n)
         for(Integer ele:nums) {
             set.add(ele);
             map.put(ele,ele);
         }
         // O(n)
         for(int i=0;i<nums.length;i++) {
             int ele=nums[i];
             // O(1)
             if(set.contains(ele+1))
                 map.put(ele, ele+1);
         }
         
         // O(n)
         for(int i=0;i<nums.length;i++) {
             int ele=nums[i];
             int temp=1;
             while(ele!=map.get(ele)) {
                 ele=map.get(ele);
                 temp++;
             }
             ansArr[i]=temp;
         }
         
         int ans=0;
         for(int i=0;i<ansArr.length;i++)
             ans=Math.max(ansArr[i], ans);
         
         return ans;
     }
     
     public int find(int son,Map<Integer, Integer> map) {
         return son==map.get(son)?son:find(map.get(son), map);
     }
}