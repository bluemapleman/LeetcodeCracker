# Leetcode——回溯法常考算法整理

- Preface


[TOC]

# Definition

First, let's see the [definition of backtracking given by Wikipedia](https://en.wikipedia.org/wiki/Backtracking):

>Backtrack is a general algorithm for finding all (or some) solutions to some computational problems, notably constraint satisfaction problems, that incrementally builds candidates to the solutions, and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution.

>The classic textbook example of the use of backtracking is the eight queens puzzle, that asks for all arrangements of eight chess queens on a standard chessboard so that no queen attacks any other. In the common backtracking approach, the partial candidates are arrangements of k queens in the first k rows of the board, all in different rows and columns. Any partial solution that contains two mutually attacking queens can be abandoned.

So, in short, backtracking is notably useful to deal with 'constraint satisfaction problems'-- we must find solutions that satisfy certain constraints--

We can know from the definition that, the name of 'backtrack' comes from the way it searches for solutions: 'it incrementally builds candidates to the solutions, and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution.' 

So how does the algorithm 'determine whether a candidate cannot possibly be completed to a valid solution'? Clearly, this is when the constraint will play a role, i.e. the algorithm would judge whether the current candidate satisfies the constraint.

Another problem is: how to abandon a candidate ('backtrack')? Let's move on!


# Why & When to Use Backtrakcing

Backtrack is a good way to search for solutions that satisfy certain constraints, which makes it fit for corresponding problems.

In wiki, it also says:

>Backtracking can be applied only for problems which admit the concept of a "partial candidate solution" and a relatively quick test of whether it can possibly be completed to a valid solution. It is useless, for example, for locating a given value in an unordered table. When it is applicable, however, backtracking is often much faster than brute force enumeration of all complete candidates, since it can eliminate a large number of candidates with a single test.

So according to the wiki, the problem that backtracking can solve must satisfy two conditions:
- partial candidate solution
- quick way to test whether a partial candidate can be completed to a valid solution

- What is partial candidate solution?

In my understanding, partial candidate solution refers to solution that is 'complicate', not just a simple number or character, but a combination/group of them that work together as the solution to the problem.

For example, in classical problem 8-Queens, we're required to place 8 queens on an 8×8 chessboard such that no two queens attack each other, and we'd like to know how many possible solutions there are. Each solution consists of the position information of 8 queens. So we say **position information of 8 queens together forms a possible solution to the problem**, and when there are only i (i<8) queens on the chessboard, we say it's a partial solution candidate. 

Therefore, when we face with a problem, we can first decide whether we can solve it in using backtracking by analyzing if its solution could be broken apart into partial solutions. (We will better understand the concept of partial candidate solution through practicing on some Leetcode problems)



Besides, we can know that for problem the backtracking is applicable, it's much more efficient than brute force enumeration, **since it can eliminate a large number of candidates with a single test**, and that is the key difference which make backtracking much more advantageous than brute force enumeration for the problem.


# How to Use Backtracking

According to wiki's description of the method:

>The backtracking algorithm enumerates a set of partial candidates that, in principle, could be completed in various ways to give all the possible solutions to the given problem. The completion is done incrementally, by a sequence of candidate extension steps.

>Conceptually, the partial candidates are represented as the nodes of a tree structure, the potential search tree. Each partial candidate is the parent of the candidates that differ from it by a single extension step; the leaves of the tree are the partial candidates that cannot be extended any further.

>**The backtracking algorithm traverses this search tree recursively**, from the root down, **in depth-first order**. At each node c, the algorithm checks whether c can be completed to a valid solution. If it cannot, the whole sub-tree rooted at c is skipped (pruned). Otherwise, the algorithm (1) checks whether c itself is a valid solution, and if so reports it to the user; and (2) recursively enumerates all sub-trees of c. The two tests and the children of each node are defined by user-given procedures.

>Therefore, the actual search tree that is traversed by the algorithm is only a part of the potential tree. The total cost of the algorithm is the number of nodes of the actual tree times the cost of obtaining and processing each node. This fact should be considered when choosing the potential search tree and implementing the pruning test.

