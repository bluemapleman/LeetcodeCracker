
/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans=new ArrayList<>();

        Map<String, Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++) {
            String key=words[i];
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }else
                map.put(key, 1);
        }
        
        List<Integer> countList=new ArrayList<>();
        for(String key:map.keySet()) 
            countList.add(map.get(key));
        
        Collections.sort(countList);
        // remove elements other than top 5 most frequent words' frequency
        for(int i=0;i<map.size()-k;i++) {
            countList.remove(0);
        }
        
        for(int i=countList.size()-1;i>=0;) {
            int freq=countList.remove(i);
            
            int tempCount=1;
            // whether there are other words that have the same frequency 
            while(!countList.isEmpty() && countList.get(countList.size()-1)==freq) {
                countList.remove(countList.size()-1);
                tempCount++;
            }
            
            // use tempList to sort words with same frequency
            List<String> tempList=new ArrayList<>();
            // find all words that have same frequency and sort them according to alphabetical order
            for(String key:map.keySet()) {
                if(map.get(key)==freq)
                    tempList.add(key);
            }
            Collections.sort(tempList);
            for(String ele:tempList)
                ans.add(ele);
            
            i-=tempCount;
        }
        
        while(ans.size()>k) {
            ans.remove(ans.size()-1);
        }
        
        
        
        return ans;
    }
}
