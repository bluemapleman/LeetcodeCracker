
/*
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
*/

class Solution {
    // this solution from: https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79000/My-accepted-JAVA-solution-for-this-question-only-7-lines-clear-and-concise.
//  The main idea is keep two values when check all elements in the array: the minimum value min until now and the second minimum value secondMin from the minimum value's position until now. Then if we can find the third one that larger than those two values at the same time, it must exists the triplet subsequence and return true.
//
//  What need to be careful is: we need to include the condition that some value has the same value with minimum number, otherwise this condition will cause the secondMin change its value.
    public boolean increasingTriplet(int[] nums) {
         int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
            for(int num : nums){
                if(num <= min) min = num;
                else if(num < secondMin) secondMin = num;
                else if(num > secondMin) return true;
            }
            return false;
    }
}