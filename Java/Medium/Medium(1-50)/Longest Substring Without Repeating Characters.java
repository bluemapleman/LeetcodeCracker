
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


*/
package medium1;

import java.util.ArrayList;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class LongestSubstringWithoutRepeatingCharacters
{
    public static void main(String[] args)
    {
        
    }
    
    public int lengthOfLongestSubstring(String s) {
           if(s.equals("")) return 0;
                ArrayList<ArrayList<Character>> bigList=new ArrayList<ArrayList<Character>>(); 
                for(int i=0;i<s.length();i++){
                    ArrayList<Character> list=new ArrayList<Character>();
                    for(int j=i;j<s.length();j++){
                        if(list.contains(s.charAt(j))){
                            break;
                        }else{
                            list.add(s.charAt(j));
                        }
                    }
                    bigList.add(list);
                }
                
                int maxLen=Integer.MIN_VALUE;
                for(int i=0,len=bigList.size();i<len;i++){
                    ArrayList<Character> list=bigList.get(i);
                    if(list.size()>maxLen){
                        maxLen=list.size();
                    }
                }
                
                return maxLen;
      }
}

