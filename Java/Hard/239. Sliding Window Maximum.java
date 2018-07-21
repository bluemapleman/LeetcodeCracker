/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0)
			return nums;
		
		int[] ansArr=new int[nums.length-k+1];
		
		int lastWindowMaxIndex=findGreatestArrayEleIndex(Arrays.copyOf(nums,k)),lastWindowMax=nums[lastWindowMaxIndex];
		ansArr[0]=lastWindowMax;
		// comparison in later window
		for(int i=1;i<=nums.length-k;i++) {
			// if new ele is greater than lastWindowMax, then ele is the greatest in this window
			if(nums[i+k-1]>=lastWindowMax) {
				lastWindowMaxIndex=i+k-1;
				lastWindowMax=nums[lastWindowMaxIndex];
			}
			else {
				// then, if lastWindowMaxIndex=i-1, it means that the greatest ele has been removed from the window,
				// we need to do the comparison again
				if(lastWindowMaxIndex==i-1) {
					lastWindowMaxIndex=i+findGreatestArrayEleIndex(Arrays.copyOfRange(nums,i,i+k));;
					lastWindowMax=nums[lastWindowMaxIndex];
				}
			}
			ansArr[i]=lastWindowMax;
		}
		
        return ansArr;
    }
	
	public int findGreatestArrayEleIndex(int[] arr) {
		int max=Integer.MIN_VALUE,maxIndex=-1;
		// deal with first window to find max value in the window in order to simplify comparisons in later window
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>=max) {
				max=arr[i];
				maxIndex=i;
			}
		}
		return maxIndex;
	}
}
