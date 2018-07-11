/*
# Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:

If this function is called many times, how would you optimize it?

Related problem: Reverse Integer

- My Answer
*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月24日
 */
public class ReverseBits
{
    public static void main(String[] args)
    {
        System.out.println("result:"+reverseBits(43261596));
    }
    
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
            StringBuilder binStr=new StringBuilder(Integer.toBinaryString(n));
            int digitDelta=32-binStr.length();
            while(digitDelta-->0)
                binStr.insert(0, "0");
        binStr=binStr.reverse();
        return Integer.parseUnsignedInt(binStr.toString(),2);
    }
}

