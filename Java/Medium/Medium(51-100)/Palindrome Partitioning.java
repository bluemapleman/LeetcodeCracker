
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]


*/
package medium2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月19日
 */
public class PalindromePartitioning
{
    // DP solution
    public List<List<String>> partition(String s) {
        
        if(s.length()==0)
            return Arrays.asList(Arrays.asList(""));
        
        ArrayList<List<List<String>>> ansList=new ArrayList<List<List<String>>>();
        ansList.add(Arrays.asList(Arrays.asList(s.substring(0,1))));
        
        for(int i=1;i<s.length();i++) {
            List<List<String>> tempBigList=new ArrayList<>();
            for(int j=0;j<=i;j++) {
                String right=s.substring(j,i+1);
                if(isPalindrome(right)){
                    if(j==0) {
                        tempBigList.add(Arrays.asList(right));
                    }else {
                        List<List<String>> leftPartition=ansList.get(j-1);
                        for(List<String> partition:leftPartition) {
                            List<String> tempList=new ArrayList<>();
                            tempList.addAll(partition);
                            tempList.add(right);

                            tempBigList.add(tempList);
                        }
                    }
                }
            }
            ansList.add(tempBigList);
        }
        
        return ansList.get(ansList.size()-1);
    }
    
    public boolean isPalindrome(String s) {
        int len=s.length();
        if(len==0)
            return false;
        
        for(int i=0;i<len;i++) {
            if(s.charAt(i)!=s.charAt(len-i-1))
                return false;
        }
        return true;
    }
    
}

