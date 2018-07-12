
/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

![](https://leetcode.com/static/images/problemset/8-queens.png)

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.


*/
package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月22日
 */
public class NQueens
{
    static List<List<String>> ans;
    public static void main(String[] args)
    {
        List<List<String>> ans=solveNQueens(8);
        System.out.println("size:"+ans.size());
//      for(List<String> list:ans) {
//          for(String row:list)
//              System.out.println(row);
//          System.out.println();
//      }
        
    }
    
    public static List<List<String>> solveNQueens(int n) {
        ans=new ArrayList<List<String>>();
        
        String[][] c=new String[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                c[i][j]=new String(".");
    
        
        
        
        backtrack(c);
        
        
        return ans;
    }
    
    public static void backtrack(String[][] c){
        if(reject(c)) return;
        if(accept(c)) {
            List<String> list=new ArrayList<>();
            for(int i=0;i<c.length;i++) {
                String temp="";
                for(int j=0;j<c.length;j++) {
                    temp+=c[i][j];
                }
                list.add(temp);
            }
            ans.add(list);
        }
        c=first(c);
        while(c!=null) {
//          output(c);
//          System.out.println("---------");
            backtrack(c);
            c=next(c); 
        }
        
        return;
    }
    //generate the next alternative extension of a candidate, after the extension s.
    public static String[][] next(String[][] c){
        int lastRow=-1;
        for(int i=0;i<c.length;i++) {
            boolean hasQueen=false;
            for(int j=0;j<c.length;j++) {
                if(c[i][j].equals("Q"))
                    hasQueen=true;
            }
            if(!hasQueen) {
                lastRow=i-1;
                break;
            }
        }
        
        if(lastRow==-1)
            lastRow=c.length-1;
        
        for(int j=0;j<c.length-1;j++) {
            if(c[lastRow][j].equals("Q")) {
                c[lastRow][j]=".";
                c[lastRow][j+1]="Q";
                return c;
            }
        }
        c[lastRow][c.length-1]=".";
        return null;
    }
    //generate the first extension of candidate c.
    public static String[][] first(String[][] c){
        for(int i=0;i<c.length;i++) {
            boolean hasQueen=false;
            for(int j=0;j<c.length;j++) {
                if(c[i][j].equals("Q"))
                    hasQueen=true;
            }
            if(!hasQueen) {
                c[i][0]="Q";
                return c;
            }
        }
        return null;
    }
    
    public static boolean accept(String[][] c) {
        int count=0;
        int n=c.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(c[i][j].equals("Q"))
                    count++;
            }
        }
        if(count==c.length)
            return true;
        return false;
    }
    
    public static boolean reject(String[][] c) {
        int n=c.length;
        // check by row
        for(int i=0;i<n;i++) {
            boolean hasQueen=false;
            for(int j=0;j<n;j++) {
                if(c[i][j].equals("Q")) {
                    if(hasQueen)
                        return true;
                    else
                        hasQueen=true;
                        
                }
            }
        }
        // check by column
        for(int j=0;j<n;j++) {
            boolean hasQueen=false;
            for(int i=0;i<n;i++) {
                if(c[i][j].equals("Q")) {
                    if(hasQueen)
                        return true;
                    else
                        hasQueen=true;
                        
                }
            }
        }
        // check by diagram
        // left bottom to right top
        for(int i=0;i<n;i++) {
            boolean hasQueen=false;
            for(int x=0;x<=i;x++) {
                if(c[i-x][x].equals("Q")) {
                    if(hasQueen)
                        return true;
                    else
                        hasQueen=true;
                        
                }
            }
        }
        for(int j=n-1;j>0;j--) {
            boolean hasQueen=false;
            for(int x=0;x<n-j;x++) {
                if(c[n-1-x][j+x].equals("Q")) {
                    if(hasQueen)
                        return true;
                    else
                        hasQueen=true;
                }
            }
        }
        // left top to right bottom
        for(int i=n-1;i>=0;i--) {
            boolean hasQueen=false;
            for(int x=0;x<n-i;x++) {
                if(c[i+x][x].equals("Q")) {
                    if(hasQueen)
                        return true;
                    else
                        hasQueen=true;
                        
                }
            }
        }
        for(int j=n-1;j>=0;j--) {
            boolean hasQueen=false;
            for(int x=0;x<n-j;x++) {
                if(c[x][j+x].equals("Q")) {
                    if(hasQueen)
                        return true;
                    else
                        hasQueen=true;
                }
            }
        }
        
        
        
        
        return false;
    }
    
    public static void output(String[][] c) {
        for(int i=0;i<c.length;i++) {
            for(int j=0;j<c.length;j++)
                System.out.print(c[i][j]+"-");
            System.out.println();
        }
    }
}


