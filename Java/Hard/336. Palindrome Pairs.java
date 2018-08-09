/*
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
*/

class Solution {
     // solution from:https://leetcode.com/problems/palindrome-pairs/discuss/79199/150-ms-45-lines-JAVA-solution
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ans=new ArrayList<>();
		// store  words's String element and its index
		Map<String, Integer> map=new HashMap<>();
		for(int i=0;i<words.length;i++) map.put(words[i], i);
		for(int i=0;i<words.length;i++) {
			for(int j=0;j<=words[i].length();j++) {
				String word=words[i];
				String str1=word.substring(0, j),str2=word.substring(j);
				// if str1 is palindrome, then if we can find another string that is the reversion of str2, 
				// then another string + word is a palindrome too.
				if(isPalindrome(str1)) {
					String str2rvs=new StringBuilder(str2).reverse().toString();
					if(map.containsKey(str2rvs) && map.get(str2rvs)!=i) {
						ans.add(Arrays.asList(map.get(str2rvs),i));
					}
				}
				// similar for str2
				if(isPalindrome(str2)) {
					String str1rvs=new StringBuilder(str1).reverse().toString();
					// attention: here condition str2.length()!=0 avoids duplicated situation when whole word[i] is dealt with.
					if(map.containsKey(str1rvs) && map.get(str1rvs)!=i && str2.length()!=0) {
						ans.add(Arrays.asList(i,map.get(str1rvs)));
					}
				}
			}
		}
		return ans;
    }
	
	public boolean isPalindrome(String str) {
		for(int i=0;i<str.length()/2;i++) {
			if(str.charAt(i)!=str.charAt(str.length()-i-1))
				return false;
		}
		return true;
	}
}

// personal solution that exceeds time limit: O(n^2)
//List<List<Integer>> ans=new ArrayList<>();
//for(int i=0;i<words.length;i++) {
//	String currentWord=words[i];
//	for(int j=i+1;j<words.length;j++) {
//		String tempWord=words[j];
//		// simple judge whether currentWord is a reversion of tempWord
//		// if so, [i,j] and [j,i] would be two answers
//		boolean reverseFlag=true;
//		if(currentWord.length()==tempWord.length()) {
//			for(int x=0;x<currentWord.length();x++) {
//				if(currentWord.charAt(x)!=tempWord.charAt(currentWord.length()-1-x)) {
//					reverseFlag=false;
//					break;
//				}
//			}
//		}else
//			reverseFlag=false;
//		if(reverseFlag) {
//			ans.add(Arrays.asList(i,j));
//			ans.add(Arrays.asList(j,i));
//		}else {
//
//			// judge a palindrome
//			if(testPalindrome(currentWord+tempWord)) 
//				ans.add(Arrays.asList(i,j));
//			
//			if(testPalindrome(tempWord+currentWord))
//				ans.add(Arrays.asList(j,i));
//		}
//		
//	}
//}
//return ans;
