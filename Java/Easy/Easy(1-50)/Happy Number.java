/*
# Happy Number

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number
$$1^2 + 9^2 = 82$$
$$8^2 + 2^2 = 68$$
$$6^2 + 8^2 = 100$$
$$1^2 + 0^2 + 0^2 = 1$$

- My Answer
*/
package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月24日
 */
public class HappyNumber
{
    public static void main(String[] args)
    {
        System.out.println(isHappy(2));
    }
    
    public static boolean isHappy(int n) {
        Set<Integer> set=new HashSet<Integer>();
        int sum=0;
        while(sum!=1) {
            sum=0;
            while(n/10!=0 || n>0) {
                int digit=n%10;
                sum+=digit*digit;
                n/=10;
            }
            
            if(sum==1)
                return true;
            else
                n=sum;
            
            if(set.contains(sum))
                return false;
            else
                set.add(sum);
        }
        return false;
        }
    
}
