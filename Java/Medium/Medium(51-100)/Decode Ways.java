
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).


*/
package medium2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月13日
 */
public class DecodeWays
{
    // dynamic programming:
    /*
     * 1. state definition:
     *   f(i)=number of decoding ways for array which ends with ith element
     * 2. state transferation:
     *   if(arr[i-1]*10+arr[i]<=26) 
     *     you can decode arr[i] with arr[i-1] in two ways, which means: f(i)=f(i-1)+f(i-2)  
     *     (f(i-1) means arr[i] solely represents a letter, f(i-2) means arr[i-1] toghther with arr[i] represent a letter)
     *     
     *   else
     *     f(i)=f(i-1)
     * 3. initial state:
     *     f(0)=1;
     *     
     * But actually, this problem is not a DP problem, since DP problem requires for optimal substructure, but this problem doesn't meet the requeirment.
     * e.g.: answer for "110" would be 2 if we use DP, but in fact it can only be decoded to "1" and "10".
     *       Which means the number after ith array will also influence f(i)'s value. 
     */
    
    public int numDecodings(String s) {
        int[] ans=new int[s.length()];
        if(s.equals("") || s.startsWith("0"))
            return 0;
        if(s.contains("0")) {
            int zeroIndex=-1;
            while((zeroIndex=s.indexOf("0",zeroIndex+1))!=-1){
                if(s.charAt(zeroIndex-1)=='0' || s.charAt(zeroIndex-1)>'2')
                    return 0;
            }
        }
       
        // for single element with index 0, it obviously can only be decoded in only one way.
        ans[0]=1;
        // for element with index i(i>0), we consider whether it can combine with the last element.
        for(int i=1;i<s.length();i++) {
             int lastDigit=Character.digit(s.charAt(i-1), 10);
             int currentDigit=Character.digit(s.charAt(i), 10);
             if(currentDigit==0) {
                 ans[i]=ans[i-1];
             }else if(lastDigit==0) {
                 ans[i]=ans[i-1];
             }else{
                 if(i<s.length()-1 && Character.digit(s.charAt(i+1), 10)==0) {
                         ans[i]=ans[i-1];
                 }else {
                     if(lastDigit*10+currentDigit<=26) {
                         // 3 ways
                         if(i>=2)
                             ans[i]=ans[i-1]+ans[i-2];
                         else
                             ans[i]=2;
                     }else {
                         // 2 ways
                         ans[i]=ans[i-1];
                     }
                 }
             }          
        }
       
        return ans[s.length()-1];
    }
}

