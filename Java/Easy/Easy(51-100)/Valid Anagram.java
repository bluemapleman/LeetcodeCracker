
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:

You may assume the string contains only lowercase alphabets.

Follow up:

What if the inputs contain unicode characters? How would you adapt your solution to such case?


*/
package easy2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月28日
 */
public class ValidAnagram
{
    public static void main(String[] args)
    {       
        String s="car";String t="rat";
        System.out.println(isAnagram(s, t));
    }
    
    // Just compare whether two Strings have same letter set and same quantity for every letter
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        
        Map<Character, Integer> map1=getFilledMap(s),map2=getFilledMap(t);
        if(map1.keySet().size()!=map2.keySet().size())
            return false;
        else {
            Set<Character> set=map1.keySet();
            
            for(Character c:set) {
                // Attention!!! Here can't be written like "map2.get(c)==map1.get(c)", because map return Integer object, and "==" means comparing address in memory.
                if(map2.containsKey(c) && map2.get(c).equals(map1.get(c)))
                    continue;
                else
                    return false;
            }
        }
        
        
        
        return true;
    }
    
    public static Map<Character,Integer> getFilledMap(String str){
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<str.length();i++) {
            char key=str.charAt(i);
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key,1);
        }
        return map;
    }
}


