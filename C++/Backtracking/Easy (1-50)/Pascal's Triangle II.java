/*
# Pascal's Triangle II

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

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
public class PascalsTriangleII
{
    public static void main(String[] args)
    {
        System.out.println(Long.MAX_VALUE);
        System.out.println(getCombinationNumber(30, 13));
        System.out.println(getCombinationNumber(30, 14));
        System.out.println(getCombinationNumber(30, 15));
//      for(Integer ele:getRow(3)) {
//          System.out.println(ele+" ");
//      }
    }
    
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++) {
                list.add(getCombinationNumber(rowIndex,i));
        }
        return list;
    }
    
    public static int getCombinationNumber(int m,int n) {
        if(n==0)
            return 1;
        // Using the property of combination theory to simplify calculation
        if(n>m/2)
            n=m-n;
        
        List<Integer> nList=new ArrayList<Integer>(),mList=new ArrayList<Integer>(); 
        
        for(int i=0;i<n;i++) {
            int nFactor=i+1;
            int mFactor=m-i;
            nList.add(nFactor);
            mList.add(mFactor);
        }
        
        for(int i=0;i<nList.size();i++) {
            for(int j=0;j<mList.size();j++) {
                int nFactor=nList.get(i);
                int mFactor=mList.get(j);
                if(mFactor%nFactor==0) {
                    mList.set(j, mFactor/nFactor);
                    nList.set(i,1);
                    break;
                }
            }
        }
        long mFactorial=1l,nFactorial=1l;
        for(int i=0;i<nList.size();i++) {
            nFactorial*=nList.get(i);
        }
        
        for(int j=0;j<mList.size();j++) {
            mFactorial*=mList.get(j);
        }
        
        
        return (int)(mFactorial/nFactorial);
        
        
    }
}
