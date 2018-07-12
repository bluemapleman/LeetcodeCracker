
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月3日
 */
//[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//"ABCCED"
//[["A","B","C"],["D","E","F"],["G","H","I"]]
//"DGHIA"
//[["a","a"]]
//"aaa"
//[["C","A","A"],["A","A","A"],["B","C","D"]]
//"AAB"

public class WordSearch
{   
    public boolean exist(char[][] board, String word) {
        if(word.equals(""))
            return true;
        
        int m=board.length,n=board[0].length;
        
        char startLetter=word.charAt(0);
        // try finding the first letter first
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]==startLetter) {
                    if(exist(board, word, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word,int x,int y) {
        if(word.equals(""))
            return true;
        
        char goal=word.charAt(0);
        // array out of index boundary
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y]!=goal)
            return false;
        
        board[x][y]^=256;
        boolean result=exist(board,word.substring(1),x-1,y) || exist(board,word.substring(1),x+1,y) || exist(board,word.substring(1),x,y-1) || exist(board,word.substring(1),x,y+1);
        board[x][y]^=256;
        return result;
    }

}

