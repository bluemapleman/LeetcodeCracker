
/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:

You may assume that both strings contain only lowercase letters.
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true


*/
package easy2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class RansomNote
{
    public static void main(String[] args)
    {
        String ransomNote="abcdefggtt",magazine="ipouoewirpoipobbaaddeeffccghgit";
        System.out.println(canConstruct(ransomNote, magazine));
    }
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap=new HashMap<Character, Integer>();
        char[] ransomArr=ransomNote.toCharArray();
        for(int i=0;i<ransomArr.length;i++) {
            Character key=ransomArr[i];
            if(ransomMap.containsKey(key))
                ransomMap.put(key, ransomMap.get(key)+1);
            else 
                ransomMap.put(key, 1);
        }
        
        Set<Character> set=ransomMap.keySet();
        
        for(Character c:set) {
            int quantity=ransomMap.get(c);
            int fromIndex=0;
            for(int i=0;i<quantity;i++) {
                int index=magazine.indexOf(c, fromIndex);
                if(index==-1) {
                    return false;
                }else {
                    fromIndex=index+1;
                }
            }
        }
        
        return true;
    }
}

