
/*
[LC106](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/)

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:

You may assume that duplicates do not exist in the tree.

For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7


*/
package medium2;

import java.util.Arrays;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月26日
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal
{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
            return null;
        if(inorder.length==1)
            return new TreeNode(inorder[0]);
        
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        int leftTreeNodeSum=0;
        for(int i=0;i<inorder.length;i++)
            if(inorder[i]==root.val){
                leftTreeNodeSum=i;
                break;
            }
        
        root.left=buildTree(Arrays.copyOfRange(inorder, 0, leftTreeNodeSum), Arrays.copyOfRange(postorder, 0, leftTreeNodeSum));
        root.right=buildTree(Arrays.copyOfRange(inorder, leftTreeNodeSum+1, inorder.length), Arrays.copyOfRange(postorder, leftTreeNodeSum, postorder.length-1));
        
        return root;
    }
}


