
/*
Given an integer, write a function to determine if it is a power of three.

Follow up:

Could you do it without using any loop / recursion?


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月31日
 */
public class PowerofThree
{
    // with recursion.
    public boolean isPowerOfThree(int n) {
        if(n==1)
            return true;
        if(n%3==0 && n/3>=1)
            return isPowerOfThree(n/3);
        else
                return false;
    }
}

