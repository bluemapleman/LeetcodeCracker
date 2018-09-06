
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:
Input: "babad"

Output: "bab"
Note: "aba" is also a valid answer.
 

Example:
Input: "cbbd"

Output: "bb"


*/
package medium1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class LongestPalindromicSubstring
{
    
    // brute force with little tricks
    // O(n^2)
    public static String longestPalindrome1(String s) {
        String ans="";
        for(int i=0;i<s.length() && s.length()-i>ans.length();i++) {
            for(int j=i+ans.length();j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    String subStr=s.substring(i,j+1);
                    if(isPalindrome(subStr)) {
                        if(subStr.length()>ans.length())
                            ans=subStr;
                    }
                }
            }
        }
        return ans;
    }

    // O(n)
    public static boolean isPalindrome(String s) {
        int half=s.length()/2;
        int len=s.length();
        for(int i=0;i<half;i++) {
            if(!(s.charAt(i)==s.charAt(len-i-1)))
                return false;
        }
        return true;
    }
    
    // This solution from: https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution
    // O(n^2)
    public static String longestPalindrome2(String s) {
        int max = 0, idx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = extend(s, i, i), len2 = extend(s, i, i + 1);
            if (max < Math.max(len1, len2)) {
                idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
                max = Math.max(len1, len2);
            }
        }
        return s.substring(idx, idx + max);
     }
    // O(n)
    private static int extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++)
            if (s.charAt(i) != s.charAt(j))
                break;
        return j - i - 2 + 1; // 2 means current two unmatched char
    }
    
    // dp
    // solution from: https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
    // time: O(n^2)
    // space: O(n^2)
    public String longestPalindrome3(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        String ans=null;
        
        for(int i=0;i<s.length()-1;i++) {
            for(int j=i;j<s.length();j++) {
                dp[i][j]=s.charAt(i)==s.charAt(j) && (j-i<3 || dp[i+1][j-1]);
                
                if(dp[i][j] && (ans==null || j-i+1>ans.length()))
                    ans=s.substring(i, j+1);
                
            }
        }
        
        return ans;
    }
}


