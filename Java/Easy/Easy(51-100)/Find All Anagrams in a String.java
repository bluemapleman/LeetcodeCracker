
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


*/
package easy2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月6日
 */
public class FindAllAnagramsinaString
{
    public List<Integer> findAnagrams(String s, String p) {
        int lens=s.length(),lenp=p.length();
        List<Integer> list=new ArrayList<Integer>();
        
        if(lens<lenp)
            return list;

        Map<Character,Integer> maps=new HashMap<Character,Integer>(),mapp=new HashMap<Character,Integer>();
        char[] pArr=p.toCharArray();
        char[] sArr=s.toCharArray();
        for(int i=0;i<pArr.length;i++) {
            // for p's map
            char key=pArr[i];
            if(mapp.containsKey(pArr[i]))
                mapp.put(key, mapp.get(key)+1);
            else
                mapp.put(key, 1);
            // for s's map
            key=sArr[i];
            if(maps.containsKey(sArr[i]))
                maps.put(key, maps.get(key)+1);
            else
                maps.put(key, 1);
        }
        
        if(judgeSameMap(maps, mapp))
            list.add(0);
        
        for(int i=0;i<lens-lenp;i++) {
            char removeChar=sArr[i],addChar=sArr[i+lenp];
            maps.put(removeChar, maps.get(removeChar)-1);
            if(maps.get(removeChar)==0)
                maps.remove(removeChar);
            if(maps.containsKey(addChar))
                maps.put(addChar,maps.get(addChar)+1);
            else
                maps.put(addChar,1);
            
            if(judgeSameMap(maps, mapp))
                list.add(i+1);
        }
        
        return list;
    }
    
    public boolean judgeSameMap(Map<Character,Integer> map1,Map<Character,Integer> map2) {
        Set<Character> set1=map1.keySet(),set2=map2.keySet();
        if(set1.size()!=set2.size())
            return false;
        else {
            for(Character key:set1) {
                if(!set2.contains(key))
                    return false;
                if(map1.get(key).compareTo(map2.get(key))!=0)
                    return false;
            }
        }
        return true;
    }
}

