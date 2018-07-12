
/*
Write a function that takes a string as input and returns the string reversed.

Example:

Given s = "hello", return "olleh".


*/
package easy2;

import java.util.Stack;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class ReverseString
{
    //O(1.5n)
    public String reverseString(String s) {
        char[] arr=s.toCharArray();
        int len=arr.length;
        for(int i=0;i<len/2;i++) {
            char temp=arr[i];
            arr[i]=arr[len-i-1];
            arr[len-i-1]=temp;
        }
        return String.valueOf(arr);
    }
    
    
    // Exceeds time limit: O(2n)
//  public String reverseString(String s) {
//      char[] arr=s.toCharArray();
//      Stack<Character> stack=new Stack<Character>();
//        for(int i=0;i<arr.length;i++) {
//              stack.push(arr[i]);
//        }
//        s="";
//        while(!stack.isEmpty())
//              s+=stack.pop();
//        return s;
//        
//    }
}

