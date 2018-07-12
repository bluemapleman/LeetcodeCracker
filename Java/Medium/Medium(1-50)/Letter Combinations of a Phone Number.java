
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
    public static void main(String[] args)
    {
        for(String str:letterCombinations("32235235")) {
            System.out.println(str);
        }
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<String>();
        if(digits.contains("1") || digits.contains("0"))
            return list;
        else {
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
        }
        return list;
    }
}

