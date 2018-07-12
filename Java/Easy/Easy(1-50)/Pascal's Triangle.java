/*
# Pascal's Triangle

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return
```
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
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
 * @date 2018年1月18日
 */
public class PascalsTriangle
{
    public static void main(String[] args)
    {
        for(List<Integer> list:generate(20)) {
            for(Integer ele:list)
                System.out.print(" "+ele);
            System.out.println();
        }
    }
    
    // Permutation Problem 
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> bigList=new ArrayList<List<Integer>>();
        if(numRows==0)
            return bigList;
        
        for(int i=0;i<numRows;i++) {
            List<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<=i;j++) {
                list.add(getCombinationNumber(i, j));
            }
            bigList.add(list);
        }
        return bigList;
    }
    
    public static int getCombinationNumber(int m,int n) {
        if(n==0)
            return 1;
        // Using the property of combination theory to simplify calculation
        if(n>m/2)
            n=m-n;
        
        long nFactorial=1l;
        for(int i=1;i<n;i++)
            nFactorial*=(i+1);
        
        long mFactorial=1;
        for(int i=0;i<n;i++)
            mFactorial*=(m-i);
        
        return (int)(mFactorial/nFactorial);
        
        
    }
}
