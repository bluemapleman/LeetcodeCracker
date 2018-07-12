
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

            _______6______
           /              \
        ___2__          ___8__
       /      \        /      \
       0      _4       7       9
             /  \
             3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


*/

package easy2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月28日
 */
public class LowestCommonAncestorofaBinarySearchTree
{
//  ___6______
//    /              \
// ___2__          ___8__
///      \        /      \
//0      _4       7       9
//      /  \
//      3   5
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(6);
        TreeNode left1=new TreeNode(2),left2=new TreeNode(0),left3=new TreeNode(4),left4=new TreeNode(3),left5=new TreeNode(5);
        root.left=left1;left1.left=left2;left1.right=left3;left3.left=left4;left3.right=left5;
        TreeNode right1=new TreeNode(8),right2=new TreeNode(7),right3=new TreeNode(9);
        root.right=right1;right1.left=right2;right1.right=right3;
        System.out.println(lowestCommonAncestor(root, left1, left3).val);
    }
    
    // Since T is a binary search tree, then no two elements are the same value, and values on left sub tree are always smaller than root's value, bigger for right sub trees.
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==q || p.right==q || p.left==q)
            return p;
        else if(q.left==p || q.right==p)
            return q;
        
        // if two nodes p and q are in same sub tree, then we need to go into lower layer recursively. 
        if(root.val>p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else if (root.val<p.val && root.val<q.val) {
            return lowestCommonAncestor(root.right, p, q);
        // if p and q not in same sub tree, then root is the lowest common ancestor.
        }else {
            return root;
        }
    }
}

