
/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.


*/
package easy2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月6日
 */
public class LongestPalindrome
{
    public int longestPalindrome(String s) {
        if(s.length()<=1)
            return s.length();
        
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++) {
            char key=arr[i];
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key,1);
        }
        
        Set<Character> set=map.keySet();
        int doubleCharNum=0;
        boolean oneMoreCharFlag=false;
        for(Character key:set) {
            if(map.get(key)%2==0)
                doubleCharNum+=map.get(key);
            else {
                doubleCharNum+=map.get(key)-1;
                oneMoreCharFlag=true;
            }
        }
        if(oneMoreCharFlag)
            doubleCharNum+=1;
        
        return doubleCharNum;
    }
}

