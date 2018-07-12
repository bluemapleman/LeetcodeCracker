
/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月29日
 */
public class RotateImage
{
    // from outside to inside layer-wise
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int layer=0;layer<n/2;layer++) {
                // rotate corner element first (avoid override)
                // store left top element first
                int temp=matrix[layer][layer];
                matrix[layer][layer]=matrix[n-1-layer][layer];
                matrix[n-1-layer][layer]=matrix[n-1-layer][n-1-layer];
                matrix[n-1-layer][n-1-layer]=matrix[layer][n-1-layer];
                matrix[layer][n-1-layer]=temp;
                // move non-corner element
                int edgeNum=n-layer*2-2;
                System.out.println("layer:"+layer+",edgenum:"+edgeNum);
                // store left down edge elements first
                int[] tempEdge=new int[edgeNum];
                for(int x=0;x<edgeNum;x++) {
                    tempEdge[x]=matrix[layer+x+1][layer];
                }
                for(int i=0;i<edgeNum;i++) {
                    matrix[layer+i+1][layer]=matrix[n-layer-1][layer+i+1];
                }
            for(int i=0;i<edgeNum;i++) {
                matrix[n-layer-1][layer+i+1]=matrix[n-layer-1-i-1][n-1-layer];              
            }
            for(int i=0;i<edgeNum;i++) {
                matrix[n-layer-1-i-1][n-layer-1]=matrix[layer][n-1-layer-i-1];
            }
            for(int i=0;i<edgeNum;i++) {
                matrix[layer][n-1-layer-i-1]=tempEdge[i];
            }
        }
    }
    
    public static void main(String[] args) {
//      1 2 3 4
//      5 6 7 8
//      9 10 11 12
//      13 14 15 16
//      
//      13 9  5 1
//      14 10 6 2
//      15 11 7 3
//      16 12 8 4
        int[][] matrix= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        rotate(matrix);
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        
    }
}

