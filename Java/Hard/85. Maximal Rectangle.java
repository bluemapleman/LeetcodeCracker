/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/

class Solution {
      // refer to: 84. Largest Rectangle in Histogram
  // This problem can be transformed to LC 84
  public int maximalRectangle(char[][] matrix) {
    if(matrix.length==0)
      return 0;
    
    int ans=0;
    
    int m=matrix.length,n=matrix[0].length;
    
    int[] histogram=new int[n];
    for(int i=0;i<m;i++) {
      for(int j=0;j<n;j++) {
        if(matrix[i][j]=='1') {
          histogram[j]+=1;
        }else
          histogram[j]=0;
      }
      ans=Math.max(ans, largestRectangleArea(histogram));
    }
    return ans;
  }
  
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