To sum up, all possible solutions can be seen as the set of all nodes in a tree structure, and in backtracking, we would find all valid solutions by searching in [DFS](https://blog.csdn.net/qq_32690999/article/details/80758898) way. 

For any specific node N, we would first determine whether N can be completed to a valid solution (i.e. whether N has broken the constraint). If it cannot, the whole sub-tree rooted at N is skipped (pruned, i.e. backtracking). Otherwise, the algorithm (1) checks whether c itself is a valid solution, and if so reports it to the user; and (2) recursively enumerates all sub-trees of c. The two tests and the children of each node are defined by user-given procedures.

- Time Cost

According to wiki:

>Therefore, the actual search tree that is traversed by the algorithm is only a part of the potential tree. The total cost of the algorithm is the number of nodes of the actual tree times the cost of obtaining and processing each node. This fact should be considered when choosing the potential search tree and implementing the pruning test.

- Pseudocode

In order to apply backtracking to a specific class of problems, one must provide the data P for the particular instance of the problem that is to be solved, and six procedural parameters, root, reject, accept, first, next, and output. These procedures should take the instance data P as a parameter and should do the following:

1. root(P): return the partial candidate at the root of the search tree.
2. reject(P,c): return true only if the partial candidate c is not worth completing.
3. accept(P,c): return true if c is a solution of P, and false otherwise.
4. first(P,c): generate the first extension of candidate c.
5. next(P,s): generate the next alternative extension of a candidate, after the extension s.
6. output(P,c): use the solution c of P, as appropriate to the application.

The backtracking algorithm reduces the problem to the call bt(root(P)), where bt is the following recursive procedure:

```
procedure bt(c)
  if reject(P,c) then return
  if accept(P,c) then output(P,c)
  s ← first(P,c)
  while s ≠ Λ do
    bt(s)
    s ← next(P,s)
```

- Details for Writing Code

- You must ensure that the reject() method rejects candidate correctly.
- In next() method, if there is no possible way to further extend partial candidate, then remember to backtrack the candidate by one step and then return.

# Leetcode Problems

## N-Queens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

![](https://leetcode.com/static/images/problemset/8-queens.png)

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:
```
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
```

- My Answer
```
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
```

PS: Clearly, I write the code according to pseudocode representing typical backtracking thought, and I think it's a very convenient and efficient way to finish writing backtracking algorithmwe.

## Permutations II

[LC47](https://leetcode.com/problems/permutations-ii/description/)

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
```
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```

- My Answer
```
package medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年7月3日
 */
public class PermutationsII
{
    // First, review the typical pseudocode of backtracking algorithm again:
        /*  
           backtrack(c){
                if(reject(c)) return;
                if(accept(c)) add c to solution set;
                // first extension of c.
                s=first(c);
                while(s!=null) {
                    backtrack(s);
                    // switch to next possible extension of c
                    s=next(s);
                }
            }
        */
    
    // The solution is the all possible permutations of given numbers.
    // So to use backtracking, we must first define what is partial solution candidate:
        //   the list of part of numbers from given integer array
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans=new ArrayList<List<Integer>>();
        List<Integer> numList=new ArrayList<>();
        Arrays.sort(nums);
        for(Integer i:nums)
            numList.add(i);
        
        
        backtrack(new ArrayList<>(), numList);
        return ans;
    }
    
    public void backtrack(List<Integer> c,List<Integer> numList) {
        if(reject(c,numList)) return;
        if(accept(c, numList)) {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<c.size();i++) {
                list.add(c.get(i));
            }
            ans.add(list);
        }
        List<Integer> s=first(c, numList);
        while(s!=null) {
//          System.out.println(s);
//          System.out.println(numList);
//          System.out.println();
            backtrack(s, numList);
            s=next(s, numList);
        }
    }
    
    public boolean reject(List<Integer> c,List<Integer> numList) {
        return false;
    }
    
    public boolean accept(List<Integer> c,List<Integer> numList) {
        if(numList.isEmpty()) {
            return true;
        }else
            return false;
        
    }
    
    public List<Integer> first(List<Integer> c,List<Integer> numList){
        if(!numList.isEmpty()){
            c.add(numList.remove(0));
            return c;
        }
        else
            return null;
    }
    
    public List<Integer> next(List<Integer> c,List<Integer> numList){
        boolean nextFlag=false;
        for(int i=0;i<numList.size();i++) {
            int ele=numList.get(i);
            int lastEle=c.get(c.size()-1);
            if(ele>lastEle) {
                numList.remove(i);
                numList.add(i,lastEle);
                c.remove(c.size()-1);
                c.add(ele);
                nextFlag=true;
                break;
            }
        }
        if(nextFlag) {
            return c;
        }else {
            numList.add(c.remove(c.size()-1));
            Collections.sort(numList);
            return null;
        }
    }
}
```

## Combinations

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```

- My Answer
```
package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年7月5日
 */
public class Combinations
{
    List<List<Integer>> ans;
    int n,k;
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        this.n=n;
        this.k=k;
        List<Integer> numList=new ArrayList<>();
        for(int i=1;i<=n;i++) {
            numList.add(i);
        }
        backtrack(new ArrayList<>(), numList);
        return ans;
    }
    
    public void backtrack(List<Integer> c,List<Integer> numList) {
        if(reject(c)) return;
        if(accept(c)) {
            List<Integer> list=new ArrayList<>();
            for(Integer ele:c)
                list.add(ele);
            ans.add(list);
        }
        List<Integer> s=first(c,numList);
        while(s!=null) {
            backtrack(s, numList);
            s=next(s,numList);
        }
    }
    
    public boolean reject(List<Integer> c) {
        for(int i=0;i<c.size()-1;i++) {
            if(c.get(i)>c.get(i+1))
                return true;
        }
        return false;
    }
    
    public boolean accept(List<Integer> c) {
        if(c.size()==k)
            return true;
        else
            return false;
    }
    
    public List<Integer> first(List<Integer> c,List<Integer> numList){
        if(c.size()<k) {
            if(c.isEmpty()) {
                c.add(numList.remove(0));
                return c;
            }
            else {
                int lastEle=c.get(c.size()-1);
                if(n>lastEle) {
                    c.add(lastEle+1);
                    return c;
                }
                else
                    return null;
            }
        }else
            return null;
    }
    
    public List<Integer> next(List<Integer> c,List<Integer> numList){
        int lastEle=c.get(c.size()-1);
        if(n>lastEle) {
            c.remove(c.size()-1);
            c.add(lastEle+1);
            return c;
        }else {
            c.remove(c.size()-1);
            return null;
        }
    }
}
```

## Sudoku Solver

[LC37](https://leetcode.com/problems/sudoku-solver/description/)

![](https://en.wikipedia.org/wiki/File:Sudoku_solved_by_bactracking.gif)

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

- Each of the digits 1-9 must occur exactly once in each row.
- Each of the digits 1-9 must occur exactly once in each column.
- Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

Empty cells are indicated by the character '.'.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)

A sudoku puzzle...

![](https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png)

...and its solution numbers marked in red.

Note:

- The given board contain only digits 1-9 and the character '.'.
- You may assume that the given Sudoku puzzle will have a single unique solution.
- The given board size is always 9x9.

- My Answer
```
class Solution {
// This solution from: https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
    // Backtrack
    
    int tempX,tempY;
    boolean[][] cellsToBeFilled;
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        cellsToBeFilled=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') {
                    cellsToBeFilled[i][j]=true;
                }
            }
        }
        backtrack(board);
    }
    
    boolean findAnswerFlag=false;
    public void backtrack(char[][] board) {
        if(reject(board)) return;
        if(accept(board)) {
            findAnswerFlag=true;
            return;
        }
        char[][] s=first(board);
        while(s!=null) {
//          outputMatrix(board);
            backtrack(s);
            if(findAnswerFlag)
                return;
            s=next(s);
        }
    }
    
    public boolean reject(char[][] board) {
        int n=board.length;
        for(int i=0;i<n;i++) {
            Set<Character> set=new HashSet<>();
            for(int j=0;j<n;j++) {
                if(board[i][j]!='.')
                    if(set.contains(board[i][j])) {
                        return true;
                    }else
                        set.add(board[i][j]);
            }
        }
        
        for(int j=0;j<n;j++) {
            Set<Character> set=new HashSet<>();
            for(int i=0;i<n;i++) {
                if(board[i][j]!='.')
                    if(set.contains(board[i][j])) {
                        return true;
                    }else
                        set.add(board[i][j]);
            }
        }
        
        for(int x=0;x<2;x++) {
            for(int y=0;y<2;y++) {
                int startRow=x*3,startCol=y*3;
                Set<Character> set=new HashSet<>();
                for(int i=startRow;i<=startRow+2;i++) {
                    for(int j=startCol;j<=startCol+2;j++) {
                        if(board[i][j]!='.')
                            if(set.contains(board[i][j])) {
                                return true;
                            }else
                                set.add(board[i][j]);
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean accept(char[][] board) {
        int n=board.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='.') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public char[][] first(char[][] board) {
        int n=board.length;
        boolean hasEmptyCellFlag=false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='.') {
                    board[i][j]='1';
                    tempX=i;tempY=j;
                    hasEmptyCellFlag=true;
                    break;
                }
            }
            if(hasEmptyCellFlag)
                break;
        }
        if(hasEmptyCellFlag)
            return board;
        else {
            return null;
        }
    }
    
    public char[][] next(char[][] board) {
        int number=Character.digit(board[tempX][tempY], 10);
        if(number<9) {
            board[tempX][tempY]=Character.forDigit(number+1, 10);
            return board;
        }
        else {
            board[tempX][tempY]='.';
            boolean findLastToBeFilledCellFlag=false;
            for(int j=tempY-1;j>=0;j--) {
                if(cellsToBeFilled[tempX][j]==true) {
                    tempY=j;
                    findLastToBeFilledCellFlag=true;
                    break;
                }
            }
            if(!findLastToBeFilledCellFlag) {
                boolean breakFlag=false;
                for(int i=tempX-1;i>=0;i--) {
                    for(int j=board.length-1;j>=0;j--) {
                        if(cellsToBeFilled[i][j]==true) {
                            tempX=i;
                            tempY=j;
                            breakFlag=true;
                            break;
                        }
                    }
                    if(breakFlag)
                        break;
                }
            }
            
            return null;
        }
        
    }
    
    public void outputMatrix(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
```
