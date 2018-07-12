
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月11日
 */
public class ValidateBinarySearchTree
{
    // First validate whether left sub node's val is smaller than root val and right sub node's val is greater than root val
    // Besides! validate that all node vals in left sub trees are smaller that root val and all node vals in right sub trees are greater than root val.
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        if(root.left==null && root.right==null)
            return true;
        
        int leftMax=findMaxValInBST(root.left, Integer.MIN_VALUE),rightMin=findMinValInBST(root.right, Integer.MAX_VALUE);
        if(root.val!=Integer.MIN_VALUE) {
            if(leftMax>=root.val)
                return false;
        }
        if(root.val!=Integer.MAX_VALUE) {
            if(rightMin<=root.val)
                return false;
        }
        
        if(root.left!=null && root.right==null)
            return root.left.val<root.val && isValidBST(root.left);
        if(root.left==null && root.right!=null)
            return root.right.val>root.val && isValidBST(root.right);
        
        return root.left.val<root.val && root.right.val>root.val && isValidBST(root.left)  && isValidBST(root.right);
        
    }
    
    public int findMaxValInBST(TreeNode root,int maxVal) {
        if(root==null)
            return maxVal;
        
        if(root.val>maxVal)
            maxVal=root.val;

        int leftMax=findMaxValInBST(root.left, maxVal),rightMax=findMaxValInBST(root.right, maxVal);
        
        return leftMax>rightMax?leftMax:rightMax;
    }
    
    public int findMinValInBST(TreeNode root,int minVal) {
        if(root==null)
            return minVal;
        
        if(root.val<minVal)
            minVal=root.val;

        int leftMin=findMinValInBST(root.left, minVal),rightMin=findMinValInBST(root.right, minVal);
        
        return leftMin<rightMin?leftMin:rightMin;
    }
}

