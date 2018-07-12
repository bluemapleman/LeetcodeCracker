
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]


*/
package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年7月5日
 */
public class Combinations
{
    List<List<Integer>> ans;
    int n,k;
    public List<List<Integer>> combine(int n, int k) {
        ans=new ArrayList<>();
        this.n=n;
        this.k=k;
        List<Integer> numList=new ArrayList<>();
        for(int i=1;i<=n;i++) {
            numList.add(i);
        }
        backtrack(new ArrayList<>(), numList);
        return ans;
    }
    
    public void backtrack(List<Integer> c,List<Integer> numList) {
        if(reject(c)) return;
        if(accept(c)) {
            List<Integer> list=new ArrayList<>();
            for(Integer ele:c)
                list.add(ele);
            ans.add(list);
        }
        List<Integer> s=first(c,numList);
        while(s!=null) {
            backtrack(s, numList);
            s=next(s,numList);
        }
    }
    
    public boolean reject(List<Integer> c) {
        for(int i=0;i<c.size()-1;i++) {
            if(c.get(i)>c.get(i+1))
                return true;
        }
        return false;
    }
    
    public boolean accept(List<Integer> c) {
        if(c.size()==k)
            return true;
        else
            return false;
    }
    
    public List<Integer> first(List<Integer> c,List<Integer> numList){
        if(c.size()<k) {
            if(c.isEmpty()) {
                c.add(numList.remove(0));
                return c;
            }
            else {
                int lastEle=c.get(c.size()-1);
                if(n>lastEle) {
                    c.add(lastEle+1);
                    return c;
                }
                else
                    return null;
            }
        }else
            return null;
    }
    
    public List<Integer> next(List<Integer> c,List<Integer> numList){
        int lastEle=c.get(c.size()-1);
        if(n>lastEle) {
            c.remove(c.size()-1);
            c.add(lastEle+1);
            return c;
        }else {
            c.remove(c.size()-1);
            return null;
        }
    }
}








































































