/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/
class Solution {
    // state: longest length of parentheses that ends with the letter of index n: f(n)
  // transfer: 
//    if s.charAt(n+1)=='(' f(n+1)=0
//      else 
//      if(s.charAt(n)=='('){
//        f(n+1)=f(n-1)+2
//      else
//        if(s.charAt(n-f(n-1)-1)=='(')
//          f(n+1)=f(n)+2+f(n+1-f(n)-2)
  public static int longestValidParentheses(String s) {
    
    int len=0;
    if(s.length()<=1)
      return len;
    
    int[] ans=new int[s.length()];
    ans[0]=0;
    for(int i=1;i<s.length();i++) {
      if(s.charAt(i)==')') {
        if(s.charAt(i-1)=='(') {
          if(i>1)
            ans[i]=ans[i-2]+2;
          else
            ans[i]=2;
        }else if(s.charAt(i-1)==')') {
          if(i-ans[i-1]-1>=0 && s.charAt(i-ans[i-1]-1)=='(') {
            ans[i]=ans[i-1]+2+((i-ans[i-1]-2)>=0?ans[i-ans[i-1]-2]:0);
          }
        }
      }
      len=Math.max(len, ans[i]);
    }
    return len;
    }
}