/*
# Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月17日
 */
public class BalancedBinaryTree
{
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2),left2=new TreeNode(3);
        root.left=left1;left1.left=left2;
        System.out.println(isBalanced(root));
    }
    
    public static boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        else {
            if(Math.abs(getMaxTreeDepth(root.left)-getMaxTreeDepth(root.right))<=1){
                return isBalanced(root.left) && isBalanced(root.right);
            }else {
                return false;
            }
        }
    }
    
    public static int getMaxTreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        else
            return 1+Math.max(getMaxTreeDepth(root.left),getMaxTreeDepth(root.right));
    }
}
