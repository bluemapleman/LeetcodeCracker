/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 


The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/

class Solution {
    // O(n^2)
	// iteration
	public int largestRectangleArea(int[] heights) {
		if(heights.length==0)
			return 0;
		
		int ans=heights[0];
		
		int[] ansArr=new int[heights.length];
		ansArr[0]=heights[0];
		
		for(int i=1;i<ansArr.length;i++) {
			int tempHeight=heights[i];
			ansArr[i]=tempHeight;
			for(int j=i-1;j>=0;j--) {
				if(heights[j]<tempHeight)
					tempHeight=heights[j];
				ansArr[i]=Math.max(ansArr[i], (i-j+1)*tempHeight);
			}
			ans=Math.max(ans, ansArr[i]);
		}
		
		return ans;
    }
}