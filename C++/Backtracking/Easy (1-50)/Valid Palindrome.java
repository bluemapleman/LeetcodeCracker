/*
# Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
```
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
```

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

- My Answer

*/
package easy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月20日
 */
public class ValidPalindrome
{
    public static void main(String[] args)
    {
        System.out.println(isPalindrome("0P"));
    }
    
    public static boolean isPalindrome(String s) {
        if(s.equals("") || s.length()==1)
            return true;
        s=s.replaceAll(" ","");
        s=s.replaceAll(",","");
        s=s.replaceAll("\n","");
        s=s.replaceAll("\r","");
        
        // remove non-alphanumeric characters
        String regex="[a-zA-Z0-9]+";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(s);
        String goalStr="";
        while(matcher.find()) {
            goalStr+=matcher.group();
        }
        s=goalStr.toLowerCase();
        
        int len=s.length();
        for(int i=0;i<len/2;i++) {
            if(s.charAt(i)==s.charAt(len-i-1))
                continue;
            else
                return false;
        }
        
        return true;
    }
}