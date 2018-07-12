
/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.


*/
package easy2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class FirstUniqueCharacterinaString
{
    public static void main(String[] args)
    {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("aadd"));
    }
    
    public static int firstUniqChar(String s) {
        Set<Character> set=new HashSet<Character>();
        char uniqChar='@';
        int len=s.length();
        for(int i=0;i<len;i++) {
            char c=s.charAt(i);
            if(!set.contains(c)){
                if(s.indexOf(c,i+1)!=-1) {
                    set.add(c);
                }else {
                    uniqChar=c;
                    break;
                }
            }
        }
        return s.indexOf(uniqChar);
    }
}

