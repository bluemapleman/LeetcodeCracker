
/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

1.The length of both num1 and num2 is < 5100.

2.Both num1 and num2 contains only digits 0-9.

3.Both num1 and num2 does not contain any leading zero.

4.You must not use any built-in BigInteger library or convert the inputs to integer directly.


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月6日
 */
public class AddStrings
{
    public String addStrings(String num1, String num2) {
        int len1=num1.length(),len2=num2.length();
        int len=Math.max(len1, len2);
        if(len>len2)
            for(int i=0;i<len-len2;i++)
                num2="0"+num2;
        else 
            for(int i=0;i<len-len1;i++)
                num1="0"+num1;
        
        StringBuilder result=new StringBuilder("");
        
        boolean jinwei=false;
        for(int i=0;i<len;i++) {
            char c1=num1.charAt(len-i-1),c2=num2.charAt(len-i-1);
            int sum=Character.digit(c1, 10)+Character.digit(c2, 10);
            sum=jinwei?sum+1:sum;
            if(sum>=10)
                jinwei=true;
            else
                jinwei=false;
            result.append(sum%10);
        }
        
        if(jinwei)
            result.append("1");
        
        return result.reverse().toString();
    }
}

