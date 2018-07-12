
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:

You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.


*/
package easy2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月30日
 */
public class WordPattern
{
    public static void main(String[] args)
    {
        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("abba","dog dog dog dog"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
        System.out.println(wordPattern("abc","b c a"));
    }
    public static boolean wordPattern(String pattern, String str) {
        Map<String, String> map=new HashMap<String,String>();
        String[] strs=str.split(" ");
        int len=strs.length;
        
        if(len!=pattern.length())
            return false;
        
        for(int i=0;i<len;i++) {
            String key=String.valueOf(pattern.charAt(i));
            if(map.containsKey(key)) {
                if(!(map.get(key).equals(strs[i])))
                    return false;
            }else {
                if(map.containsValue(strs[i]))
                    return false;
                map.put(key,strs[i]);
            }
        }
        return true;
    }
}

