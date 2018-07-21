
/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
Follow up:

Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

class Solution {
    public void gameOfLife(int[][] board) {
        // space complexity O(n)
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int[][] temp=new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                temp[i][j]=countSurroundingCells(board, i, j);
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                // living
                if(board[i][j]==1) {
                    if(temp[i][j]<2)
                        board[i][j]=0;
                    else if(temp[i][j]==2 || temp[i][j]==3)
                        board[i][j]=1;
                    else
                        board[i][j]=0;
                }
                // dead
                else {
                    if(temp[i][j]==3)
                        board[i][j]=1;
                }
            }
        }
    }
    
    
    public int countSurroundingCells(int[][] board,int row,int column) {
        int count=0;

        if(row-1>=0) {
            if(board[row-1][column]==1)
                count++;
            // left up diagonal
            if(column-1>=0) if(board[row-1][column-1]==1) count++;
            // right up diagonal
            if(column+1<board[0].length) if(board[row-1][column+1]==1) count++;
        }
        
        // left
        if(column-1>=0) if(board[row][column-1]==1) count++;
        // right
        if(column+1<board[0].length) if(board[row][column+1]==1) count++;
        
        if(row+1<board.length) {
            if(board[row+1][column]==1) count++;
            //left down diagonal
            if(column-1>=0) if(board[row+1][column-1]==1) count++;
            // right down diagonal
            if(column+1<board[0].length) if(board[row+1][column+1]==1) count++;
        }
        
        return count;
    }
    }
}