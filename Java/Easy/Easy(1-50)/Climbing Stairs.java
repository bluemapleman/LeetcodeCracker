/*
# Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

```
Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```


- My Answer

*/
package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月13日
 */
public class ClimbingStairs
{

    public static void main(String[] args)
    {
        System.out.println(climbStairs(44));
    }
    
    // using normal iteration way to do this. Compared with recursive way, this simplifies the calculation process, so it's much faster!
    // "Simplify" means many duplicated calculations are avoided.
    public static int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        
        List<Integer> list=new ArrayList<Integer>();
        
        list.add(0);
        list.add(1);
        list.add(2);
        
        for(int i=3;i<n;i++) {
            list.add(list.get(i-1)+list.get(i-2));
        }
        
        return list.get(n-1)+list.get(n-2);
    }

    /**
     * classical recursive problem, just think:
     *   When you're going to finish climbing n stairs, you can only choose to climb either 1 step or 2 steps as last action, then
     *   it means there are total  #(climbStairs(n-1)) plus #(climbStairs(n-2)) cases where you can finish climbing n stairs.
     *   Then achieve in recursive way!
     *   
     *  However, this simple recursive method would exceeds time limit on leetcode for input 44!!!!
     * @param n
     * @return
     */
    
//  public static int climbStairs(int n) {
//      if(n==1)
//          return 1;
//      if(n==2)
//          return 2;
//      return climbStairs(n-1)+climbStairs(n-2);
//    }
}
