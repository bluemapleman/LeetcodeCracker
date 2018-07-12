/*
# Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

```
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
```

Note:
Bonus points if you could solve it both recursively and iteratively.

- My Answer
*/
package easy;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月16日
 */
public class SymmetricTree
{

    public static void main(String[] args)
    {
//      TreeNode root=new TreeNode(1);
//      TreeNode left1=new TreeNode(2),left2=new TreeNode(3),left3=new TreeNode(4);
//      root.left=left1;left1.left=left2;left1.right=left3;
//      TreeNode right1=new TreeNode(2),right2=new TreeNode(3),right3=new TreeNode(4);
//      root.right=right1;right1.left=right3;right1.right=right2;
//      System.out.println(isSymmetric(root));
        
//      TreeNode root=new TreeNode(1);
//      TreeNode left1=new TreeNode(2),left2=new TreeNode(3);
//      root.left=left1;left1.right=left2;
//      TreeNode right1=new TreeNode(2),right2=new TreeNode(3);
//      root.right=right1;right1.right=right2;
//      System.out.println(isSymmetric(root));
        
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2);
        root.left=left1;
        TreeNode right1=new TreeNode(3);
        root.right=right1;
        System.out.println(isSymmetric(root));
    }
    
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
    
    // My Thought: First, get the mirror of given tree, and judge whether the mirror is the same as the given tree.
    // But I don't know how to replicate trees, so my realization is not complete, just put part of my codes here as a reference... 
//  public static boolean isSymmetric(TreeNode root) {
//      TreeNode mirrorRootNode=getMirrorTree(root);
//      System.out.println(root.left.val);
//      System.out.println(mirrorRootNode.left.val);
//      return judgeSameTree(root, mirrorRootNode);
//    }
//  
//  public static TreeNode getMirrorTree(TreeNode root) {
//      if(root==null)
//          return null;
//      TreeNode temp=root.left;
//      root.left=root.right;
//      root.right=temp;
//      getMirrorTree(root.left);
//      getMirrorTree(root.right);
//      return root;
//  }
//  
//  public static boolean judgeSameTree(TreeNode root1,TreeNode root2) {
//      if(root1==null && root2==null)
//          return true;
//      if(root1==null || root2==null)
//          return false;
//      if(root1.val==root2.val) {
//          return true && judgeSameTree(root1.left, root2.left) && judgeSameTree(root1.right, root2.right);
//      }else {
//          return false;
//      }
//  }

}

