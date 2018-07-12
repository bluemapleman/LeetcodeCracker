
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]

Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class MinimumPathSum
{
    public static int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] minPathSumMatrix=new int[m][n];
        
        minPathSumMatrix[m-1][n-1]=grid[m-1][n-1];
        // fill right column and lowest row first
        for(int i=m-2;i>=0;i--) minPathSumMatrix[i][n-1]=minPathSumMatrix[i+1][n-1]+grid[i][n-1];
        for(int j=n-2;j>=0;j--) minPathSumMatrix[m-1][j]=minPathSumMatrix[m-1][j+1]+grid[m-1][j];
        
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                int rightDistance=minPathSumMatrix[i][j+1],downDistance=minPathSumMatrix[i+1][j];
                minPathSumMatrix[i][j]=rightDistance>downDistance?grid[i][j]+downDistance:grid[i][j]+rightDistance;;
            }
        }
        
        return minPathSumMatrix[0][0];
    }
    
    public static void main(String[] args)
    {
        int[][] grid= {{1,2,3,4,5},{6,7,8,9,10}};
        minPathSum(grid);
    }
}

