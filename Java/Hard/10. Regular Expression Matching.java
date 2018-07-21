/*

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false

*/

class Solution {
    public boolean isMatch(String s, String p) {
        // ensure that length of both s and p are greater than 1
		if(p.length()==0) {
			if(s.length()==0) return true;
			else return false;
		}
		
		if(s.length()==0) {
			String temp=new String(p);
			while(temp.contains("*")) {
				int index=temp.indexOf("*");
				temp=temp.substring(0,index-1)+temp.substring(index+1);
			}
			if(temp.length()==0)
				return true;
			else
				return false;
		}
		
		
		char c=p.charAt(0);
		// match first character
		if(c=='.' || c==s.charAt(0)) {
			if(p.length()>1) {
				char nextC=p.charAt(1);
				// next to . is *
				if(nextC=='*') {
					boolean flag=false;
					
					int sameCharCount=1;
					// can potentially match all characters
					if(c=='.')
						sameCharCount=s.length();
					else
						for(int i=0;i<s.length()-1;i++)
							if(s.charAt(i+1)==s.charAt(i))
								sameCharCount++;
							else
								break;
//					System.out.println("sameCount:"+sameCharCount);
					// test possibilities of different match
					for(int i=0;i<=sameCharCount;i++) {
						if(!flag) {
							flag= flag || isMatch(s.substring(i), p.substring(2));
						}
					}
					return flag;
				}
				// next to . is other single character
				else {
					return isMatch(s.substring(1), p.substring(1));
				}
			}else if(s.length()==1)
				return true;
			else
				return false;
		// If first chatacter doesn't match, then if second character of p is "*", it would still be OK
		}else if(p.length()>1 && p.charAt(1)=='*'){
			return isMatch(s, p.substring(2));
		}else
			return false;
		
    }
}