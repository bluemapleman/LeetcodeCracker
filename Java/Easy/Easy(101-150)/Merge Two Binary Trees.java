
/*
[LC617](https://leetcode.com/problems/merge-two-binary-trees/description/)

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input: 
    Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
         3
        / \
       4   5
      / \   \ 
     5   4   7
Note: The merging process must start from the root nodes of both trees.


*/
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class MergeTwoBinaryTrees
{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root=null;
        
        if(t1!=null && t2!=null) {
            root=new TreeNode(t1.val+t2.val);
            root.left=mergeTrees(t1.left, t2.left);
            root.right=mergeTrees(t1.right, t2.right);
        }else if(t1==null && t2!=null) {
            root=new TreeNode(t2.val);
            root.left=t2.left;
            root.right=t2.right;
        }else if(t1!=null && t2==null) {
            root=new TreeNode(t1.val);
            root.left=t1.left;
            root.right=t1.right;
        }
        
        return root;
    }
}

