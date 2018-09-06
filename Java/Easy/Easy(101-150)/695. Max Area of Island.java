
/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

*/
class Solution {
    boolean[][] explored;
  // iteration
  public int maxAreaOfIsland(int[][] grid) {
    if(grid.length==0)
      return 0;
    
    int m=grid.length,n=grid[0].length;
    int ans=0;
    explored=new boolean[m][n];
    
    for(int i=0;i<m;i++) {
      for(int j=0;j<n;j++) {
        if(grid[i][j]==1 && explored[i][j]==false) {
          ans=Math.max(ans, areaOfIsland(grid, i, j));
        }
      }
    }
    
        return ans;
    }
  
  // recursion
  public int areaOfIsland(int[][] grid,int x,int y) {
    int ans=1;
    explored[x][y]=true;

    if(x-1>=0 && grid[x-1][y]==1 && explored[x-1][y]==false)
      ans+=areaOfIsland(grid, x-1, y);
    if(x+1<grid.length && grid[x+1][y]==1 && explored[x+1][y]==false)
      ans+=areaOfIsland(grid, x+1, y);
    if(y-1>=0 && grid[x][y-1]==1 && explored[x][y-1]==false)
      ans+=areaOfIsland(grid, x, y-1);
    if(y+1<grid[0].length && grid[x][y+1]==1 && explored[x][y+1]==false)
      ans+=areaOfIsland(grid, x, y+1);
    
    return ans;
  }
}