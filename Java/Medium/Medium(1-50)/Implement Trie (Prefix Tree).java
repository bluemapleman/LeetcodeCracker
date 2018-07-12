
/*
Implement a trie with insert, search, and startsWith methods.

Note:

You may assume that all inputs are consist of lowercase letters a-z.


*/
package medium1;

import java.util.HashMap;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月2日
 */
public class Trie
{
    TrieNode root;
     /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
        root.children=new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++) {
            char c=word.charAt(i);
            if(node.children==null)
                node.children=new HashMap<>();

            if(node.children.containsKey(c)) {
                node=node.children.get(c);
            }else {
                TrieNode temp=new TrieNode();
                temp.children=new HashMap<>();
                node.children.put(c, temp);
                node=temp;
            }
        }
        node.value=word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++) {
            char c=word.charAt(i);
            if(node.children.get(c)!=null) {
                node=node.children.get(c);
            }else
                return false;
        }
        
        // this node is not a leaf node, i.e. a word
        if(node.value==null)
            return false;
        else
            return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for(int i=0;i<prefix.length();i++) {
            char c=prefix.charAt(i);
            if(node.children.get(c)!=null) {
                node=node.children.get(c);
            }else
                return false;
        }
        return true;
    }
}

class TrieNode
{
    public String value;
    public HashMap<Character,TrieNode> children;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

