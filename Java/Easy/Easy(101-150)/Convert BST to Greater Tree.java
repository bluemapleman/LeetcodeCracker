
/*
[LC538](https://leetcode.com/problems/convert-bst-to-greater-tree/description/)

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13


*/
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class ConvertBSTtoGreaterTree
{
    // Typical way to solve tree problem!
    // Consider how you would deal with a father node with its left sub tree and right sub tree:
    //  1. First, we hope left sub tree to be a tree that has been 'done well'.
    //  2. Then, we would add root.val+getSumOfTreeNode(root.right) to each node in left sub tree.
    //  3. Then, we deal with right sub tree to have it done well too.
    public TreeNode convertBST(TreeNode root) {
        if(root!=null) {
            convertBST(root.left);
            
            int rightSum=getSumOfTreeNode(root.right);
            int addSum=root.val+rightSum;
            
            addValueToEveryTreeNode(root.left, addSum);
            root.val+=rightSum;
            
            convertBST(root.right);
            
        }
        
        return root;
    }
    
    public void addValueToEveryTreeNode(TreeNode root,int value) {
        if(root!=null) {
            root.val+=value;
            addValueToEveryTreeNode(root.left, value);
            addValueToEveryTreeNode(root.right, value);
        }
    }
    
    public int getSumOfTreeNode(TreeNode root) {
        int sum=0;
        if(root!=null) {
            sum+=root.val;
            sum+=getSumOfTreeNode(root.left);
            sum+=getSumOfTreeNode(root.right);
        }
        return sum;
    }
}


class TreeNode{
    int val;
    TreeNode left,right;
    public TreeNode(int val)
    {
        this.val=val;
    }
}


