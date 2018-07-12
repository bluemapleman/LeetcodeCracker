
/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Returns: True
Example 2:
Input: 14
Returns: False


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class ValidPerfectSquare
{
    public boolean isPerfectSquare(int num) {
        int i=1,temp;
        while(true) {
            temp=i*i;
            if(temp==num)
                return true;
            else if(temp<num) {
                if(!((i+1)*(i+1)>temp)) {
                    return false;
                }
            }else
                return false;
            i++;
        }
    }
}

