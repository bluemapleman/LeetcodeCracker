
/*
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Note:

The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000
*/

class Solution {
    // use a hashset to accelerate the process of finding root.
    public String replaceWords(List<String> dict, String sentence) {
        String ans="";
        Set<String> rootSet=new HashSet<>();
        for(String root:dict) {
            rootSet.add(root);
        }
        
        String[] splitedSen=sentence.split(" ");
        for(int i=0;i<splitedSen.length;i++) {
            String word=splitedSen[i];
            String temp="";
            for(int j=0;j<word.length() && j<=100;j++) {
                temp+=word.charAt(j);
                if(rootSet.contains(temp)) {
                    splitedSen[i]=temp;
                    break;
                }
            }
        }
        
        for(int i=0;i<splitedSen.length;i++) {
            ans+=splitedSen[i]+" ";
        }
        
        if(ans.endsWith(" "))
            ans=ans.substring(0,ans.length()-1);
        
        return ans;
    }
}
