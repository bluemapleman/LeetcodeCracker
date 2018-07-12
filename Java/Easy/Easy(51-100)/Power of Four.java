
/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月31日
 */
public class PowerofFour
{
    // withou loop or recursion
    public boolean isPowerOfFour(int num) {
        // 换底公式! log(a,b)=log(c,a)/log(c,b)
        // 判断结果是否为整数即可。
        return (Math.log(num) / Math.log(4)) % 1 == 0; 
    }
}

