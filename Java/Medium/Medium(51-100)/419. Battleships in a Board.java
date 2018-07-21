
/*
Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

*/

class Solution {
    // Attention: don't just simply store ""+i+j, or cell(1,10) may be mixed with cell(11,0)
    public int countBattleships(char[][] board) {
        int ans=0;
        // store battleship cell that has been explored to avoid repeated count
        Set<String> closed=new HashSet<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                char c=board[i][j];
                // find a battleship
                if(c=='X' && !closed.contains(""+i+","+j)) {
                    ans++;
                    
                    closed.add(""+i+j);
                    // extend horizontally
                    for(int x=j+1;x<board[0].length;x++) {
                        if(board[i][x]=='X')
                            closed.add(""+i+","+x);
                        else
                            break;
                    }
                    
                    // extend vertically
                    for(int x=i+1;x<board.length;x++) {
                        if(board[x][j]=='X')
                            closed.add(""+x+","+j);
                        else
                            break;
                    }
                }
            }
        }
        return ans;
    }
}