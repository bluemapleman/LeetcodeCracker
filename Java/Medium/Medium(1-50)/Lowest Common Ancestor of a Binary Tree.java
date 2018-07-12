
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


*/
package medium1;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年5月4日
 */
public class LowestCommonAncestorofaBinaryTree
{
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(inSubTree(p, q)){
            return p;
        }else if(inSubTree(q, p)) {
            return q;
        }else {
            TreeNode temp=root;
            if(inSubTree(temp.left, p) && inSubTree(temp.left, q)) {
                temp=temp.left;
                return lowestCommonAncestor(temp, p, q);
            }else if (inSubTree(temp.right, p) && inSubTree(temp.right, q))
            {
                temp=temp.right;
                return lowestCommonAncestor(temp, p, q);
            }else if (inSubTree(temp.left, p) && inSubTree(temp.right, q)) {
                return root;
            }else if (inSubTree(temp.right, p) && inSubTree(temp.left, q)) {
                return root;
            }
                
            return null;
        }
    }
    
    public static boolean inSubTree(TreeNode root,TreeNode node) {
        if(root!=null) {
            if(root==node) {
                return true;
            }else {
                return inSubTree(root.left, node) || inSubTree(root.right,node);
            }
        }else {
            return false;
        }
    }
    //stack overflow solution: too many recursive
//  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//      List<TreeNode> listP=getPathToNode(root, p),listQ=getPathToNode(root, q);
//      for(int i=listP.size()-1;i>=0;i--) {
//          TreeNode temp=listP.get(i);
//          if(listQ.contains(temp))
//              return temp;
//      }
//      return null;
//    }
//  
//  public static List<TreeNode> getPathToNode(TreeNode root,TreeNode des) {
//      List<TreeNode> list=new ArrayList<>();
//      
//      if(root!=null) {
//          list.add(root);
//          List<TreeNode> left=getPathToNode(root.left, des),right=getPathToNode(root.right, des);
//          // no sub node
//          if(!left.isEmpty() && left.get(left.size()-1)==des)
//              list.addAll(left);
//          else
//              list.addAll(right);
//      }else {
//          return list;
//      }
//      
//      return list;
//  }
    
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2),left2=new TreeNode(3);
        TreeNode right1=new TreeNode(4);
        root.left=left1;left1.left=left2;
        root.right=right1;
        System.out.println(lowestCommonAncestor(root, right1, right1).val);
    }
}

