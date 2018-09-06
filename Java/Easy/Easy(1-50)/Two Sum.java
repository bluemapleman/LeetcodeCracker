/*
Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

- My Answer
*/

class Solution {
    // naive ways: brute force O(n^2)
    public int[] twoSum1(int[] nums, int target) {
        int[] ans=null;
        for(int i=0;i<nums.length;i++) {
            int num1=nums[i];
            for(int j=i+1;j<nums.length;j++) {
                int num2=nums[j];
                if(num1+num2==target) {
                    ans=new int[2];
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        return ans;
    }
        
    // Use a hashmap to store seen element to avoid the redundant scanning process.
    // time:O(n) space: O(n)
    public int[] twoSum2(int[] nums, int target) {
        int ans[]=null;
        // key: the number value: the index of the number
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int ele=nums[i];
            if(map.containsKey(target-ele)) {
                ans=new int[2];
                ans[0]=map.get(target-ele);
                ans[1]=i;
            }else
                map.put(nums[i],i);
        }
        return ans;
    }
}

// if the vector<int>  is sorted, you can do it in this way.
// int firstIndex=-1,secondIndex=-1;
        
        // for(int i=0;i<nums.length;i++){
        //     int firstEle=nums[i];
        //     for(int j=i+1;j<nums.length;j++){
        //         int secondEle=nums[j];
        //         if(firstEle+secondEle==target){
        //             firstIndex=i;
        //             secondIndex=j;
        //         }
        //     }
        // }
        
        // int []arr=new int[2];
        // arr[0]=firstIndex;
        // arr[1]=secondIndex;
        // return arr;