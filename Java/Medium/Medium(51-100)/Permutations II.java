
/*
[LC47](https://leetcode.com/problems/permutations-ii/description/)

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


*/
package medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年7月3日
 */
public class PermutationsII
{
    // First, review the typical pseudocode of backtracking algorithm again:
        /*  
           backtrack(c){
                if(reject(c)) return;
                if(accept(c)) add c to solution set;
                // first extension of c.
                s=first(c);
                while(s!=null) {
                    backtrack(s);
                    // switch to next possible extension of c
                    s=next(s);
                }
            }
        */
    
    // The solution is the all possible permutations of given numbers.
    // So to use backtracking, we must first define what is partial solution candidate:
        //   the list of part of numbers from given integer array
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans=new ArrayList<List<Integer>>();
        List<Integer> numList=new ArrayList<>();
        Arrays.sort(nums);
        for(Integer i:nums)
            numList.add(i);
        
        
        backtrack(new ArrayList<>(), numList);
        return ans;
    }
    
    public void backtrack(List<Integer> c,List<Integer> numList) {
        if(reject(c,numList)) return;
        if(accept(c, numList)) {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<c.size();i++) {
                list.add(c.get(i));
            }
            ans.add(list);
        }
        List<Integer> s=first(c, numList);
        while(s!=null) {
//          System.out.println(s);
//          System.out.println(numList);
//          System.out.println();
            backtrack(s, numList);
            s=next(s, numList);
        }
    }
    
    public boolean reject(List<Integer> c,List<Integer> numList) {
        return false;
    }
    
    public boolean accept(List<Integer> c,List<Integer> numList) {
        if(numList.isEmpty()) {
            return true;
        }else
            return false;
        
    }
    
    public List<Integer> first(List<Integer> c,List<Integer> numList){
        if(!numList.isEmpty()){
            c.add(numList.remove(0));
            return c;
        }
        else
            return null;
    }
    
    public List<Integer> next(List<Integer> c,List<Integer> numList){
        boolean nextFlag=false;
        for(int i=0;i<numList.size();i++) {
            int ele=numList.get(i);
            int lastEle=c.get(c.size()-1);
            if(ele>lastEle) {
                numList.remove(i);
                numList.add(i,lastEle);
                c.remove(c.size()-1);
                c.add(ele);
                nextFlag=true;
                break;
            }
        }
        if(nextFlag) {
            return c;
        }else {
            numList.add(c.remove(c.size()-1));
            Collections.sort(numList);
            return null;
        }
    }
}

