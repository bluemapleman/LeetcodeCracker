/*
# Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月17日
 */
public class MaximumDepthofBinaryTree
{

    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2),left2=new TreeNode(3),right1=new TreeNode(4);
        root.left=left1;left1.right=left2;root.right=right1;
        System.out.println(maxDepth(root));
    }
    
    public static int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else
                return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}
