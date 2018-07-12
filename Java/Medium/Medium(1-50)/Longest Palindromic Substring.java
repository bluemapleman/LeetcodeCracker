
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
    // This solution from: https://leetcode.com/problems/longest-palindromic-substring/discuss/2928/Very-simple-clean-java-solution
    public static String longestPalindrome(String s) {
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
        
    private static int extend(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++)
            if (s.charAt(i) != s.charAt(j))
                break;
        return j - i - 2 + 1; // 2 means current two unmatched char
    }
    
    //Exceed time limit
//  public static String longestPalindrome(String s) {
//      if(s.length()<=1)
//          return s;
//      String answer="";
//      int len=s.length();
//      int findedPalindromMaxLen=0;
//      for(int i=0;i<len-1;i++) {
//          if(len-i<=findedPalindromMaxLen)
//              break;
//          for(int j=0;j<len-i;j++) {
////                System.out.println("len-j-i:"+(len-j-i));
//              if(len-j-i<=findedPalindromMaxLen)
//                  break;
//              
//              if(s.charAt(i)==s.charAt(len-j-1) && len-j-i>findedPalindromMaxLen) {
//                  String temp=s.substring(i,len-j);
//                  if(judgePalindrome(temp)) {
//                      if(temp.length()>findedPalindromMaxLen) {
//                          answer=temp;
//                          findedPalindromMaxLen=answer.length();
//                          System.out.println("longest:"+findedPalindromMaxLen+"iteration--i:"+i+",j:"+j);
//                      }
//                  }
//              }
//          }
//      }
//        return answer;
//    }
//  
//  public static boolean judgePalindrome(String s) {
//      int half=s.length()/2;
//      int len=s.length();
//      for(int i=0;i<half;i++) {
//          if(!(s.charAt(i)==s.charAt(len-i-1)))
//              return false;
//      }
//      return true;
//  }
}


