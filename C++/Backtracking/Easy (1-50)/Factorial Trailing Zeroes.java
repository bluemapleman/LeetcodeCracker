/*
# Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

- My Answer
*/
package easy1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月23日
 */
public class FactorialTrailingZeroes
{
    // #(2-5 pair) and #(n*10)
    public static void main(String[] args)
    {
        System.out.println(1/5);
        for(int i=1;i<30;i++)
            System.out.println(i+"!:"+getFactorial(i)+" "+trailingZeroes(i));
    }
    
    //count the number of 5 is all we need to do!
    //But attention: We need to focus on numbers that are 5^n, so we iteratively let n be divided by 5, and add quotient up.
    public static int trailingZeroes(int n) {
        if(n==0)
            return 0;
        
        int nums=0;
        while(n/5!=0) {
            nums+=n/5;
            n/=5;
        }
        return nums;
    }
    
    public static long getFactorial(int n) {
        if(n==1)
            return n*1;
        return n*(getFactorial(n-1));
    }
    
}
