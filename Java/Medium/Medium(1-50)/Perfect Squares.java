
/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月5日
 */
public class PerfectSquares
{
    // dynamic programming
    public int numSquares(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<n+1;i++)
            arr[i]=Integer.MAX_VALUE;
        arr[0]=0;
        arr[1]=1;
        for(int i=1;i<n+1;i++) {
            for(int j=1;j*j<=i;j++) {
                if(arr[i-j*j]+1<arr[i])
                    arr[i]=arr[i-j*j]+1;
            }
        }
        return arr[n];
    }
}

