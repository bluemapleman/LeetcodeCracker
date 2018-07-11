/*
# Same Tree

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

```
Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```


- My Answer

*/
package easy;

/**
 *  @author Tom Qian
 *  @email tomqianmaple@outlook.com
 *  @github https://github.com/bluemapleman
 *  @date 2018年1月13日
 */
 

public class SameTree
{

    public static void main(String[] args)
    {
        TreeNode p=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        p.left=node2;
        TreeNode q=new TreeNode(1);
        TreeNode node4=new TreeNode(2);
        q.right=node4;
        System.out.println(isSameTree(p, q));

    }
    
    // Classical Recursive Method
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) {
            return true;
        }
        else if(p!=null && q!=null){
            if(p.val==q.val)
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            else
                return false;
        }
        else
            return false;
    }
    
    
}

//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
