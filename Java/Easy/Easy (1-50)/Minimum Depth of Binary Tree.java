/*

#  Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月17日
 */
public class MinimumDepthofBinaryTree
{
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2),left2=new TreeNode(4),left3=new TreeNode(5);
        root.left=left1;left1.left=left2;left2.right=left3;
        TreeNode right1=new TreeNode(3);
        root.right=right1;
        System.out.println(minDepth(root));
    }
    
    public static int minDepth(TreeNode root) {
        if(root==null)
                return 0;
        else if(root.left==null && root.right==null)
                return 1;
        else if(root.left!=null && root.right!=null)
                return 1+Math.min(minDepth(root.left), minDepth(root.right));
        else
                if(root.left!=null)
                    return 1+minDepth(root.left);
                else
                    return 1+minDepth(root.right);
    }
}
