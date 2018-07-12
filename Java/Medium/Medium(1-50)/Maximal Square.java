
/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:
Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月3日
 */
public class MaximalSquare
{
    public int maximalSquare(char[][] matrix) {
        int answer=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                char c=matrix[i][j];
                if(c=='1') {
                    int temp=detectSquare(matrix, i, j);
                    if(temp>answer)
                        answer=temp;
                }
            }
        }
        return answer*answer;
    }
    
    /** 
     * @param matrix
     * @param i
     * @param j
     * @return the edge length of detected square, if no square, return 0.
     */
    public int detectSquare(char[][] matrix,int i,int j) {
        int edgeLen=1;
        for(int x=1;;x++) {
            if(i+x<matrix.length && j+x<matrix[0].length) {
                for(int a=0;a<x+1;a++) {
                    if(matrix[i+x][j+a]!='1' || matrix[i+a][j+x]!='1')
                        return edgeLen;
                }
                edgeLen+=1;
            }else
                break;
        }
        return edgeLen;
    }
}

