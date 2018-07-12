
/*
[LC572](https://leetcode.com/problems/subtree-of-another-tree/description/)

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:
     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.

Example 2:

Given tree s:
     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.


*/
package easy3;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年6月13日
 */
public class SubtreeofAnotherTree
{
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null)
            return true;
        else if(t==null)
            return false;
        
        if(s!=null) {
            if(s.val==t.val) {
                if(sameTree(s,t))
                    return true;
            }
            
            return isSubtree(s.left, t) || isSubtree(s.right, t);
            
        }
        
        return false;
    }
    
    public boolean sameTree(TreeNode t1,TreeNode t2) {
        if(t1==null && t2==null)
            return true;
        else if(t1==null || t2==null)
            return false;
        else {
            if(t1.val==t2.val) {
                return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
            }else
                return false;
        }
    }
}

