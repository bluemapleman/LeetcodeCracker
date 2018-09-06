/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/

class Solution {
// solution from: https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
    public int lengthOfSubString(String str) {
        int[] map=new int[128];
        int counter=0;
        int d=0;
        // two pointers
        int begin=0,end=0;
        while(end<str.length()) {
            if(map[str.charAt(end++)]++==0) counter++;
            while(counter>2) {
                if(map[str.charAt(begin++)]--==1)
                    counter--;
            }
            d=Math.max(d, end-begin);
        }
        return d;
    }
}
