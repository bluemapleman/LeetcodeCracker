
/*
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:
Input:
3

Output:
3
Example 2:
Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10. 


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月5日
 */
public class NthDigit
{
    public static void main(String[] args)
    {
        //1234567891011
        System.out.println(findNthDigit(9));
        System.out.println(findNthDigit(10));
        System.out.println(findNthDigit(11));
        System.out.println(findNthDigit(12));
        System.out.println(findNthDigit(13));
        System.out.println(findNthDigit(14));
        System.out.println(findNthDigit(15));
        
    }
    public static int findNthDigit(int n) {
        // digit sum from 1 to n: 9*10^0*1+9*10^1*2+9*10^2*3+... =9+90+900*3+...=9*(1*1+10*2+100*3)
        
        int temp=n,digitRange=0;
        
        for(int i=0;i<100;i++) {
            int digitRangeNum=(int)(9*Math.pow(10, i)*(i+1));
            if(temp<=digitRangeNum) {
                digitRange=i+1;
                break;
            }else{
                temp-=digitRangeNum;
            }
        }
        
        int digitNum=temp/digitRange;
        int yushu=temp%digitRange;
        if(yushu==0) {
            return ((int)Math.pow(10, digitRange-1)+digitNum-1)%10;
        }else {
            int number=(int)Math.pow(10, digitRange-1)+digitNum;
            for(int i=0;i<digitRange-yushu;i++) {
                number/=10;
            }
            return number%10;
        }
    }
}

