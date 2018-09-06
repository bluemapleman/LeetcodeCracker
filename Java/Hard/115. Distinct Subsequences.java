/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
*/
    
class Solution {
    // DP
  // tranfer from f(s,t.subString(i)) to f(s,t.subString(i-1))
  
  // O(s.length()*t.length())
  public static int numDistinct(String s, String t) {
    if(t.equals(""))
      return 1;
    
    if(s.equals(""))
      return 0;
    
    // initialize
    int[][] mrx=new int[t.length()][s.length()];
    int temp=0;
    for(int i=s.length()-1;i>=0;i--) {
      mrx[0][i]=s.charAt(i)==t.charAt(t.length()-1)?++temp:temp;
    }
    
    for(int i=t.length()-2;i>=0;i--) {
      temp=0;
      char c=t.charAt(i);
      
      for(int j=s.length()-1;j>=0;j--) {
        if(s.charAt(j)==c && j+1<mrx[0].length) {
          mrx[t.length()-i-1][j]=temp+=mrx[t.length()-i-2][j+1];
        }else
          mrx[t.length()-i-1][j]=temp;
      }
    }

    return mrx[mrx.length-1][0];
    }
}

// recursion: exceeds time limit

//if(t.equals(""))
//  return 1;
//
//int ans=0;
//
//int index=-1;
//while((index=s.indexOf(t.charAt(0),index+1))!=-1) {
//  ans+=numDistinct(s.substring(index+1), t.substring(1));
//}
//
//return ans;