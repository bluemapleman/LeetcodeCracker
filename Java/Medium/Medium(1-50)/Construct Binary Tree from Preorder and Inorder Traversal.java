
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7


*/
package medium1;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年4月13日
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal
{
    
    // classical recursive problem
    // notice: any two kinds of binary tree traversal can help construct a unique binary tree (including the left one kind of traversal).  
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        
        TreeNode root=new TreeNode(preorder[0]);
        
        if(preorder.length==1)
            return root;
        
        int leftSubTreeNodeNums=-1;
        
        for(int i=0;i<inorder.length;i++)
            if(inorder[i]==root.val) {
                leftSubTreeNodeNums=i;
                break;
            }
        
        root.left=buildTree(Arrays.copyOfRange(preorder, 1, leftSubTreeNodeNums+1), Arrays.copyOfRange(inorder,0,leftSubTreeNodeNums));
        root.right=buildTree(Arrays.copyOfRange(preorder, leftSubTreeNodeNums+1, preorder.length), Arrays.copyOfRange(inorder,leftSubTreeNodeNums+1,inorder.length));
        
        return root;
    }
}

