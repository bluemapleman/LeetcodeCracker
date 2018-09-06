/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

class Solution {
   public static String minWindow(String s, String t) {
		int[] map=new int[128];
		for(int i=0;i<t.length();i++) {
			map[t.charAt(i)]++;
		}
		
		int counter=t.length(),begin=0,end=0,d=Integer.MAX_VALUE,head=0;
		while(end<s.length()) {
			if(map[s.charAt(end++)]-->0) counter--;
			while(counter==0) {
				if(end-begin<d) d=end-(head=begin);
				if(map[s.charAt(begin++)]++==0) counter++;
			}
		}
		return d==Integer.MAX_VALUE?"":s.substring(head, head+d);
	}
}