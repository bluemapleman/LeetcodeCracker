
/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
- The input string length won't exceed 1000.


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月18日
 */
public class PalindromicSubstrings
{
    // Recurrence
    // ith element in int[] ans means: The number of palindrome in the String which ends with element i.
    public int countSubstrings(String s) {
        int len=s.length();
        if(len==0)
            return 0;
        int ans[]=new int[len];
        ans[0]=1;
        
        for(int i=1;i<len;i++) {
            int letter=s.charAt(i);
            // add before
            ans[i]+=ans[i-1];
            // itself is a palindrome
            ans[i]+=1;
            for(int j=0;j<i;j++) {
                if(letter==s.charAt(j)) {
                    if(checkPalindrome(s.substring(j,i+1)))
                        ans[i]+=1;
                }
            }
        }
        
        return ans[ans.length-1];
    }
    
    public static boolean checkPalindrome(String s) {
        int len=s.length();
        for(int i=0;i<=len-i-1;i++) {
            if(s.charAt(i)!=s.charAt(len-i-1)) {
                return false;
            }
        }
        return true;
    }
}

