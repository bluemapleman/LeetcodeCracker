
/*
Given a binary tree, flatten it to a linked list in-place.

For example,

Given
         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Hints:

If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月13日
 */
public class FlattenBinaryTreetoLinkedList
{
    // Recursive Method
    // Switch left sub tree to right, and assign root.left to null
    // then store original right tree in variable [temp], and invoke flatten(root.right), finally put temp to right sub tree's right, and flatten it. 
    public void flatten(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return;
        
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=null;
        
        flatten(root.right);
        
        TreeNode rightestNode=root;
        
        while(rightestNode.right!=null)
            rightestNode=rightestNode.right;
        
        rightestNode.right=temp;
        
        flatten(temp);
    }
}

