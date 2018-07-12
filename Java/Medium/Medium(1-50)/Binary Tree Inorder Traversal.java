
/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:

Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

**attention: I still do it in recursively, and iterative method remains to be explored**


*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        
        if(root==null) return list;
        else{
            list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }
}

