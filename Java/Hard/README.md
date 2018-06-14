# Sudoku Solver

[LC37](https://leetcode.com/problems/sudoku-solver/description/)

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

- Each of the digits 1-9 must occur exactly once in each row.
- Each of the digits 1-9 must occur exactly once in each column.
- Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

Empty cells are indicated by the character '.'.

![1](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

A sudoku puzzle...

![2](https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png)

...and its solution numbers marked in red.

Note:

- The given board contain only digits 1-9 and the character '.'.
- You may assume that the given Sudoku puzzle will have a single unique solution.
- The given board size is always 9x9.

- My Answer
```
package hard;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月28日
 */
public class SudokuSolver
{
    // This solution from: https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
    // Backtrack
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
    
    
//  // simplest thought: iterate over all the empty cell, and try to find if any of them can be filled by observing other elements in the same row, column and sub-box until no empty cell.
//  // there is a problem: this method can't deal with situation that needs EXPLORATION!!! So it may run into dead circulation.
//  public static void solveSudoku(char[][] board) {
//      Map<Integer,Set<Character>> rowCharSetMap=new HashMap<>(),columnCharSetMap=new HashMap<>();
//      for(int row=0;row<9;row++) {
//          Set<Character> charSet=new HashSet<>();
//          for(int column=0;column<9;column++) {
//              if(board[row][column]!='.') 
//                  charSet.add(board[row][column]);
//          }
//          rowCharSetMap.put(row,charSet);
//      }
//      for(int column=0;column<9;column++) {
//          Set<Character> charSet=new HashSet<>();
//          for(int row=0;row<9;row++) {
//              if(board[row][column]!='.') 
//                  charSet.add(board[row][column]);
//          }
//          columnCharSetMap.put(column,charSet);
//      }
//      
//      Map<String,Set<Character>> subboxCharSetMap=new HashMap<>();
//      for(int i=0;i<3;i++) {
//          for(int j=0;j<3;j++) {
//              Set<Character> charSet=new HashSet<>();
//              for(int x=i*3;x<i*3+3;x++) {
//                  for(int y=j*3;y<j*3+3;y++) {
//                      if(board[x][y]!='.')
//                          charSet.add(board[x][y]);
//                  }
//              }
//              subboxCharSetMap.put(""+i+j,charSet);
//          }
//      }
//      
//        while(hasEmptyCells(board)) {
//          for(int i=0;i<board.length;i++) {
//              Set<Character> rowCharSet=rowCharSetMap.get(i);
//              for(int j=0;j<board[0].length;j++) {
//                  Set<Character> columnCharSet=columnCharSetMap.get(j);
//                  
//                  Set<Character> charSet=new HashSet<>();
//                  for(int x=1;x<=9;x++)
//                      charSet.add(Character.forDigit(x, 10));
//                  if(board[i][j]=='.') {
//                      // same row
//                      charSet.removeAll(rowCharSet);
//                      // same column
//                      charSet.removeAll(columnCharSet);
//                      // same 3*3 sub-box
//                      int subboxX=i/3,subboxY=j/3;
//                      charSet.removeAll(subboxCharSetMap.get(""+subboxX+subboxY));
//                      
//                      if(charSet.size()==1) {
//                          board[i][j]=charSet.iterator().next();
//                          rowCharSetMap.get(i).add(board[i][j]);
//                          columnCharSetMap.get(j).add(board[i][j]);
//                          subboxCharSetMap.get(""+subboxX+subboxY).add(board[i][j]);
//                          System.out.println("solve "+i+j);
//                          for(int row=0;row<9;row++) {
//                              for(int column=0;column<9;column++) {
//                                  System.out.print(board[row][column]+" ");
//                              }
//                              System.out.println();
//                          }
//                      }
//                  }
//              }
//          }
//        }
//    }
//  
//  public static boolean hasEmptyCells(char[][] board) {
//      for(int i=0;i<board.length;i++) {
//          for(int j=0;j<board[0].length;j++) {
//              if(board[i][j]=='.')
//                  return true;
//          }
//      }
//      return false;
//  }
    
}
```

# Regular Expression Matching

[LC10](https://leetcode.com/problems/regular-expression-matching/description/)

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:
```
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```
Example 2:
```
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
```
Example 3:
```
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
```
Example 4:
```
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
```
Example 5:
```
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
```

# Remove Invalid Parentheses

[LC301](https://leetcode.com/problems/remove-invalid-parentheses/description/)

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
```
Input: "()())()"
Output: ["()()()", "(())()"]
```
Example 2:
```
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
```
Example 3:
```
Input: ")("
Output: [""]
```

- My Answer
```

```

