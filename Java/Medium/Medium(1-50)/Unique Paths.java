
/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

![picture](https://leetcode.com/static/images/problemset/robot_maze.png)

Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.




*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月30日
 */
public class UniquePaths
{
    // DP problem: inverse thought
    public static int uniquePaths(int m, int n) {
        int[][] uniquePathsMatrix=new int[m][n];
        
        // far tight column and lowest row should all be 1
        for(int i=0;i<m;i++) uniquePathsMatrix[i][n-1]=1;
        for(int j=0;j<n;j++) uniquePathsMatrix[m-1][j]=1;
        // fill solutions into other squares
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                uniquePathsMatrix[i][j]=uniquePathsMatrix[i][j+1]+uniquePathsMatrix[i+1][j];
            }
        }
        return uniquePathsMatrix[0][0];
    }
    
    public static void main(String[] args)
    {
        uniquePaths(2, 3);
    }
}

