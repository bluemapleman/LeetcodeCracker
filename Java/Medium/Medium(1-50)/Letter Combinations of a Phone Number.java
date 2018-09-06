
/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.


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
 * @date 2018年2月12日
 */
public class LetterCombinationsofaPhoneNumber
{
    // time:O(3^n)
    // brute force
    public static List<String> letterCombinations1(String digits) {
        List<String> list=new ArrayList<String>();

        Map<Integer, String> map=new HashMap<Integer,String>();
        map.put(2, "abc");map.put(3, "def");map.put(4, "ghi");map.put(5, "jkl");
        map.put(6, "mno");map.put(7, "pqrs");map.put(8, "tuv");map.put(9, "wxyz");
        char[] arr=digits.toCharArray();
        for(int i=0;i<arr.length;i++) {
            int digit=Character.digit(arr[i],10);
            String chars=map.get(digit);
            if(list.size()==0) {
                for(int j=0;j<chars.length();j++)
                    list.add(chars.substring(j, j+1));
            }else {
                Object[] strs=list.toArray();
                list.clear();
                for(Object str:strs) {
                    for(int j=0;j<chars.length();j++)
                        list.add(str+chars.substring(j,j+1));
                }
            }
        }
        return list;
    }
    
    static List<String> ans;
    // backtack
    // time: O(3^n)
    public static List<String> letterCombinations2(String digits) {
        ans=new ArrayList<>();
        if(digits.equals(""))
            return ans;
        Map<Integer, String> map=new HashMap<Integer,String>();
        map.put(2, "abc");map.put(3, "def");map.put(4, "ghi");map.put(5, "jkl");
        map.put(6, "mno");map.put(7, "pqrs");map.put(8, "tuv");map.put(9, "wxyz");
        backtrack("", digits,0,map);
        return ans;
                 
    }
    
    public static void backtrack(String str,String digits,int index,Map<Integer, String> map) {
        if(str.length()==digits.length()) {
            ans.add(str);
            return;
        }
        
        int num=Character.digit(digits.charAt(index), 10);
        String possibleChar=map.get(num);
        for(int i=0;i<possibleChar.length();i++) {
            char c=possibleChar.charAt(i);
            backtrack(str+c, digits, index+1, map);
        }
        
        return; 
    }
}

