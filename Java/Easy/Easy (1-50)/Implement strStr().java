/*
# Implement strStr()

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:
```
Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

- My Answer 

呃，算作弊了？

*/

package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月10日
 */
public class ImplementstrStr
{

    public static void main(String[] args)
    {
        String haystack="hello",needle="ll";
        System.out.println(strStr(haystack, needle));
    }

    
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
