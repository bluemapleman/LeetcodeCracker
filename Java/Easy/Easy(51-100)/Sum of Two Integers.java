
/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:

Given a = 1 and b = 2, return 3.


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月2日
 */
public class SumofTwoIntegers
{
    public static void main(String[] args)
    {
        int num=3;
        String str1=Integer.toBinaryString(num);
        String str2=Integer.toBinaryString(num-1);
        System.out.println("str1:"+str1+",str2:"+str2);
        String result=Integer.toBinaryString(num&(num-1));
        System.out.println("result:"+result);
        
        int count=0;
        while(num!=0) {
            num = num&(num-1);
            count++;
        }
        System.out.println("count:"+count);
    }
    
    // solution from https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
    // Above is a very excellent explanation for various fantastic application of bit manipulation!!!
    
    //  Use ^ to remove even exactly same numbers and save the odd, or save the distinct bits and remove the same.
    //
    //  Sum of Two Integers
    //  Use ^ and & to add two integers
    public static int getSum(int a, int b) {
        // ^ plays a role of adding distinct bits to a [temp], while & plays a role of transferring carry to another number to be added to [temp]
        // When b is equal to 0, then it means there is no carry, and all bits added correctly.
        
        return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;
    }
}

