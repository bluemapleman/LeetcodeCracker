
/*
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxLen=0;
    public int longestUnivaluePath(TreeNode root) {
        rootLongestUnivaluePathLen(root);
        return maxLen;
    }
    
    public int rootLongestUnivaluePathLen(TreeNode root) {
        int temp=0;
        if(root==null)
            return 0;
        else {
            if(root.left!=null && root.right!=null) {
                //choose the longer same value path
                if(root.left.val==root.val && root.right.val==root.val) {
                    int leftLen=rootLongestUnivaluePathLen(root.left)+1,rightLen=rootLongestUnivaluePathLen(root.right)+1;
                    temp=Math.max(leftLen, rightLen);
                    // left chain plus right chain may be longer than chain from root
                    if(leftLen+rightLen>maxLen) {
                        maxLen=leftLen+rightLen;
                    }
                }else if(root.left.val==root.val) {
                    temp=rootLongestUnivaluePathLen(root.left)+1;
                    rootLongestUnivaluePathLen(root.right);
                }
                else if(root.right.val==root.val) {
                    temp=rootLongestUnivaluePathLen(root.right)+1;
                    rootLongestUnivaluePathLen(root.left);
                }
                else {
                    rootLongestUnivaluePathLen(root.left);
                    rootLongestUnivaluePathLen(root.right);
                }
            }else if(root.left!=null) {
                if(root.left.val==root.val)
                    temp=rootLongestUnivaluePathLen(root.left)+1;
                else
                    rootLongestUnivaluePathLen(root.left);
            }else if(root.right!=null) {
                if(root.right.val==root.val)
                    temp=rootLongestUnivaluePathLen(root.right)+1;
                else
                    rootLongestUnivaluePathLen(root.right);
            }else
                return 0;
        }
        
        if(temp>maxLen)
            maxLen=temp; 
        
        return temp;
    }
}