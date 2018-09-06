
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
          //iterative ways
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        
        for(int i=triangle.size()-1;i>0;i--) {
            List<Integer> row=triangle.get(i);
            List<Integer> lastRow=triangle.get(i-1);
            
            for(int j=0;j<row.size()-1;j++) {
                int min=Math.min(row.get(j), row.get(j+1));
                lastRow.set(j,lastRow.get(j)+min);
            }
        }
        
        return triangle.get(0).get(0);
  }
    
}
