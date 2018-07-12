
/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:
- A straight forward solution using O(mn) space is probably a bad idea.
- A simple improvement uses O(m + n) space, but still not the best solution.
- Could you devise a constant space solution?``


*/
package medium2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月13日
 */
public class SetMatrixZeroes
{
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0)
            return;
        
        Set<Integer> zeroRowSet=new HashSet<>(),zeroColumnSet=new HashSet<>();
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++)
                if(matrix[i][j]==0) {
                    zeroRowSet.add(i);
                    break;
                }
        }
        for(int j=0;j<matrix[0].length;j++) {
            for(int i=0;j<matrix.length;i++) {
                System.out.println("i:"+i+",j:"+j);
                if(matrix[i][j]==0) {
                    zeroColumnSet.add(j);
                    break;
                }
            }
        }
        
        for(Integer row:zeroRowSet)
            for(int j=0;j<matrix[0].length;j++)
                matrix[row][j]=0;
        
        for(Integer column:zeroColumnSet)
            for(int i=0;i<matrix.length;i++)
                matrix[i][column]=0;
        
    }
}

