
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


*/
package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月9日
 */
public class SpiralMatrix
{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix.length!=0)
            res=spiralMatrix(matrix,0,matrix.length-1,0, matrix[0].length-1);
        return res;
    }
    
    public List<Integer> spiralMatrix(int[][] matrix,int startx,int endx,int starty,int endy){
        List<Integer> list=new ArrayList<>();
        
        if(startx==endx || starty==endy) {
            if(startx==endx && starty==endy) {
                list.add(matrix[startx][starty]);
            }else if(startx==endx) {
                // single row
                for(int j=starty;j<=endy;j++)
                    list.add(matrix[startx][j]);
            }else if(starty==endy) {
                // single column
                for(int i=startx;i<=endx;i++)
                    list.add(matrix[i][endy]);
            }
            return list;
        }else if(startx<endx && starty<endy) {
            // upper row
            for(int j=starty;j<=endy;j++)
                list.add(matrix[startx][j]);
            // right column
            for(int i=startx+1;i<=endx;i++)
                list.add(matrix[i][endy]);
            // lower row
            if(startx<endx)
                for(int j=endy-1;j>=starty;j--)
                    list.add(matrix[endx][j]);
            // left column
            if(starty<endy)
                for(int i=endx-1;i>startx;i--)
                    list.add(matrix[i][starty]);
        }

        if(list.isEmpty())
            return list;
        else
            list.addAll(spiralMatrix(matrix, startx+1, endx-1, starty+1, endy-1));
        
        return list;
    }
}

