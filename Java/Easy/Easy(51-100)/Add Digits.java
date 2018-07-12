
/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月29日
 */
public class AddDigits
{
    public static void main(String[] args)
    {
        System.out.println(addDigits(3958));
    }
    
    public static int addDigits(int num) {
        int sum=0;
        while(true) {
            while(num/10!=0) {
                int yushu=num%10;
                sum+=yushu;
                num/=10;
            }
            sum+=num;
            if(sum/10==0)
                return sum;
            else {
                num=sum;
                sum=0;
            }
        }   
    }
}

