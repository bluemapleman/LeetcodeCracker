
/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16 
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4 
Explanation: The two words can be "ab", "cd".
Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0 
Explanation: No such pair of words.
*/
class Solution {
    public int maxProduct(String[] words) {
        int ans=0;
        for(int i=0;i<words.length;i++) {
            String s1=words[i];
            if(s1.length()==0)
                continue;
            int temp=ans/s1.length();
            for(int j=i+1;j<words.length;j++) {
                String s2=words[j];
                if(s2.length()>temp && !containCommonLetters(s1, s2)) {
                    temp=s2.length();
                    ans=Math.max(ans, s1.length()*s2.length());
                }
            }
        }
        return ans;
    }
    
    public boolean containCommonLetters(String s1,String s2) {
        for(int i=0;i<s1.length();i++) {
            char c=s1.charAt(i);
            if(s2.indexOf(c)!=-1)
                return true;
        }
        return false;
    }
}