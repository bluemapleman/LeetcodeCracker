
/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

public class FloodFill
{
    // if finding a pair of characters that makes the string not a palindrome, try removing one of them to see if the string can be a palindrome.
   public boolean validPalindrome(String s) {
    boolean ans=false;
        for(int i=0;i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
                ans=isPalindrome(s.substring(0,i)+s.substring(i+1)) || isPalindrome(s.substring(0,s.length()-i-1)+s.substring(s.length()-i));
                if(ans)
                    return true;
                else
                    return false;
            }
        return true;
  }
    
    public static boolean isPalindrome(String s) {
        for(int i=0;i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        return true;
    }
}
