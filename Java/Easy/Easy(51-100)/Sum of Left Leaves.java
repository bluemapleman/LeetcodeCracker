
/*
Find the sum of all left leaves in a given binary tree.

Example:
    3
   / \
  9  20
    /  \
   15   7
There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


*/

package easy2;

import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年2月5日
 */
public class SumofLeftLeaves
{
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        
        int result=0;
        if(root.left!=null && root.left.left==null && root.left.right==null)
            result+=root.left.val;
        
        return result+sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
}

