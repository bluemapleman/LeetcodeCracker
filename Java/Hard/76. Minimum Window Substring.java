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
   static Map<Character,Integer> rightMap;
	public static String minWindow(String s, String t) {
		if(t.equals("")) {
			if(s.equals(""))
				return "";
			else
				return s.substring(0,1);
		}
		
		rightMap=getMapForString(t);
		// no such window
		Map<Character, Integer> sMap=getMapForString(s);
		if(!isRightMapForString(sMap))
			return "";
		
		int minLen=Integer.MAX_VALUE;
		int ansArr[]=new int[s.length()];
		
		String ans="";
		
		Map<Character, Integer> shareMap=getMapForString(s.substring(0,t.length()));
		
		
		if(isRightMapForString(shareMap))
			return s.substring(0,t.length());
		else
			ansArr[t.length()-1]=0;
		
		// iterate to find whether such a window exists
		for(int i=t.length();i<s.length();i++) {
			ansArr[i]=0;
			
			char currentChar=s.charAt(i);
			
			// modify shared map
			if(shareMap.containsKey(currentChar))
				shareMap.put(currentChar, shareMap.get(currentChar)+1);
			else
				shareMap.put(currentChar,1);
			
			// some String ends with last character is an answer, so the String adds currentChar is sure to be an answer too.
			if(ansArr[i-1]!=0) {				
				int temp=0;
				while(true) {
					String lastAnsStr=s.substring(i-ansArr[i-1],i);
					char startChar=lastAnsStr.charAt(temp);
					shareMap.put(startChar,shareMap.get(startChar)-1);
					if(!isRightMapForString(shareMap)) {
						shareMap.put(startChar, shareMap.get(startChar)+1);
						
						ansArr[i]=ansArr[i-1]-temp+1;
						break;
					}
					temp++;
				}
			}// try to find first substring that satisfies condition
			else {
				if(isRightMapForString(shareMap)) {
					ansArr[i]=i+1;
				
					int temp=0;
					while(true) {
						char startChar=s.charAt(temp);
						shareMap.put(startChar,shareMap.get(startChar)-1);
						if(!isRightMapForString(shareMap)) {
							shareMap.put(startChar, shareMap.get(startChar)+1);
							ansArr[i]=i-temp+1;
							break;
						}
						temp++;
					}
				}
				
			}
		}
		
		for(int i=t.length();i<ansArr.length;i++) {
			int len=ansArr[i];
			if(len!=0 && len<minLen) {
				minLen=len;
				ans=s.substring(i-len+1,i+1);
			}
		}
		
		
        return ans;
    }
	
	
	public static boolean isRightMapForString(Map<Character, Integer> map) {
		for(Character key:rightMap.keySet()) {
			if(map.containsKey(key)) {
				if(Integer.compare(map.get(key), rightMap.get(key))<0)
					return false;
			}else
				return false;
		}
		
		return true;
	}
	
	public static Map<Character, Integer> getMapForString(String s){
		Map<Character, Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++) {
			char key=s.charAt(i);
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}else
				map.put(key, 1);
		}
		return map;
	}
}