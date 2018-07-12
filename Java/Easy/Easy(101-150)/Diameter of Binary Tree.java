
/*
[LC543](https://leetcode.com/problems/diameter-of-binary-tree/description/)

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.


*/
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class DiameterofBinaryTree
{
    public int diameterOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root!=null) {
            ans=Math.max(ans, getMaximumDepthSumOfTreeNode(root));
            ans=Math.max(ans, diameterOfBinaryTree(root.left));
            ans=Math.max(ans, diameterOfBinaryTree(root.right));
        }
        
        return ans;
    }
    
    public int getMaximumDepthSumOfTreeNode(TreeNode root) {
        if(root!=null) {
            // add the maximum depth of left sub tree to that of right sub tree
            int leftMaxDepth=getMaximumDepth(root.left),rightMaxDepth=getMaximumDepth(root.right);
            
            return leftMaxDepth+rightMaxDepth;
        }else
            return 0;
    }
    
    public int getMaximumDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        int maxDepth=Math.max(getMaximumDepth(root.left), getMaximumDepth(root.right));
        
        return 1+maxDepth;
    }
}

