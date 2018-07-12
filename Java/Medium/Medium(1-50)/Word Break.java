
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

UPDATE (2017/1/4):

The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.


*/
package medium1;

import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月13日
 */
public class WordBreak
{
    // this answer from: https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f=new boolean[s.length()+1];
        f[0]=true;
        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}

