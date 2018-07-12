
/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:
n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.


*/
package easy2;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月6日
 */
public class ArrangingCoins
{
    public int arrangeCoins(int n) {
        if(n<=1)
            return n;
        int temp=n;
        for(int i=1;i<=n;i++) {
            if(temp<i) {
                return i-1;
            }else
                temp-=i;
        }
        return -1;
    }
}


