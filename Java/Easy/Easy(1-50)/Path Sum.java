/*
# Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

- My Answer

*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月21日
 */
public class PathSum
{
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(5);
        TreeNode left1=new TreeNode(4),left2=new TreeNode(11),left3=new TreeNode(7),left4=new TreeNode(2);
        root.left=left1;left1.left=left2;left2.left=left3;left2.right=left4;
        TreeNode right1=new TreeNode(8),right2=new TreeNode(13),right3=new TreeNode(4),right4=new TreeNode(1);
        root.right=right1;right1.left=right2;right1.right=right3;right3.left=right4;
        System.out.println(hasPathSum(root,26));
        
    }
    
    // Layerwise decreasing goal value, and tried finding goal value in sub tree recursively
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        
        if(root.val==sum && root.left==null && root.right==null)
            return true;
        
        
        int goal=sum-root.val;
        return hasPathSum(root.left, goal) || hasPathSum(root.right, goal);
    }
}
