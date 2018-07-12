
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class Searcha2DMatrixII
{
     public boolean searchMatrix(int[][] matrix, int target) {
         int i=matrix.length-1,j=0;
         while(i>=0 && j<matrix[0].length) {
             if(matrix[i][j]==target)
                 return true;
             else if(matrix[i][j]>target)
                 i--;
             else
                 j++;
         }
         return false;
     }
}

