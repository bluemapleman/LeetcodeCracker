
/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

![](http://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

A partially filled sudoku which is valid.

Note:

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月20日
 */
public class ValidSudoku
{
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(board[i][j]!='.') {
                    int num=board[i][j];
                    // check same row
                    for(int temp=0;temp<9;temp++)
                        if(temp!=j)
                            if(board[i][temp]==num)
                                return false;
                        
                    // check same column 
                    for(int temp=0;temp<9;temp++)
                        if(temp!=i)
                            if(board[temp][j]==num)
                                return false;
                    
                    
                    // check same nine-block grid
                    int rowIndex=i/3,columnIndex=j/3;
                    for(int x=rowIndex*3;x<rowIndex*3+3;x++)
                        for(int y=columnIndex*3;y<columnIndex*3+3;y++)
                            if(!(x==i && y==j))
                                if(board[x][y]==num)
                                    return false;
                }
        return true;
    }
}

