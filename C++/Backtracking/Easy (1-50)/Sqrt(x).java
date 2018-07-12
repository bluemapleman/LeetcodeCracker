/*
# Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x.

x is guaranteed to be a non-negative integer.

```
Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.
```

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月13日
 */
public class SqrtX
{

    public static void main(String[] args)
    {
        //2147395600
        System.out.println(Integer.MAX_VALUE);
        System.out.println(mySqrt(Integer.MAX_VALUE));
        System.out.println(46341*46341);

    }
    
    public static int mySqrt(int x) {
        int delta=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<=x;i++) {
            if(i*i>x)
                break;
            // avoid overflow
            if(i*i<0) {
                result=i-1;
                break;
            }
            if(x-i*i<delta) {
                delta=x-i*i;
                result=i;
            }
        }
        return result;
    }

}

