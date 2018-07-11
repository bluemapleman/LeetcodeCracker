/*
# Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
```
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
```

Note:

You may assume both s and t have the same length.

- My Answer
*/
package easy1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月25日
 */
public class IsomorphicStrings
{
    public static void main(String[] args)
    {
        System.out.println(isIsomorphic("ac", "ab"));
    }
    
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<Character,Character>();
        int len=s.length();
        for(int i=0;i<len;i++) {
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            if(map.containsKey(schar)) {
                // one character can map to at most 1 character 
                if(map.get(schar)==tchar)
                    continue;
                else
                    return false;
            }else {
                // no two character can map to the same character
                if(map.containsValue(tchar))
                    return false;
                map.put(schar,tchar);
            }
        }
        return true;
    }
}
