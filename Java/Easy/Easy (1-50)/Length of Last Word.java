/*
# Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:
```
Input: "Hello World"
Output: 5
```


- My Answer

*/
package easy;

import java.util.regex.Pattern;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月12日
 */
public class LengthofLastWord
{

    public static void main(String[] args)
    {
        System.out.println(lengthOfLastWord("asd asd"));

    }
    
    public static int lengthOfLastWord(String s) {
        if(s.equals(""))
            return 0;
        
        if(s.contains(" ")) {

            String[] strs=s.split(" ");
            
            // only consists of " ", then strs.length=0
            if(strs.length==0)
                return 0;
            else
                return strs[strs.length-1].length();
            
        }
        
        else 
            return s.length();
    }
}