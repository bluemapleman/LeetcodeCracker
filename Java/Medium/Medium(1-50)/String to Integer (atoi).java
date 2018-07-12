
/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):

The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月31日
 */
public class StringtoIntegeratoi
{
    public static void main(String[] args)
    {
        System.out.println(Character.digit('b',10));
    }
    
    
    // This solution from: https://leetcode.com/problems/string-to-integer-atoi/discuss/4654/My-simple-solution
    public static int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }
        
        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
    
    // This solution is from Java's library code: Integer.parseInt(String s), but it still can't cover all cases appeared in leetcode 
//  public static int myAtoi(String str) {
//          int radix=10;
//
//          int result = 0;
//          boolean negative = false;
//          int i = 0, len = str.length();
//          int limit = -Integer.MAX_VALUE;
//          int multmin;
//          int digit;
//
//          if (len > 0) {
//              char firstChar = str.charAt(0);
//              if (firstChar < '0') { // Possible leading "+" or "-"
//                  if (firstChar == '-') {
//                      negative = true;
//                      limit = Integer.MIN_VALUE;
//                  }
//
//                  if (len == 1) // Cannot have lone "+" or "-"
//                      return 0;
//                  i++;
//              }
//              multmin = limit / radix;
//              while (i < len) {
//                  // Accumulating negatively avoids surprises near MAX_VALUE
//                  digit = Character.digit(str.charAt(i++),radix);
//                  // illegal non-digit character
//                  if (digit < 0) {
//                          return 0;
//                  }
//                  if (result < multmin) {
//                      return 0;
//                  }
//                  result *= radix;
//                  if (result < limit + digit) {
//                      return 0;
//                  }
//                  result -= digit;
//              }
//          }
//          
//          return negative ? result : -result;
//   }
}

