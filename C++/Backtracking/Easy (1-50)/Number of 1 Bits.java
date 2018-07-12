/*
# Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.


- My Answer
*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月24日
 */
public class Numberof1Bits
{
    public static void main(String[] args)
    {
        System.out.println(hammingWeight(11));
    }
    
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
            StringBuilder binStr=new StringBuilder(Integer.toUnsignedString(n,2));
            int digitDelta=32-binStr.length();
//          while(digitDelta-->0)
//              binStr.insert(0,"0");
            int count=0;
            for(int i=0;i<binStr.length();i++)
                if(binStr.charAt(i)=='1')
                    count++;
        return count;
    }
}
