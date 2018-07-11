/*
# Longest Common Prefix


Write a function to find the longest common prefix string amongst an array of strings.

- My Answer

*/

package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月9日
 */
public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        String[] test={"abcsdfsd","abcserwer","abcwedsda","aberger"};
        System.out.println(longestCommonPrefix(test));

    }
    
    public static String longestCommonPrefix(String[] strs) {
        
        if(strs.length==0)
            return "";
        
        // First find the element string that has shortest length, and then iterate from index-[0] until there there were any difference between these strings
        // If iteration continue until the index-[shortestString.length()-1], then shortest string is answer
        
        int minLen=Integer.MAX_VALUE;
        for(String str:strs) {
            // if any string is "", then answer is "";
            if(str.length()==0)
                return "";
            if(str.length()<minLen)
                minLen=str.length();
        }
        
        String commonPrefix="";
        for(int i=0;i<minLen;i++) {
            String single=strs[0].substring(i, i+1);
            for(int j=1;j<strs.length;j++) {
                if(strs[j].substring(i,i+1).equals(single))
                    continue;
                else
                    return commonPrefix;
            }
            commonPrefix+=single;
        }
        
        return commonPrefix;
    }

}
