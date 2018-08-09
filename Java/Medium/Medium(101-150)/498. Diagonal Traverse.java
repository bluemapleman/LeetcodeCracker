
/*
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.
*/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m=matrix.length;
        if(m==0)
            return new int[]{};
        
        int n=matrix[0].length;
        
        int index=0;
        int[] ansArr=new int[m*n];
        // first left to right, then up to down, iterate over the contour of the array
        int flag=1;
        // first row: left-right direction
        for(int column=0;column<n;column++) {
            // odd number diagonal
            int i=0,j=column;
            if(flag%2==0) {
                while(i<m && j>=0)
                    ansArr[index++]=matrix[i++][j--];
            }else {
                List<Integer> list=new ArrayList<>();
                while(i<m && j>=0)
                    list.add(matrix[i++][j--]);
                for(int x=list.size()-1;x>=0;x--)
                    ansArr[index++]=list.get(x);
            }
            flag++;
        }
        
        // last column: top-down direction
        for(int row=1;row<m;row++) {
            // odd number diagonal
            int i=row,j=n-1;
            if(flag%2==0) {
                while(i<m && j>=0)
                    ansArr[index++]=matrix[i++][j--];
            }else {
                List<Integer> list=new ArrayList<>();
                while(i<m && j>=0)
                    list.add(matrix[i++][j--]);
                for(int x=list.size()-1;x>=0;x--)
                    ansArr[index++]=list.get(x);
            }
            flag++;
        }
        
        return ansArr;
    }
}