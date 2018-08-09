
/*
Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

If a mine ('M') is revealed, then the game is over - change it to 'X'.
If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
Return the board when no more squares will be revealed.
Example 1:
Input: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Example 2:
Input: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Explanation:

Note:
The range of the input matrix's height and width is [1,50].
The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
The input board won't be a stage when game is over (some mines have been revealed).
For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
*/

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        char[][] ans=board;
        
        int x=click[0],y=click[1];
        char clickOne=board[x][y];
        if(clickOne=='M')
            board[x][y]='X';
        // clickOne='E'
        else if(clickOne=='E'){
            int adjacentMineNum=countAdjacentMines(board, x, y);
            // recursively deal with adjacent regions
            if(adjacentMineNum==0) {
                board[x][y]='B';
                if(x>0) {
                    if(y>0) {
                        if(board[x-1][y-1]=='E') updateBoard(board, new int[] {x-1,y-1});
                    }
                    updateBoard(board, new int[] {x-1,y});
                    if(y<board[0].length-1) {
                        if(board[x-1][y+1]=='E') updateBoard(board, new int[] {x-1,y+1});
                    }
                }
                if(y>0) if(board[x][y-1]=='E') updateBoard(board, new int[] {x,y-1});
                if(y<board[0].length-1) if(board[x][y+1]=='E') updateBoard(board, new int[] {x,y+1});
                if(x<board.length-1) {
                    if(y>0)
                        if(board[x+1][y-1]=='E') updateBoard(board, new int[] {x+1,y-1});
                    if(board[x+1][y]=='E') updateBoard(board, new int[] {x+1,y});
                    if(y<board[0].length-1)
                        if(board[x+1][y+1]=='E') updateBoard(board, new int[] {x+1,y+1});
                }
            }
            // just set board[clickX][clickY] to adjaceentMineNum
            else {
                board[x][y]=(char)('0'+adjacentMineNum);
            }
        }
        
        return ans;
    }
    
    public int countAdjacentMines(char board[][],int x,int y) {
        int count=0;
        // top row
        if(x>0) {
            // left column
            if(y>0) {
                // left top
                if(board[x-1][y-1]=='M') count++;
            }
            // middle top
            if(board[x-1][y]=='M') count++;
            // right column
            if(y<board[0].length-1) {
                // right top
                if(board[x-1][y+1]=='M') count++;
            }
        }
        // left
        if(y>0) if(board[x][y-1]=='M') count++;
        // right
        if(y<board[0].length-1) if(board[x][y+1]=='M') count++;
        // bottom row
        if(x<board.length-1) {
            // left bottom
            if(y>0) if(board[x+1][y-1]=='M') count++;
            if(board[x+1][y]=='M') count++;
            if(y<board[0].length-1) if(board[x+1][y+1]=='M') count++;
        }
        
        return count;
    }
}