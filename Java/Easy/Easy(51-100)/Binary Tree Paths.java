
/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

       1
     /   \
    2     3
     \
      5
All root-to-leaf paths are:

["1->2->5", "1->3"]


*/
package easy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom Qian
 * @email tomqianmaple@outlook.com
 * @github https://github.com/bluemapleman
 * @date 2018年1月28日
 */
public class BinaryTreePaths
{
//     1
//   /   \
//  2     3
//   \
//    5
    public static void main(String[] args)
    {
        TreeNode root=new TreeNode(1);
        TreeNode left1=new TreeNode(2),left2=new TreeNode(5);
        root.left=left1;left1.right=left2;
        TreeNode right1=new TreeNode(3);
        root.right=right1;
//      for(String str:binaryTreePaths(root))
//          System.out.println(str);
        System.out.println(binaryTreePaths(root));
    }
    
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new ArrayList<String>();
        if(root!=null)
            searchBT(root,"",list);
        return list;
    }
    
    // This is the solution offered by vimukthi(https://leetcode.com/problems/binary-tree-paths/discuss/68258)
    private static void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }
}



