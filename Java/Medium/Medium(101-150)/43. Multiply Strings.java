
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
    public static String multiply(String num1, String num2) {
        String ansStr="0";
        if(num1.startsWith("0") || num2.startsWith("0"))
            return ansStr;
        else if(num1.equals("10"))
            return num2+"0";
        else if(num2.equals("10"))
            return num1+"0";
        
        
        // num1 from left to right (down)
        for(int i=0;i<num1.length();i++) {
            String tempSumStr="0";
            // num2 from right to left (up)
            for(int j=num2.length()-1;j>=0;j--) {
                int int1=Character.digit(num1.charAt(i), 10),int2=Character.digit(num2.charAt(j), 10);
                int product=int1*int2;
                
                String productStr=""+product;
                for(int temp=num2.length()-1;temp>j;temp--)
                    productStr=multiply(""+productStr, "10");
                tempSumStr=add(tempSumStr, String.valueOf(productStr));
            }
            // multiply 10 is equal to add one 0 to the end of ansStr
            if(!ansStr.startsWith("0"))
                ansStr=add(ansStr+"0", tempSumStr);
            else
                ansStr=tempSumStr;

            tempSumStr="0";
        }
        return ansStr;
    }
    
    
    public static String add(String num1,String num2) {
        String ansStr="";
        if(num1.startsWith("0") && num2.startsWith("0"))
            return "0";
        else if(num1.startsWith("0"))
            return num2;
        else if(num2.startsWith("0"))
            return num1;
        
        int carry=0;
        int greaterLen=Math.max(num1.length(), num2.length());
        while(num1.length()<greaterLen)
            num1="0"+num1;
        while(num2.length()<greaterLen)
            num2="0"+num2;
        for(int i=greaterLen-1;i>=0;i--) {
            int addend1=Character.digit(num1.charAt(i), 10),addend2=Character.digit(num2.charAt(i), 10);
            int sum=addend1+addend2;
            sum+=carry;
            
            carry=sum/10;
            
            ansStr=sum%10+ansStr;
        }
        
        if(carry>0)
            ansStr="1"+ansStr;
        return ansStr;
    }
}
