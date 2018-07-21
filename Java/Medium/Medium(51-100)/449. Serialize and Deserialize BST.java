
/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

class Solution {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        String ans="";
        if(root==null)
            return ans;
        
        ans+=root.val+",";
        ans+=serialize(root.left);
        ans+=serialize(root.right);
        
        return ans;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("")) 
            return null;
        
        // remove end comma
        data=data.substring(0,data.length()-1);
        
        // only one treenode
        if(!data.contains(","))
            return new TreeNode(Integer.valueOf(data));
        
        
        
        String[] strArr=data.split(",");
        TreeNode ans=new TreeNode(Integer.valueOf(strArr[0]));
        
        // recursively reconstruct tree
        int rightSubTreeIndex=1;
        for(;rightSubTreeIndex<strArr.length;rightSubTreeIndex++) {
            // find first right sub tree node
            if(Integer.valueOf(strArr[rightSubTreeIndex])>ans.val)
                break;
        }
        

        String temp="";
        String[] tempArr=Arrays.copyOfRange(strArr, 1, rightSubTreeIndex);
        for(String str:tempArr)
            temp+=str+",";
        ans.left=deserialize(temp);
        
        temp="";
        tempArr=Arrays.copyOfRange(strArr, rightSubTreeIndex, strArr.length);
        for(String str:tempArr)
            temp+=str+",";;
        ans.right=deserialize(temp);
        
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));