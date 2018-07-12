/*
# Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221


1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.
```
Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
```

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月12日
 */
public class CountandSay
{
    public static void main(String[] args)
    {
        System.out.println(countAndSay(7));
    }
    
    //The description of the problem is a little confusing, may taking some time to understand, but shortly, just a "count number" game~
    public static String countAndSay(int n) {
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        
        char[] lastStr=countAndSay(n-1).toCharArray();
        String result="";
        int count=1;
        for(int i=0;i<lastStr.length-1;i++) {
                if(lastStr[i+1]==lastStr[i]) {
                    count++;
                    if(i==lastStr.length-2) {
                        result+=count+""+lastStr[i];
                    }
                }
                else {
                    result+=count+""+lastStr[i];
                    count=1;
                    if(i==lastStr.length-2) {
                        result+="1"+lastStr[i+1];
                    }
                }
        }
        
        return result;
    }
}

