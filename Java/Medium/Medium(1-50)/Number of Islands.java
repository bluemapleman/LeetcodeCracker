
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
11110
11010
11000
00000
Answer: 1

Example 2:
11000
11000
00100
00011
Answer: 3


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月22日
 */
public class NumberofIslands
{
    public int numIslands(char[][] grid) {
        int ans=0;
        if(grid.length==0)
            return 0;
        boolean[][] searchedLand=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(searchedLand[i][j]==false) {
                    searchedLand[i][j]=true;
                    char current=grid[i][j];
                    if(current=='1') {
                        ans++;
                        // set searched cell to true
                        furtherSearchLand(grid, searchedLand, i+1, j);
                        furtherSearchLand(grid, searchedLand, i, j+1);
                    }
                }
            }
        }
        return ans;
    }
    
    // Recursively mark the consecutive neighbor '1'
    public void furtherSearchLand(char[][] grid,boolean[][] searchedLand,int i,int j) {
        if(i<grid.length && j<grid[0].length) {
            searchedLand[i][j]=true;
            if(grid[i][j]=='1') {
                if(i+1<grid.length && searchedLand[i+1][j]==false)
                    furtherSearchLand(grid, searchedLand, i+1, j);
                if(i-1>=0 && searchedLand[i-1][j]==false)
                    furtherSearchLand(grid, searchedLand, i-1, j);
                if(j+1<grid[0].length && searchedLand[i][j+1]==false)
                    furtherSearchLand(grid, searchedLand, i, j+1);
                if(j-1>=0 && searchedLand[i][j-1]==false)
                    furtherSearchLand(grid, searchedLand, i, j-1);
            }
        }
    }
}

