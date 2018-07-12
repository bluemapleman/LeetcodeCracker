/*
# Excel Sheet Column Number

Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
```

(和上上一题互为镜像题。)

- My Answer
*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月23日
 */
public class ExcelSheetColumnNumber
{
    public static void main(String[] args)
    {
        
    }
    
    public static int titleToNumber(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++) {
            int delta=s.charAt(i)-'@';
            for(int j=i+1;j<s.length();j++)
                delta*=26;
            sum+=delta;
        }
        return sum;
    }
}
