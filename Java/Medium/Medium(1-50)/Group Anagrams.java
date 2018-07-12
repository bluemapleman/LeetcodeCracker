
/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.


*/
package medium1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年3月29日
 */
public class GroupAnagrams
{
     public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> bigList=new ArrayList<List<String>>();
         Map<Map<Character,Integer>,List<String>> bigMap=new HashMap<>();
         for(String str:strs) {
             Map<Character, Integer> map=new HashMap<>();
             for(int i=0;i<str.length();i++) {
                 char c=str.charAt(i);
                 if(map.containsKey(c))
                     map.put(c, map.get(c)+1);
                 else
                     map.put(c, 1);
             }
            // tricks: since the map is unique for different anagrams,so we can use map as key in map, and let the value be the answer list element.
             if(bigMap.containsKey(map)) {
                bigMap.get(map).add(str);
             }
             else {
                 List<String> tempList=new ArrayList<>();
                 tempList.add(str);
                 bigList.add(tempList);
                 bigMap.put(map,tempList);
             }
         }
         return bigList;
     }
     
}

