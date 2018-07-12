
/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".
Example 2:
Given s = "leetcode", return "leotcede".
Note:

The vowels does not include the letter "y".


*/
package easy2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class ReverseVowelsofaString
{
    //vowel includes: a o e i u
    public String reverseVowels(String s) {
        Set<Character> vowelSet=new HashSet<Character>();
        vowelSet.add('a');vowelSet.add('o');vowelSet.add('e');vowelSet.add('i');vowelSet.add('u');
        vowelSet.add('A');vowelSet.add('O');vowelSet.add('E');vowelSet.add('I');vowelSet.add('U');
        
        List<Integer> vowelIndexList=new ArrayList<Integer>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++)
            if(vowelSet.contains(arr[i]))
                vowelIndexList.add(i);
        
        int listSize=vowelIndexList.size();
        for(int i=0;i<listSize/2;i++) {
            char temp=arr[vowelIndexList.get(i)];
            arr[vowelIndexList.get(i)]=arr[vowelIndexList.get(listSize-i-1)];
            arr[vowelIndexList.get(listSize-i-1)]=temp;
        }
        
        return String.valueOf(arr);
        
    }
}

